package comp1110.ass1;

import org.junit.jupiter.api.Test;

public class OneLetterBasicPhonemesTest extends TranscriptionTest {
    public static final String[] INPUT_A = new String[]{"la", "là", "ça", "ma", "va", "mal"};
    public static final String[] EXPECTED_A = new String[]{"la", "la", "sa", "ma", "va", "mal"};

    public static final String[] INPUT_O = new String[]{"or", "vol"};
    public static final String[] EXPECTED_O = new String[]{"ɔʁ", "vɔl"};

    public static final String[] INPUT_U = new String[]{"lu", "vu", "nu", "mur", "fur"};
    public static final String[] EXPECTED_U = new String[]{"ly", "vy", "ny", "myʁ", "fyʁ"};

    @Test
    public void testA() {
        testCollection(INPUT_A, EXPECTED_A,
                "Incorrect transcription for word containing \"a\" or \"à\"");
    }

    @Test
    public void testO() {
        testCollection(INPUT_O, EXPECTED_O,
                "Incorrect transcription for word containing \"o\"");
    }

    @Test
    public void testU() {
        testCollection(INPUT_U, EXPECTED_U,
                "Incorrect transcription for word containing \"u\"");
    }
}
