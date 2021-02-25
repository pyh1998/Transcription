package comp1110.ass1;

import org.junit.jupiter.api.Test;

public class SyllablesTest extends TranscriptionTest{

    public static final String[] TWO_SYLLABLES_IN = new String[]{"métal", "obéir", "final", "couloir", "aucun", "unir",
            "beauté", "décor", "postal", "canon", "voilà", "grandir", "malin", "été", "pareil", "château", "travail", "soleil", "bouteille"};
    public static final String[] TWO_SYLLABLES_EXP = new String[]{"me.tal", "ɔ.beiʁ", "fi.nal", "ku.lwaʁ", "o.kœ̃", "y.niʁ",
            "bo.te", "de.kɔʁ", "pɔs.tal", "ka.nɔ̃", "vwa.la", "gʁɑ̃.diʁ", "ma.lɛ̃", "e.te", "pa.ʁɛj", "ʃɑ.to", "tʁa.vaj", "sɔ.lɛj", "bu.tɛj"};

    public static final String[] THREE_SYLLABLES_IN = new String[]{"hôpital", "retrouvé", "caméra", "équipé", "réfléchi", "primitif"};
    public static final String[] THREE_SYLLABLES_EXP = new String[]{"o.pi.tal", "ʁə.tʁu.ve", "ka.me.ʁa", "e.ki.pe", "ʁe.fle.ʃi", "pʁi.mi.tif"};

    public static final String[] FIVE_SYLLABLES_IN = new String[]{"sensibilité"};
    public static final String[] FIVE_SYLLABLES_EXP = new String[]{"sɑ̃.si.bi.li.te"};

    @Test
    public void testTwoSyllables() {
        testCollection(TWO_SYLLABLES_IN, TWO_SYLLABLES_EXP,
                "Incorrect transcription for word with two syllables");
    }

    @Test
    public void testThreeSyllables() {
        testCollection(THREE_SYLLABLES_IN, THREE_SYLLABLES_EXP,
                "Incorrect transcription for word with three syllables");
    }

    @Test
    public void testFiveSyllables() {
        testCollection(FIVE_SYLLABLES_IN, FIVE_SYLLABLES_EXP,
                "Incorrect transcription for word with five syllables");
    }
}
