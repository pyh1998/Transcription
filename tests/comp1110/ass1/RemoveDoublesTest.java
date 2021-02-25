package comp1110.ass1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RemoveDoublesTest {

    public static final Word TASSE = new Word("tasse",
            new Syllable[]{
                    new Syllable(new Phoneme[]{
                            new Phoneme("t", "t", false),
                            new Phoneme("a", "a", true),
                            new Phoneme("s", "s", false),
                            new Phoneme("s", "s", false),
                            new Phoneme("e", "", true)
                    })
            }
    );
    public static final String TASSE_EXP = "tas";

    public static final Word SALLE = new Word("salle",
            new Syllable[]{
                    new Syllable(new Phoneme[]{
                            new Phoneme("s", "s", false),
                            new Phoneme("a", "a", true),
                            new Phoneme("l", "l", false),
                            new Phoneme("l", "l", false),
                            new Phoneme("e", "", true)
                    })
            }
    );
    public static final String SALLE_EXP = "sal";

    public static final Word BALLE = new Word("balle",
            new Syllable[]{
                    new Syllable(new Phoneme[]{
                            new Phoneme("b", "b", false),
                            new Phoneme("a", "a", true),
                            new Phoneme("l", "l", false),
                            new Phoneme("l", "l", false),
                            new Phoneme("e", "", true)
                    })
            }
    );
    public static final String BALLE_EXP = "bal";

    public static final Word BONNE = new Word("bonne",
            new Syllable[]{
                    new Syllable(new Phoneme[]{
                            new Phoneme("b", "b", false),
                            new Phoneme("o", "ɔ", true),
                            new Phoneme("n", "n", false),
                            new Phoneme("n", "n", false),
                            new Phoneme("e", "", true)
                    })
            }
    );
    public static final String BONNE_EXP = "bɔn";

    public static final Word PATTE = new Word("patte",
            new Syllable[]{
                    new Syllable(new Phoneme[]{
                            new Phoneme("p", "p", false),
                            new Phoneme("a", "a", true),
                            new Phoneme("t", "t", false),
                            new Phoneme("t", "t", false),
                            new Phoneme("e", "", true)
                    })
            }
    );
    public static final String PATTE_EXP = "pat";

    public static final Word HONNEUR = new Word("honneur",
            new Syllable[]{
                    new Syllable(new Phoneme[]{
                            new Phoneme("h", "", false),
                            new Phoneme("o", "ɔ", true),
                            new Phoneme("n", "n", false)
                    }),
                    new Syllable(new Phoneme[]{
                            new Phoneme("n", "n", false),
                            new Phoneme("eu", "œ", true),
                            new Phoneme("r", "ʁ", false)
                    })
            }
    );
    public static final String HONNEUR_EXP = "ɔ.nœʁ";

    public static final Word BALLET = new Word("ballet",
            new Syllable[]{
                    new Syllable(new Phoneme[]{
                            new Phoneme("b", "b", false),
                            new Phoneme("a", "a", true),
                            new Phoneme("l", "l", false)
                    }),
                    new Syllable(new Phoneme[]{
                            new Phoneme("l", "l", false),
                            new Phoneme("e", "ɛ", true),
                            new Phoneme("t", "", false)
                    })
            }
    );
    public static final String BALLET_EXP = "ba.lɛ";

    public static final Word APPELLE = new Word("appèlle",
            new Syllable[]{
                    new Syllable(new Phoneme[]{
                            new Phoneme("a", "a", true),
                            new Phoneme("p", "p", false)
                    }),
                    new Syllable(new Phoneme[]{
                            new Phoneme("p", "p", false),
                            new Phoneme("e", "ɛ", true),
                            new Phoneme("l", "l", false),
                            new Phoneme("l", "l", false),
                            new Phoneme("e", "", true)
                    })
            }
    );
    public static final String APPELLE_EXP = "a.pɛl";

    public static final Word NOURRIR = new Word("nourrir",
            new Syllable[]{
                    new Syllable(new Phoneme[]{
                            new Phoneme("n", "n", false),
                            new Phoneme("ou", "u", true),
                            new Phoneme("r", "ʁ", false)
                    }),
                    new Syllable(new Phoneme[]{
                            new Phoneme("r", "ʁ", false),
                            new Phoneme("i", "i", true),
                            new Phoneme("r", "ʁ", false)
                    })
            }
    );
    public static final String NOURRIR_EXP = "nu.ʁiʁ";

    public static final Word APPUYER = new Word("appuyer",
            new Syllable[]{
                    new Syllable(new Phoneme[]{
                            new Phoneme("a", "a", true),
                            new Phoneme("p", "p", false)
                    }),
                    new Syllable(new Phoneme[]{
                            new Phoneme("p", "p", false),
                            new Phoneme("u", "y", true)
                    }),
                    new Syllable(new Phoneme[]{
                            new Phoneme("y", "j", false),
                            new Phoneme("er", "e", true)
                    })
            }
    );
    public static final String APPUYER_EXP = "a.py.je";

    public static final Word RATIONNEL = new Word("rationnel",
            new Syllable[]{
                    new Syllable(new Phoneme[]{
                            new Phoneme("r", "ʁ", false),
                            new Phoneme("a", "a", true)
                    }),
                    new Syllable(new Phoneme[]{
                            new Phoneme("t", "s", false),
                            new Phoneme("i", "j", true),
                            new Phoneme("o", "ɔ", true),
                            new Phoneme("n", "n", false)
                    }),
                    new Syllable(new Phoneme[]{
                            new Phoneme("n", "n", false),
                            new Phoneme("e", "ɛ", true),
                            new Phoneme("l", "l", false)
                    })
            }
    );
    public static final String RATIONNEL_EXP = "ʁa.sjɔ.nɛl";

    public static final Word HIRONDELLE = new Word("hirondelle",
            new Syllable[]{
                    new Syllable(new Phoneme[]{
                            new Phoneme("h", "", false),
                            new Phoneme("i", "i", true)
                    }),
                    new Syllable(new Phoneme[]{
                            new Phoneme("r", "ʁ", false),
                            new Phoneme("on", "ɔ̃", true)
                    }),
                    new Syllable(new Phoneme[]{
                            new Phoneme("d", "d", false),
                            new Phoneme("e", "ɛ", true),
                            new Phoneme("l", "l", false),
                            new Phoneme("l", "l", false),
                            new Phoneme("e", "", true)
                    })
            }
    );
    public static final String HIRONDELLE_EXP = "i.ʁɔ̃.dɛl";

    public static final Word ATTAQUER = new Word("attaquer",
            new Syllable[]{
                    new Syllable(new Phoneme[]{
                            new Phoneme("a", "a", true),
                            new Phoneme("t", "t", false)
                    }),
                    new Syllable(new Phoneme[]{
                            new Phoneme("t", "t", false),
                            new Phoneme("a", "a", true)
                    }),
                    new Syllable(new Phoneme[]{
                            new Phoneme("qu", "k", false),
                            new Phoneme("er", "e", true)
                    })
            }
    );
    public static final String ATTAQUER_EXP = "a.ta.ke";

    public static final Word DEVELOPPEUR = new Word("développeur",
            new Syllable[]{
                    new Syllable(new Phoneme[]{
                            new Phoneme("d", "d", false),
                            new Phoneme("é", "e", true)
                    }),
                    new Syllable(new Phoneme[]{
                            new Phoneme("v", "v", false),
                            new Phoneme("e", "ə", true)
                    }),
                    new Syllable(new Phoneme[]{
                            new Phoneme("l", "l", false),
                            new Phoneme("o", "ɔ", true),
                            new Phoneme("p", "p", false)
                    }),
                    new Syllable(new Phoneme[]{
                            new Phoneme("p", "p", false),
                            new Phoneme("eu", "œ", true),
                            new Phoneme("r", "ʁ", false)
                    })
            }
    );
    public static final String DEVELOPPEUR_EXP = "de.və.lɔ.pœʁ";

    public static final Word EXCEPTIONNEL = new Word("exceptionnel",
            new Syllable[]{
                    new Syllable(new Phoneme[]{
                            new Phoneme("e", "ɛ", true),
                            new Phoneme("x", "k", false)
                    }),
                    new Syllable(new Phoneme[]{
                            new Phoneme("c", "s", false),
                            new Phoneme("e", "ɛ", true),
                            new Phoneme("p", "p", false)
                    }),
                    new Syllable(new Phoneme[]{
                            new Phoneme("t", "s", false),
                            new Phoneme("i", "j", true),
                            new Phoneme("o", "ɔ", true),
                            new Phoneme("n", "n", false)
                    }),
                    new Syllable(new Phoneme[]{
                            new Phoneme("n", "n", false),
                            new Phoneme("e", "ɛ", true),
                            new Phoneme("l", "l", false)
                    })
            }
    );
    public static final String EXCEPTIONNEL_EXP = "ɛk.sɛp.sjɔ.nɛl";

    public static final Word MADEMOISELLE = new Word("mademoiselle",
            new Syllable[]{
                    new Syllable(new Phoneme[]{
                            new Phoneme("m", "m", false),
                            new Phoneme("a", "a", true)
                    }),
                    new Syllable(new Phoneme[]{
                            new Phoneme("d", "d", false),
                            new Phoneme("e", "ə", true)
                    }),
                    new Syllable(new Phoneme[]{
                            new Phoneme("m", "m", false),
                            new Phoneme("oi", "wa", true)
                    }),
                    new Syllable(new Phoneme[]{
                            new Phoneme("s", "z", false),
                            new Phoneme("e", "ɛ", true),
                            new Phoneme("l", "l", false),
                            new Phoneme("l", "l", false),
                            new Phoneme("e", "", true)
                    })
            }
    );
    public static final String MADEMOISELLE_EXP = "ma.də.mwa.zɛl";

    public static final Word ATTACHEMENT = new Word("attachement",
            new Syllable[]{
                    new Syllable(new Phoneme[]{
                            new Phoneme("a", "a", true),
                            new Phoneme("t", "t", false)
                    }),
                    new Syllable(new Phoneme[]{
                            new Phoneme("t", "t", false),
                            new Phoneme("a", "a", true)
                    }),
                    new Syllable(new Phoneme[]{
                            new Phoneme("ch", "ʃ", false),
                            new Phoneme("e", "ə", true)
                    }),
                    new Syllable(new Phoneme[]{
                            new Phoneme("m", "m", false),
                            new Phoneme("en", "ɑ̃", true),
                            new Phoneme("t", "", false)
                    })
            }
    );
    public static final String ATTACHEMENT_EXP = "a.ta.ʃə.mɑ̃";

    public static final Word[] ONE_SYLLABLE_IN = new Word[]{TASSE, SALLE, BALLE, BONNE, PATTE};
    public static final String[] ONE_SYLLABLE_EXP = new String[]{TASSE_EXP, SALLE_EXP, BALLE_EXP, BONNE_EXP, PATTE_EXP};

    // TODO science
    public static final Word[] TWO_SYLLABLES_IN = new Word[]{HONNEUR, BALLET, APPELLE, NOURRIR};
    public static final String[] TWO_SYLLABLES_EXP = new String[]{HONNEUR_EXP, BALLET_EXP, APPELLE_EXP, NOURRIR_EXP};

    public static final Word[] THREE_SYLLABLES_IN = new Word[]{APPUYER, RATIONNEL, HIRONDELLE, ATTAQUER};
    public static final String[] THREE_SYLLABLES_EXP = new String[]{APPUYER_EXP, RATIONNEL_EXP, HIRONDELLE_EXP, ATTAQUER_EXP};

    public static final Word[] FOUR_SYLLABLES_IN = new Word[]{DEVELOPPEUR, MADEMOISELLE, EXCEPTIONNEL, ATTACHEMENT};
    public static final String[] FOUR_SYLLABLES_EXP = new String[]{DEVELOPPEUR_EXP, MADEMOISELLE_EXP, EXCEPTIONNEL_EXP, ATTACHEMENT_EXP};

    @Test
    public void testOneSyllable() {
        testCollections(ONE_SYLLABLE_IN, ONE_SYLLABLE_EXP);
    }

    @Test
    public void testTwoSyllables() {
        testCollections(TWO_SYLLABLES_IN, TWO_SYLLABLES_EXP);
    }

    @Test
    public void testThreeSyllables() {
        testCollections(THREE_SYLLABLES_IN, THREE_SYLLABLES_EXP);
    }

    @Test
    public void testFourSyllables() {
        testCollections(FOUR_SYLLABLES_IN, FOUR_SYLLABLES_EXP);
    }

    public void testCollections(Word[] in, String[] exp) {
        for (int i = 0; i < exp.length; i++) {
            test(in[i], exp[i], in[i].rawText);
        }
    }

    public void test(Word in, String exp, String rawText) {
        Word.removeDoubles(in.syllables);
        String out = in.transcribe();
        Assertions.assertEquals(exp, out, "Expected to transcribe " + rawText + " to " + exp);
    }

}
