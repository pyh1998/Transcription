package comp1110.ass1;

import org.junit.jupiter.api.Test;

public class ErEzTest extends TranscriptionTest {
    public static final String[] INPUT_SINGLE = new String[]{"mer", "fer"};
    public static final String[] EXPECTED_SINGLE = new String[]{"mɛʁ", "fɛʁ"};

    public static final String[] INPUT_ER = new String[]{"parler", "montrer", "papier", "grenier", "février", "entier"};
    public static final String[] EXPECTED_ER = new String[]{"paʁ.le", "mɔ̃.tʁe", "pa.pje", "gʁə.nje", "fe.vʁje", "ɑ̃.tje"};

    public static final String[] INPUT_EZ = new String[]{"avez", "irez", "voulez", "nez", "chez", "achetez"};
    public static final String[] EXPECTED_EZ = new String[]{"a.ve", "i.ʁe", "vu.le", "ne", "ʃe", "a.ʃə.te"};

    @Test
    public void testSingleEr() {
        testCollection(INPUT_SINGLE, EXPECTED_SINGLE,
                "Incorrect transcription for single-syllable word ending with \"er\"");
    }

    @Test
    public void testMultiple() {
        testCollection(INPUT_ER, EXPECTED_ER,
                "Incorrect transcription for multi-syllable word ending with \"er\"");
    }

    @Test
    public void testMultipleEz() {
        testCollection(INPUT_EZ, EXPECTED_EZ,
                "Incorrect transcription for word ending with \"ez\"");
    }
}
