package comp1110.ass1;

import org.junit.jupiter.api.Test;

public class VowelOrConsonantIYTest extends TranscriptionTest {
    public static final String[] INPUT_I_BEFORE_VOWEL = new String[]{"hier", "fier" /* proud */};
    public static final String[] EXPECTED_I_BEFORE_VOWEL = new String[]{"jɛʁ", "fjɛʁ"};

    public static final String[] INPUT_I_ELSEWHERE = new String[]{"ski", "qui", "mis", "paris", "dispositif", "disputé"};
    public static final String[] EXPECTED_I_ELSEWHERE = new String[]{"ski", "ki", "mi", "pa.ʁi", "dis.pɔ.zi.tif", "dis.py.te"};

    public static final String[] INPUT_Y_BEFORE_VOWEL = new String[]{"yeux", "yaourt", "voyagé"};
    public static final String[] EXPECTED_Y_BEFORE_VOWEL = new String[]{"jœ", "jauʁ", "vɔ.ja.ʒe"};

    public static final String[] INPUT_Y_ELSEWHERE = new String[]{"y", "systèmatisé", "hypothétisé", "stylé", "cybercriminalité"};
    public static final String[] EXPECTED_Y_ELSEWHERE = new String[]{"i", "sis.tɛ.ma.ti.ze", "i.pɔ.te.ti.ze", "sti.le", "si.bɛʁ.kʁi.mi.na.li.te"};

    @Test
    public void testIBeforeVowel() {
        testCollection(INPUT_I_BEFORE_VOWEL, EXPECTED_I_BEFORE_VOWEL,
                "Incorrect transcription for word with \"i\" before another vowel");
    }

    @Test
    public void testIElsewhere() {
        testCollection(INPUT_I_ELSEWHERE, EXPECTED_I_ELSEWHERE,
                "Incorrect transcription for word including \"i\" not before another vowel");
    }

    @Test
    public void testYBeforeVowel() {
        testCollection(INPUT_Y_BEFORE_VOWEL, EXPECTED_Y_BEFORE_VOWEL,
                "Incorrect transcription for word with \"y\" before another vowel");
    }

    @Test
    public void testYElsewhere() {
        testCollection(INPUT_Y_ELSEWHERE, EXPECTED_Y_ELSEWHERE,
                "Incorrect transcription for word including \"y\" not before another vowel");
    }
}
