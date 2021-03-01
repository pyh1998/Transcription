package comp1110.ass1;

public class Phoneme {

    /* The maximum length of any valid combination of character(s)
     * (as enumerated in the below lookup tables). */
    public static final int MAX_PHONEME_LENGTH = 1;

    /**
     * The String of one or more French characters that defines this phoneme.
     */
    final String id;  // the combination of characters that make up this Phoneme
    int index;        // where this Phoneme is located within its Syllable
    String sound;     // how this Phoneme sounds in IPA (an empty String is silent)
    Syllable context; // the Syllable in which this Phoneme is located
    boolean isVowel;  // whether this Phoneme is a vowel or not

    /**
     * Constructor that is mainly used for testing purposes.
     *
     * @param id      the character(s) that make up this Phoneme
     * @param sound   the predetermined sound of this Phoneme
     * @param isVowel whether this Phoneme is a vowel or not
     */
    public Phoneme(String id, String sound, boolean isVowel) {
        this.id = id;
        this.isVowel = isVowel;
        this.sound = sound;
        this.index = -1;
        this.context = null;
    }

    /**
     * Constructor for a Phoneme that is used in the lookup tables below.
     *
     * @param id      the character(s) that make up this Phoneme
     * @param isVowel whether this Phoneme is a vowel or not
     */
    public Phoneme(String id, boolean isVowel) {
        this.id = id;
        this.isVowel = isVowel;
        this.sound = "";
        this.index = -1;
        this.context = null;
    }

    /**
     * Constructor that does a deep copy of an existing Phoneme. Only used to
     * avoid having several Phonemes in a Word refer to the same Phoneme.
     *
     * @param p the given Phoneme
     */
    public Phoneme(Phoneme p) {
        assert (p != null);
        this.id = p.id;
        this.sound = p.sound;
        if (p.context == null) {
            this.context = null;
        } else {
            this.context = p.context;
        }
        this.isVowel = p.isVowel;
        this.index = p.index;
    }

    /**
     * Returns the character(s) that make up this Phoneme.
     *
     * @return the character(s) that make up this Phoneme
     */
    public String getId() {
        return id;
    }

    /**
     * Determines whether a given character is a vowel or not.
     *
     * @param c the given character
     * @return whether the given character is a vowel or not
     */
    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'à' || c == 'â' || c == 'é' || c == 'è' || c == 'ê' ||
                c == 'ô' || c == 'y';
    }

    /**
     * Determines whether this Phoneme is the last Phoneme in the whole Word.
     * Important Exception 1: this rule does not apply for Words that contain
     * two or fewer  Phonemes in total.
     * Important Exception 2: if the Word ends in 's', then this rule is also
     * satisfied if this Phoneme is the second-last Phoneme in the whole Word.
     *
     * @return whether this Phoneme is the last Phoneme in the whole Word,
     * accounting for the above exceptions
     */
    public boolean lastPhoneme() {
        // FIXME Task 5

        return false;
    }

    /**
     * Determines whether this Phoneme is followed by a Phoneme whose id is
     * 'i', 'y' or 'e'. Note that any form of accented 'e' ('é', 'è' and 'ê')
     * also satisfies this rule.
     *
     * @return whether this Phoneme is followed by a Phoneme whose id is 'i',
     * 'y' or 'e' (with or without accents)
     */
    public boolean beforeEOrI() {
        // FIXME Task 6
        return false;
    }

    /**
     * Determines whether this Phoneme is neighboured by two vowels. Some
     * important information to note:
     * - this rule is unaffected by syllable breaks on both sides; and
     * - this rule returns false if the Phoneme preceding this Phoneme is a
     * nasal vowel (that is, any vowel ending in 'm' or 'n').
     *
     * @return whether this Phoneme is neighboured by two vowels, except if the
     * Phoneme preceding this Phoneme is a nasal vowel.
     */
    public boolean betweenTwoVowels() {
        // FIXME Task 7
        return false;
    }


    /**
     * Determines whether this Phoneme is followed by a Phoneme that is a
     * vowel.
     *
     * @return whether this Phoneme is followed by a Phoneme that is a vowel
     */
    public boolean beforeVowel() {
        // FIXME Task 8
        return false;
    }

    /**
     * Determines whether a Phoneme is at the start or middle of a Syllable
     * (and therefore, not at the end of a Syllable)
     *
     * @return
     */
    public boolean notAtEndOfSyllable() {
        // FIXME Task 9
        return false;
    }

    /**
     * Determines whether this Phoneme is the last Phoneme in a Word with more
     * than one syllable.
     *
     * @return whether this Phoneme is the last Phoneme in a Word with more
     * than one syllable
     */
    public boolean endsMultiSyllableWord() {
        // FIXME Task 10
        return false;
    }

    public static final Phoneme[] BASIC_CHRS = new Phoneme[]{
            new Phoneme("a", true), new Phoneme("à", true),
            new Phoneme("â", true), new Phoneme("e", true),
            new Phoneme("é", true), new Phoneme("è", true),
            new Phoneme("ê", true), new Phoneme("i", true),
            new Phoneme("y", true), new Phoneme("o", true),

            new Phoneme("ô", true), new Phoneme("u", true),
            new Phoneme("oi", true), new Phoneme("ou", true),
            new Phoneme("ai", true), new Phoneme("ei", true),
            new Phoneme("au", true), new Phoneme("eau", true),
            new Phoneme("eu", true), new Phoneme("oeu", true),

            new Phoneme("ez", true), new Phoneme("ail", true),
            new Phoneme("aill", true), new Phoneme("aille", true),
            new Phoneme("eil", true), new Phoneme("eill", true),
            new Phoneme("eille", true), new Phoneme("ill", true),
            new Phoneme("ille", true), new Phoneme("er", true),

            new Phoneme("om", true), new Phoneme("on", true),
            new Phoneme("um", true), new Phoneme("un", true),
            new Phoneme("am", true), new Phoneme("an", true),
            new Phoneme("em", true), new Phoneme("en", true),
            new Phoneme("im", true), new Phoneme("in", true),

            new Phoneme("ien", true), new Phoneme("aim", true),
            new Phoneme("ain", true), new Phoneme("ein", true),
            new Phoneme("b", false), new Phoneme("c", false),
            new Phoneme("ç", false), new Phoneme("ch", false),
            new Phoneme("d", false), new Phoneme("f", false),

            new Phoneme("g", false), new Phoneme("h", false),
            new Phoneme("j", false), new Phoneme("k", false),
            new Phoneme("l", false), new Phoneme("m", false),
            new Phoneme("n", false), new Phoneme("p", false),
            new Phoneme("qu", false), new Phoneme("r", false),

            new Phoneme("s", false), new Phoneme("t", false),
            new Phoneme("th", false), new Phoneme("v", false),
            new Phoneme("w", false), new Phoneme("x", false),
            new Phoneme("z", false), new Phoneme("gn", false)
    };

    public static final String[] BASIC_SOUNDS = new String[]{
            "a", "a", "ɑ", "ə", "e", "ɛ", "ɛ", "i", "i", "ɔ",
            "o", "y", "wa", "u", "ɛ", "ɛ", "o", "o", "œ", "œ",
            "e", "aj", "aj", "aj", "ɛj", "ɛj", "ɛj", "ij", "ij", "ɛʁ",
            "ɔ̃", "ɔ̃", "œ̃", "œ̃", "ɑ̃", "ɑ̃", "ɑ̃", "ɑ̃", "ɛ̃", "ɛ̃",
            "jɛ̃", "ɛ̃", "ɛ̃", "ɛ̃", "b", "k", "s", "ʃ", "d", "f",
            "g", "", "ʒ", "k", "l", "m", "n", "p", "k", "ʁ",
            "s", "t", "t", "v", "w", "ks", "z", "ɲ"
    };

    /**
     * Finds a Phoneme from the above lookup table BASIC_CHRS. The Phoneme's
     * id must match the given id. Furthermore, the given following
     * character(s) affect the search process in the following ways:
     * - if the given id is that of a nasal vowel, the find method will only
     * return the corresponding nasal Phoneme if the given following string
     * starts with a consonant; and,
     * - if the given id is that of a nasal vowel, the find method will not
     * return the corresponding nasal Phoneme if the given following string
     * starts with the same consonant that is at the end of the given id.
     * For example, finding 'on' in 'bonne' will return null.
     * - if the given id is 'y' and the given following string starts with a
     * vowel, then the resulting 'y' Phoneme is treated as a consonant, not
     * as a vowel.
     *
     * @param id        the given id to search for
     * @param following the character(s) that follow the given id
     * @return a corresponding Phoneme from the lookup table BASIC_CHRS,
     * or null if no suitable Phoneme can be found
     */
    public static Phoneme find(String id, String following) {
        for (Phoneme p : BASIC_CHRS) {
            if (p.getId().equals(id)) {
                if (p.isVowel) {
                    /* Ending of the given id matters if the given id is that
                     * of a nasal Phoneme. */
                    char ending = p.getId().charAt(p.getId().length() - 1);
                    /* If there are no characters following the given id, then
                     * there are no special conditions. */
                    boolean empty = following.isEmpty();
                    boolean isConsonant = empty || !isVowel(following.charAt(0));
                    boolean notNasal = ending != 'm' && ending != 'n';
                    /* If there is a double 'm' or double 'n', a nasal Phoneme
                     * will not be returned when queried. */
                    boolean notDouble = empty || ending != following.charAt(0);
                    if (empty || notNasal || (isConsonant && notDouble)) {
                        Phoneme out = new Phoneme(p);
                        /* If 'y' precedes a vowel, it is treated as a
                         * consonant. */
                        if (id.equals("y") && !isConsonant) {
                            out.isVowel = false;
                        }
                        return out;
                    }

                } else {
                    // Given id is a consonant, nothing particularly special
                    return new Phoneme(p);
                }
            }
        }
        return null;
    }

    /**
     * Determines what sound corresponds to this Phoneme.
     * <p>
     * Hint: for later tasks, have a look at BASIC_CHRS and BASIC_SOUNDS.
     * Also have a look at all of the boolean methods with FIXMEs.
     * How could you integrate these seamlessly into this method...?
     */
    public void evaluate() {
        // FIXME Task 1 complete this method
        int i=0;
        for (Phoneme p : BASIC_CHRS) {

            if(id.equals(p.id))
            {
                //System.out.println("id:"+id+"  p.id:"+p.id+"  i:"+i);
                this.sound=BASIC_SOUNDS[i];
                //System.out.println(BASIC_SOUNDS[i]);
                break;
            }
            i++;
        }

    }

}
