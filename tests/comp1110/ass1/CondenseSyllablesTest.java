package comp1110.ass1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CondenseSyllablesTest {

    public static final Word SCORE = new Word("score",
            new Syllable[]{
                    new Syllable(new Phoneme[]{
                            new Phoneme("s", "s", false),
                            new Phoneme("c", "k", false),
                            new Phoneme("o", "ɔ", true)
                    }),
                    new Syllable(new Phoneme[]{
                            new Phoneme("r", "ʁ", false),
                            new Phoneme("e", "", true)
                    })
            }
    );
    public static final String SCORE_EXP = "skɔʁ";

    public static final Word LUNE = new Word("lune",
            new Syllable[]{
                    new Syllable(new Phoneme[]{
                            new Phoneme("l", "l", false),
                            new Phoneme("u", "y", true)
                    }),
                    new Syllable(new Phoneme[]{
                            new Phoneme("n", "n", false),
                            new Phoneme("e", "", true)
                    })
            }
    );
    public static final String LUNE_EXP = "lyn";

    public static final Word PEINE = new Word("peine",
            new Syllable[]{
                    new Syllable(new Phoneme[]{
                            new Phoneme("p", "p", false),
                            new Phoneme("ei", "ɛ", true)
                    }),
                    new Syllable(new Phoneme[]{
                            new Phoneme("n", "n", false),
                            new Phoneme("e", "", true)
                    })
            }
    );
    public static final String PEINE_EXP = "pɛn";

    public static final Word PATE = new Word("pâte",
            new Syllable[]{
                    new Syllable(new Phoneme[]{
                            new Phoneme("p", "p", false),
                            new Phoneme("â", "ɑ", true)
                    }),
                    new Syllable(new Phoneme[]{
                            new Phoneme("t", "t", false),
                            new Phoneme("e", "", true)
                    })
            }
    );
    public static final String PATE_EXP = "pɑt";

    public static final Word POSTE = new Word("poste",
            new Syllable[]{
                    new Syllable(new Phoneme[]{
                            new Phoneme("p", "p", false),
                            new Phoneme("o", "ɔ", true),
                            new Phoneme("s", "s", false),
                    }),
                    new Syllable(new Phoneme[]{
                            new Phoneme("t", "t", false),
                            new Phoneme("e", "", true)
                    })
            }
    );
    public static final String POSTE_EXP = "pɔst";

    public static final Word PORTE = new Word("porte",
            new Syllable[]{
                    new Syllable(new Phoneme[]{
                            new Phoneme("p", "p", false),
                            new Phoneme("o", "ɔ", true),
                            new Phoneme("r", "ʁ", false)
                    }),
                    new Syllable(new Phoneme[]{
                            new Phoneme("t", "t", false),
                            new Phoneme("e", "", true)
                    })
            }
    );
    public static final String PORTE_EXP = "pɔʁt";

    public static final Word HALTE = new Word("halte",
            new Syllable[]{
                    new Syllable(new Phoneme[]{
                            new Phoneme("h", "", false),
                            new Phoneme("a", "a", true),
                            new Phoneme("l", "l", false)
                    }),
                    new Syllable(new Phoneme[]{
                            new Phoneme("t", "t", false),
                            new Phoneme("e", "", true)
                    })
            }
    );
    public static final String HALTE_EXP = "alt";

    public static final Word SALLE = new Word("salle",
            new Syllable[]{
                    new Syllable(new Phoneme[]{
                            new Phoneme("s", "s", false),
                            new Phoneme("a", "a", true),
                            new Phoneme("l", "l", false)
                    }),
                    new Syllable(new Phoneme[]{
                            new Phoneme("l", "l", false),
                            new Phoneme("e", "", true)
                    })
            }
    );
    public static final String SALLE_EXP = "sal";

    public static final Word QUATRE = new Word("quatre",
            new Syllable[]{
                    new Syllable(new Phoneme[]{
                            new Phoneme("qu", "k", false),
                            new Phoneme("a", "a", true)
                    }),
                    new Syllable(new Phoneme[]{
                            new Phoneme("t", "t", false),
                            new Phoneme("r", "ʁ", false),
                            new Phoneme("e", "", true)
                    })
            }
    );
    public static final String QUATRE_EXP = "katʁ";

    public static final Word NOTRE = new Word("notre",
            new Syllable[]{
                    new Syllable(new Phoneme[]{
                            new Phoneme("n", "n", false),
                            new Phoneme("o", "ɔ", true)
                    }),
                    new Syllable(new Phoneme[]{
                            new Phoneme("t", "t", false),
                            new Phoneme("r", "ʁ", false),
                            new Phoneme("e", "", true)
                    })
            }
    );
    public static final String NOTRE_EXP = "nɔtʁ";

    public static final Word SIMPLE = new Word("simple",
            new Syllable[]{
                    new Syllable(new Phoneme[]{
                            new Phoneme("s", "s", false),
                            new Phoneme("im", "ɛ̃", true),
                    }),
                    new Syllable(new Phoneme[]{
                            new Phoneme("p", "p", false),
                            new Phoneme("l", "l", false),
                            new Phoneme("e", "", true)
                    })
            }
    );
    public static final String SIMPLE_EXP = "sɛ̃pl";

    public static final Word AMPLE = new Word("ample",
            new Syllable[]{
                    new Syllable(new Phoneme[]{
                            new Phoneme("am", "ɑ̃", true),
                    }),
                    new Syllable(new Phoneme[]{
                            new Phoneme("p", "p", false),
                            new Phoneme("l", "l", false),
                            new Phoneme("e", "", true)
                    })
            }
    );
    public static final String AMPLE_EXP = "ɑ̃pl";

    public static final Word[] ONE_VOWEL_TWO_CONS = new Word[]{SCORE, LUNE, PEINE, PATE};
    public static final String[] ONE_VOWEL_TWO_CONS_EXP = new String[]{SCORE_EXP, LUNE_EXP, PEINE_EXP, PATE_EXP};

    public static final Word[] TWO_VOWELS_TWO_CONS = new Word[]{POSTE, HALTE, PORTE, SALLE};
    public static final String[] TWO_VOWELS_TWO_CONS_EXP = new String[]{POSTE_EXP, HALTE_EXP, PORTE_EXP, SALLE_EXP};

    public static final Word[] EXCEPTIONS = new Word[]{SIMPLE, QUATRE, NOTRE, AMPLE};
    public static final String[] EXCEPTIONS_EXP = new String[]{SIMPLE_EXP, QUATRE_EXP, NOTRE_EXP, AMPLE_EXP};

    @Test
    public void testOneVowelTwoConsonants() {
        testCollection(ONE_VOWEL_TWO_CONS, ONE_VOWEL_TWO_CONS_EXP);
    }

    @Test
    public void testTwoVowelsTwoConsonants() {
        testCollection(TWO_VOWELS_TWO_CONS, TWO_VOWELS_TWO_CONS_EXP);
    }

    @Test
    public void testSyllableExceptions() {
        testCollection(EXCEPTIONS, EXCEPTIONS_EXP);
    }

    public void testCollection(Word[] in, String[] exp) {
        for (int i = 0; i < in.length; i++) {
            test(in[i], exp[i]);
        }
    }

    public void test(Word in, String exp) {
        String rawText = in.rawText;
        Syllable[] syllables = in.syllables;
        syllables = Word.condenseSyllables(syllables);
        Word.removeDoubles(syllables);
        Word modified = new Word(rawText, syllables);
        Assertions.assertEquals(exp, modified.transcribe(), "Expected " + rawText + " to transcribe to " + exp);
    }
}
