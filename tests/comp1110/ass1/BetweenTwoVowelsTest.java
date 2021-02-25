package comp1110.ass1;

import org.junit.jupiter.api.Test;

public class BetweenTwoVowelsTest extends TranscriptionTest {

    public static final String[] INPUT_SOUND_S = new String[]{"supplément", "saut", "inspiré", "prospérité",
            "soif", "poisson", "sauté", "lissé"};
    public static final String[] EXPECTED_SOUND_S = new String[]{"sy.ple.mɑ̃", "so", "ɛ̃s.pi.ʁe", "pʁɔs.pe.ʁi.te",
            "swaf", "pwa.sɔ̃", "so.te", "li.se"};

    public static final String[] INPUT_SOUND_Z = new String[]{"trésor", "hasard", "présidé", "raison"};
    public static final String[] EXPECTED_SOUND_Z = new String[]{"tʁe.zɔʁ", "a.zaʁ", "pʁe.zi.de", "ʁɛ.zɔ̃"};

    public static final String[] INPUT_BOTH_SOUNDS = new String[]{"stabilisé", "décisif", "suffisant"};
    public static final String[] EXPECTED_BOTH_SOUNDS = new String[]{"sta.bi.li.ze", "de.si.zif", "sy.fi.zɑ̃"};

    @Test
    public void testSoundS() {
        testCollection(INPUT_SOUND_S, EXPECTED_SOUND_S,
                "Incorrect transcription for word with \"s\" not between two vowels");
    }

    @Test
    public void testSoundZ() {
        testCollection(INPUT_SOUND_Z, EXPECTED_SOUND_Z,
                "Incorrect transcription for word with \"s\" between two vowels");
    }

    @Test
    public void testBothSounds() {
        testCollection(INPUT_BOTH_SOUNDS, EXPECTED_BOTH_SOUNDS,
                "Incorrect transcription for word with \"s\" occurring both between two vowels and elsewhere");
    }
}
