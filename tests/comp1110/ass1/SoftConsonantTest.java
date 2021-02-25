package comp1110.ass1;

import org.junit.jupiter.api.Test;

public class SoftConsonantTest extends TranscriptionTest {
    public static final String[] INPUT_SOFT_C = new String[]{"ceci", "celui", "lycées"};
    public static final String[] EXPECTED_SOFT_C = new String[]{"sə.si", "sə.lyi", "li.se"};

    public static final String[] INPUT_HARD_C = new String[]{"car", "cout", "recours"};
    public static final String[] EXPECTED_HARD_C = new String[]{"kaʁ", "ku", "ʁə.kuʁ"};

    public static final String[] INPUT_SOFT_G = new String[]{"général", "égards"};
    public static final String[] EXPECTED_SOFT_G = new String[]{"ʒe.ne.ʁal", "e.gaʁ"};

    public static final String[] INPUT_HARD_G = new String[]{"gourd", "réglé"};
    public static final String[] EXPECTED_HARD_G = new String[]{"guʁ", "ʁe.gle"};

    @Test
    public void testSoftHardC() {
        testCollection(INPUT_SOFT_C, EXPECTED_SOFT_C,
                "Incorrect transcription for word containing \"c\"before \"i\" or \"e\"");

        testCollection(INPUT_HARD_C, EXPECTED_HARD_C,
                "Incorrect transcription for word containing \"c\" not before \"i\" or \"e\"");
    }

    @Test
    public void testSoftHardG() {
        testCollection(INPUT_SOFT_G, EXPECTED_SOFT_G,
                "Incorrect transcription for word containing \"g\"before \"i\" or \"e\"");

        testCollection(INPUT_HARD_G, EXPECTED_HARD_G,
                "Incorrect transcription for word containing \"g\" not before \"i\" or \"e\"");
    }
}
