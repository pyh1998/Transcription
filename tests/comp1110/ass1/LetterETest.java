package comp1110.ass1;

import org.junit.jupiter.api.Test;

public class LetterETest extends TranscriptionTest {
    public static final String[] INPUT_END_ONLY = new String[]{"le", "je"};
    public static final String[] EXPECTED_END_ONLY = new String[]{"lə", "ʒə"};

    public static final String[] INPUT_END_WORD = new String[]{"âne", "père", "tête", "poste", "roue", "laine", "rire", "gare", "sale", "rose",};
    public static final String[] EXPECTED_END_WORD = new String[]{"ɑn", "pɛʁ", "tɛt", "pɔst", "ʁu", "lɛn", "ʁiʁ", "gaʁ", "sal", "ʁɔz",};

    public static final String[] INPUT_END_SYLLABLE = new String[]{"demain", "rejeté"};
    public static final String[] EXPECTED_END_SYLLABLE = new String[]{"də.mɛ̃", "ʁə.ʒə.te"};

    public static final String[] INPUT_ELSEWHERE_SYLLABLE = new String[]{"resté", "lecteur", "examen"};
    public static final String[] EXPECTED_ELSEWHERE_SYLLABLE = new String[]{"ʁɛs.te", "lɛk.tœʁ", "ɛ.ksa.mɑ̃"};

    @Test
    public void testEndOnlyVowel() {
        testCollection(INPUT_END_ONLY, EXPECTED_END_ONLY,
                "Incorrect transcription for word ending with \"e\", where it is the only vowel");
    }

    @Test
    public void testEndWord() {
        testCollectionWithoutSyllables(INPUT_END_WORD, EXPECTED_END_WORD,
                "Incorrect transcription for word ending with \"e\"");
    }

    @Test
    public void testEndSyllable() {
        testCollection(INPUT_END_SYLLABLE, EXPECTED_END_SYLLABLE,
                "Incorrect transcription for word with \"e\" at the end of a syllable");
    }

    @Test
    public void testStartMiddleSyllable() {
        testCollection(INPUT_ELSEWHERE_SYLLABLE, EXPECTED_ELSEWHERE_SYLLABLE,
                "Incorrect transcription for word with \"e\" at the start or in the middle of a syllable");
    }
}
