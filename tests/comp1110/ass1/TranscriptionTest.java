package comp1110.ass1;

import org.junit.jupiter.api.Assertions;

public class TranscriptionTest {
    public void testCollection(String[] in, String[] exp, String message) {
        for (int i = 0; i < in.length; i++) {
            String out = "";
            try {
                out = Word.fromString(in[i]).transcribe();
            } catch (Exception e) {
                System.err.println("Exception transcribing word: " + in[i]);
                e.printStackTrace();
            }
            Assertions.assertEquals(exp[i], out, message + " (" + in[i] + "):");
        }
    }

    public void testCollectionWithoutSyllables(String[] in, String[] exp, String message) {
        for (int i = 0; i < in.length; i++) {
            String out = "";
            try {
                // eliminate syllable boundaries, to avoid dependency on condense syllables task
                out = Word.fromString(in[i]).transcribe().replaceAll("\\.", "");
            } catch (Exception e) {
                System.err.println("Exception transcribing word: " + in[i]);
                e.printStackTrace();
            }
            Assertions.assertEquals(exp[i], out, message + " (" + in[i] + "):");
        }
    }
}
