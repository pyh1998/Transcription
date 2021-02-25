package comp1110.ass1;

import org.junit.jupiter.api.Test;

public class MultiLetterBasicPhonemesTest extends TranscriptionTest {

    public static final String[] INPUT_MULTIVOWEL = new String[]{"quoi", "chou", "mai", "air", "au", "eau", "neuf", "roi", "oeuf", "soeur"};
    public static final String[] EXPECTED_MULTIVOWEL = new String[]{"kwa", "ʃu", "mɛ", "ɛʁ", "o", "o", "nœf", "ʁwa", "œf", "sœʁ"};

    public static final String[] INPUT_MULTILETTER = new String[]{"chez", "nez", "fille", "veille", "paille", "ail", "bail"};
    public static final String[] EXPECTED_MULTILETTER = new String[]{"ʃe", "ne", "fij", "vɛj", "paj", "aj", "baj"};

    public static final String[] INPUT_NASAL = new String[]{"nom", "mon", "un", "an", "en", "juin", "faim", "chien", "non", "brun", "vin", "faim", "bain", "plein", "bien"};
    public static final String[] EXPECTED_NASAL = new String[]{"nɔ̃", "mɔ̃", "œ̃", "ɑ̃", "ɑ̃", "ʒyɛ̃", "fɛ̃", "ʃjɛ̃", "nɔ̃", "bʁœ̃", "vɛ̃", "fɛ̃", "bɛ̃", "plɛ̃", "bjɛ̃"};

    @Test
    public void testCompoundVowels() {
        testCollection(INPUT_MULTIVOWEL, EXPECTED_MULTIVOWEL,
                "Incorrect transcription for word containing multi-vowel phoneme");
    }

    @Test
    public void testCompoundPhonemes() {
        testCollection(INPUT_MULTILETTER, EXPECTED_MULTILETTER,
                "Incorrect transcription for word containing multi-letter phoneme");
    }

    @Test
    public void testNasals() {
        testCollection(INPUT_NASAL, EXPECTED_NASAL,
                "Incorrect transcription for word containing nasal vowel");
    }
}
