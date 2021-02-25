package comp1110.ass1;

import org.junit.jupiter.api.Test;

public class LastPhonemeSilentTest extends TranscriptionTest {

    public static final String[] ENDS_IN_B = new String[]{"plomb"};
    public static final String[] ENDS_IN_B_EXP = new String[]{"plɔ̃"};

    public static final String[] ENDS_IN_D = new String[]{"lard", "bord"};
    public static final String[] ENDS_IN_D_EXP = new String[]{"laʁ", "bɔʁ"};

    public static final String[] ENDS_IN_G = new String[]{"sang", "long"};
    public static final String[] ENDS_IN_G_EXP = new String[]{"sɑ̃", "lɔ̃"};

    public static final String[] ENDS_IN_P = new String[]{"champ", "camp"};
    public static final String[] ENDS_IN_P_EXP = new String[]{"ʃɑ̃", "kɑ̃"};

    public static final String[] ENDS_IN_S = new String[]{"ours", "vols", "dos", "bas", "temps"};
    public static final String[] ENDS_IN_S_EXP = new String[]{"uʁ", "vɔl", "dɔ", "ba", "tɑ̃"};

    public static final String[] ENDS_IN_T = new String[]{"chat", "fort"};
    public static final String[] ENDS_IN_T_EXP = new String[]{"ʃa", "fɔʁ"};

    public static final String[] ENDS_IN_X = new String[]{"choux", "feux"};
    public static final String[] ENDS_IN_X_EXP = new String[]{"ʃu", "fœ"};

    public static final String[] ENDS_IN_E = new String[]{"roue", "voie", "vue", "née"};
    public static final String[] ENDS_IN_E_EXP = new String[]{"ʁu", "vwa", "vy", "ne"};

    @Test
    public void testEndsInB() {
        testCollection(ENDS_IN_B, ENDS_IN_B_EXP,
                "Incorrect transcription for word ending in \"b\"");
    }

    @Test
    public void testEndsInD() {
        testCollection(ENDS_IN_D, ENDS_IN_D_EXP,
                "Incorrect transcription for word ending in \"d\"");
    }

    @Test
    public void testEndsInG() {
        testCollection(ENDS_IN_G, ENDS_IN_G_EXP,
                "Incorrect transcription for word ending in \"g\"");
    }

    @Test
    public void testEndsInP() {
        testCollection(ENDS_IN_P, ENDS_IN_P_EXP,
                "Incorrect transcription for word ending in \"p\"");
    }

    @Test
    public void testEndsInS() {
        testCollection(ENDS_IN_S, ENDS_IN_S_EXP,
                "Incorrect transcription for word ending in \"s\"");
    }

    @Test
    public void testEndsInT() {
        testCollection(ENDS_IN_T, ENDS_IN_T_EXP,
                "Incorrect transcription for word ending in \"t\"");
    }

    @Test
    public void testEndsInX() {
        testCollection(ENDS_IN_X, ENDS_IN_X_EXP,
                "Incorrect transcription for word ending in \"x\"");
    }

    @Test
    public void testEndsInE() {
        testCollection(ENDS_IN_E, ENDS_IN_E_EXP,
                "Incorrect transcription for word ending in \"e\"");
    }
}
