package comp1110.ass1;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.polly.AmazonPollyClient;
import com.amazonaws.services.polly.model.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class TranscriberGUI extends Application {
    static final int FONT_SIZE = 16;
    static final String CIRCUMFLEX = "ˆ";
    static final String DIARESIS = "¨";
    static final String GRAVE_ACCENT = "`";

    public static void main(String[] args) {
        launch(args);
    }

    static final String[][] BASIC_KEYBOARD = {
            {"é", "", "'", "", "-", "", "è", "", "ç", "à"},
            {"a", "z", "e", "r", "t", "y", "u", "i", "o", "p", CIRCUMFLEX},
            {"q", "s", "f", "g", "h", "j", "l", "m", "ù", GRAVE_ACCENT},
            {"w", "x", "c", "v", "b", "n"},
    };

    static final String[][] SHIFTED_KEYBOARD = {
            {"É", "", "", "", "", "", "È", "", "Ç", "À"},
            {"A", "Z", "E", "R", "T", "Y", "U", "I", "O", "P", DIARESIS},
            {"Q", "S", "F", "G", "H", "J", "L", "M", "Ù", ""},
            {"W", "X", "C", "V", "B", "N"},
    };

    static final List<String> VOWELS = List.of("a", "e", "i", "o", "u", "y");
    static final List<String> GRAVE_VOWELS = List.of("à", "è", "", "", "ù", "");
    static final List<String> CIRCUMFLEX_VOWELS = List.of("â", "ê", "î", "ô", "û", "");
    static final List<String> DIARESIS_VOWELS = List.of("", "ë", "ï", "", "ü", "ÿ");

    static class ShiftableKey extends Button {
        String basic;
        String shift;

        ShiftableKey(String basic, String shift) {
            super(basic);
            this.basic = basic;
            this.shift = shift;
        }

        public void shift() {
            if (this.shift.isEmpty()) {
                this.setDisable(true);
            } else {
                if (this.getText().equals(CIRCUMFLEX)) {
                    this.setText(DIARESIS);
                } else {
                    this.setText(this.getText().toUpperCase());
                }
                this.setDisable(false);
            }
        }

        public void reset() {
            this.setText(basic);
            this.setDisable(this.basic.isEmpty());
        }
    }

    TextField source, target;
    List<ShiftableKey> keys = new ArrayList<>();
    Button shift;
    boolean shifted = false;

    // AWS Polly for text-to-speech
    private AmazonPollyClient polly;
    private Voice voice;

    // input stream for speech player
    InputStream speechStream;

    @Override
    public void start(Stage primaryStage) {
        setupTTS();
        primaryStage.setTitle("Transcriber");
        Group root = new Group();
        Scene scene = new Scene(root, 960, 360);
        scene.getStylesheets().add("comp1110/ass1/resources/default.css");
        primaryStage.setScene(scene);

        HBox textRow = new HBox();
        textRow.setLayoutX(15);
        textRow.setLayoutY(50);

        source = new TextField();
        source.setMinWidth(250);
        source.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode().equals(KeyCode.ENTER)) {
                transcribe();
                Platform.runLater(() -> playTTS());
            }
        });
        Label sourceLabel = new Label("French");
        sourceLabel.setLabelFor(source);
        textRow.getChildren().add(sourceLabel);
        textRow.getChildren().add(source);

        Button transcribeButton = new Button("Transcribe");
        transcribeButton.setOnAction(actionEvent -> transcribe());
        textRow.getChildren().add(transcribeButton);

        target = new TextField();
        target.setMinWidth(250);
        Label targetLabel = new Label("IPA");
        targetLabel.setLabelFor(target);
        textRow.getChildren().add(targetLabel);
        textRow.getChildren().add(target);
        textRow.setSpacing(12);

        Image speakerIcon = new Image(getClass().getResourceAsStream("resources/speakerIcon.png"));
        Button playButton = new Button("Speak", new ImageView(speakerIcon));
        playButton.setOnAction(actionEvent -> playTTS());
        textRow.getChildren().add(playButton);

        root.getChildren().add(textRow);

        Group keyboard = createKeyboard();
        root.getChildren().add(keyboard);

        primaryStage.show();
    }

    private Group createKeyboard() {
        // create the special Shift button
        shift = new Button("⇧");
        shift.setMinWidth(FONT_SIZE * 4.8);
        shift.setFocusTraversable(false);
        shift.setOnAction(actionEvent -> {
            if (shifted) shiftDown();
            else shiftUp();
        });

        VBox keyBox = new VBox();
        keyBox.setSpacing(1);
        for (int row = 0; row < BASIC_KEYBOARD.length; row++) {
            HBox rank = new HBox();
            rank.setSpacing(1);
            if (row == 3) {
                rank.getChildren().add(shift);
            }
            for (int k = 0; k < BASIC_KEYBOARD[row].length; k++) {
                String basic = BASIC_KEYBOARD[row][k];
                ShiftableKey key = new ShiftableKey(basic, SHIFTED_KEYBOARD[row][k]);
                key.setFocusTraversable(false);
                key.setMinWidth(FONT_SIZE * 3.1);
                rank.getChildren().add(key);
                if (basic.isEmpty()) {
                    key.setDisable(true);
                } else if (basic.equals(CIRCUMFLEX) || basic.equals(GRAVE_ACCENT)) {
                    key.setOnAction((actionEvent) -> {
                        prepareAccent(key.getText());
                    });
                    keys.add(key);
                } else {
                    key.setOnAction((actionEvent) -> {
                        source.replaceText(source.getSelection(), key.getText());
                        shiftDown();
                        shift.setDisable(false);
                    });
                    keys.add(key);
                }
            }
            if (row != 3) {
                VBox.setMargin(rank, new Insets(0, 0, 0, FONT_SIZE * 1.55 * row));
            }
            keyBox.getChildren().add(rank);
        }

        Group keyboard = new Group();
        keyboard.getChildren().add(keyBox);
        keyboard.setLayoutX(160);
        keyboard.setLayoutY(110);
        return keyboard;
    }

    private void prepareAccent(String accent) {
        shiftDown();
        for (ShiftableKey key : keys) {
            if (VOWELS.contains(key.basic)) {
                List<String> accentedVowels = switch (accent) {
                    case DIARESIS:
                        yield DIARESIS_VOWELS;
                    case GRAVE_ACCENT:
                        yield GRAVE_VOWELS;
                    case CIRCUMFLEX:
                        yield CIRCUMFLEX_VOWELS;
                    default:
                        yield VOWELS;
                };
                int vowelIdx = VOWELS.indexOf(key.basic);
                String accented = accentedVowels.get(vowelIdx);
                if (accented.isEmpty()) {
                    key.setText(key.basic);
                    key.setDisable(true);
                } else {
                    if (shifted) accented = accented.toUpperCase();
                    key.setText(accented);
                    key.setDisable(false);
                }
            } else {
                key.setDisable(true);
            }
        }
    }

    private void shiftUp() {
        for (ShiftableKey key : keys) {
            if (!key.isDisabled()) {
                key.shift();
            }
        }
        shifted = true;
    }

    private void shiftDown() {
        for (ShiftableKey key : keys) {
            key.reset();
        }
        shifted = false;
    }

    private void transcribe() {
        String word = source.getText()
                .toLowerCase()
                .strip()
                .replaceAll(" ", "")
                .replaceAll("\\p{Punct}", "");

        if (word.isEmpty()) {
            target.setText("");
        } else {
            try {
                Word w = Word.fromString(word);
                target.setText(w.transcribe());
            } catch (Exception e) {
                System.err.println("Exception transcribing word: " + word);
                e.printStackTrace();
                target.setText("");
            }
        }
    }

    private void setupTTS() {
        // TODO turn this into an AWS lambda service with separate (reduced) credentials
        System.setProperty("aws.accessKeyId", "AKIAYBOPJX3R374OHIOZ");
        System.setProperty("aws.secretKey", "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");
        // create an Amazon Polly client in a specific region
        polly = new AmazonPollyClient(new DefaultAWSCredentialsProviderChain());
        polly.setRegion(Region.getRegion(Regions.AP_SOUTHEAST_2));

        // Ask Amazon Polly to describe available French TTS voices
        DescribeVoicesRequest describeVoicesRequest = new DescribeVoicesRequest();
        describeVoicesRequest.setLanguageCode("fr-FR");
        DescribeVoicesResult describeVoicesResult = polly.describeVoices(describeVoicesRequest);
        //for (Voice voice : describeVoicesResult.getVoices()) {
        //    System.out.println(voice);
        //}
        voice = describeVoicesResult.getVoices().get(0);
    }

    private void playTTS() {
        String phonetic = target.getText();
        // request Amazon Polly to synthesize speech from the target text as IPA to MP3 output
        SynthesizeSpeechRequest synthReq =
                new SynthesizeSpeechRequest().withTextType("ssml")
                        .withText("<phoneme alphabet=\"ipa\" ph=\"" + phonetic + "\"></phoneme>")
                        .withLanguageCode("fr-FR")
                        .withVoiceId(voice.getId())
                        .withOutputFormat(OutputFormat.Mp3);
        SynthesizeSpeechResult synthRes = polly.synthesizeSpeech(synthReq);

        try {
            // play the speech stream
            AdvancedPlayer player = new AdvancedPlayer(synthRes.getAudioStream(),
                    javazoom.jl.player.FactoryRegistry.systemRegistry().createAudioDevice());

            player.setPlayBackListener(new PlaybackListener() {
                @Override
                public void playbackStarted(PlaybackEvent evt) {
                    System.out.print("/" + phonetic);
                }

                @Override
                public void playbackFinished(PlaybackEvent evt) {
                    System.out.println("/");
                }
            });
            player.play();
        } catch (JavaLayerException e) {
            System.err.println("Could not create player");
            e.printStackTrace();
        }
    }
}
