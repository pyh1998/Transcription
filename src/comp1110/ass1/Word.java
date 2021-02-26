package comp1110.ass1;

import java.util.Arrays;

public class Word {
    /**
     * The word as spelled in the French alphabet.
     */
    final String rawText;

    Syllable[] syllables; // the syllables that make up this word

    /**
     * Constructor for the Word class.
     *
     * @param rawText   the raw string to be converted into a Word
     * @param syllables the syllables (and, by extension, phonemes) that make
     *                  up this Word
     */
    public Word(String rawText, Syllable[] syllables) {
        this.rawText = rawText;
        this.syllables = syllables;
        for (int i = 1; i < syllables.length; i++) {

            // Create links between each syllable, useful for applying rules
            syllables[i].setPredecessor(syllables[i - 1]);
        }
    }

    /**
     * Converts a raw string into Word format using the rules of transcription
     * provided in this assignment. For a detailed description of the
     * transcription process, please consult the README.
     *
     * @param data the raw string to convert into a Word
     * @return the given raw string, converted to Word format
     */
    public static Word fromString(String data) {
        // Break word down into phonemes and syllables
        Phoneme[] phonemes = Word.getIndividualPhonemes(data);
        Syllable[] syllables = Word.splitIntoSyllables(phonemes);

        /* Figure out which sound is made by each phoneme based on each
         *  phoneme's position within the word and/or syllables. */
        for (Syllable s : syllables) {
            s.evaluate();
        }

        // Remove trailing syllables without vowels
        syllables = Word.condenseSyllables(syllables);

        // Remove doubled-up consonants as they only make one sound
        Word.removeDoubles(syllables);

        return new Word(data, syllables);
    }

    /**
     * Breaks a word down from String format into individual phonemes.
     *
     * @param data the given word, in String format
     * @return an array containing each phoneme making up the given word
     */
    private static Phoneme[] getIndividualPhonemes(String data) {
        // FIXME Task 3 Fix this method to handle multi-character phonemes

        // Set up array, string pointer and array pointer
        Phoneme[] ps = new Phoneme[data.length()];
        int pointer = 0;
        int idx = 0;
        while (pointer < data.length()) {

            /* Start as far as possible along the string and get the
             * corresponding substring. */
            int lookahead = Math.min(data.length(), pointer + Phoneme.MAX_PHONEME_LENGTH);
            String s = data.substring(pointer, lookahead);

            // Delimiter is needed to figure out if a vowel is nasal or not
            String delimiter = "";
            if (lookahead < data.length()) {
                delimiter = data.substring(lookahead, lookahead + 1);
            }

            /* Find the given substring in both vowel and consonant lookup
             * tables. */
            Phoneme p = Phoneme.find(s, delimiter);
            while (p == null) {

                /* Couldn't find substring in either lookup table, so shorten
                 * the substring. */
                lookahead--;
                s = data.substring(pointer, lookahead);

                // Delimiter is needed to figure out if a vowel is nasal or not
                delimiter = "";
                if (lookahead < data.length()) {
                    delimiter = data.substring(lookahead, lookahead + 1);
                }

                /* Find the given substring in both vowel and consonant lookup
                 * tables. */
                p = Phoneme.find(s, delimiter);
            }

            /* Substring was found in one of the lookup tables, so create the
             * corresponding phoneme and add it to the array. */
            ps[idx] = p;

            // Update string and array pointers
            pointer = lookahead;
            idx++;
        }

        // Trim array so that there are no null elements
        Phoneme[] phonemes = new Phoneme[idx];
        for (int i = 0; i < idx; i++) {
            phonemes[i] = ps[i];
        }
        return phonemes;
    }

    /**
     * Determines whether a consonant is neighboured by two vowels at a given
     * position in a given phoneme array.
     *
     * @param ps the given phoneme array
     * @param i  the given position in the array
     * @return whether the phoneme in the given position in the given array
     * is a consonant neighboured by two vowels
     */
    private static boolean oneConsonantTwoVowels(Phoneme[] ps, int i) {
        return !ps[i].isVowel && ps[i - 1].isVowel && ps[i + 1].isVowel;
    }

    /**
     * Determines whether a consonant in a given position in a given phoneme
     * array is neighboured by a vowel to the right, and by a vowel followed by
     * a consonant to the left.
     * <p>
     * An example satisfying this rule is "reste", where the given position is
     * 3 (and so the given phoneme is 't'). In this case, 't' is neighboured by
     * 'e' to the right, and by 'e' followed by 's' to the left.
     * <p>
     * Another example satisfying this rule is "important", where the given
     * position is 5 (and so the given phoneme is 't'). In this case, 't' is
     * neighboured by 'a' to the right, and by 'o' followed by 'r' to the left.
     *
     * @param ps the given phoneme array
     * @param i  the given position in the array
     * @return whether the phoneme in the given position in the given array
     * is a consonant, neighboured by a vowel to the right and by a
     * vowel followed by a consonant to the left
     */
    private static boolean twoConsonantsTwoVowels(Phoneme[] ps, int i) {

        /* Rule doesn't apply if there aren't two phonemes to the left of the
         * given position. */
        if (i < 2) return false;
        boolean consonants = !ps[i].isVowel && !ps[i - 1].isVowel;
        boolean vowels = ps[i - 2].isVowel && ps[i + 1].isVowel;
        return consonants && vowels && !syllableException(ps, i - 1);
    }

    /**
     * Determines whether a phoneme at a given position in a given phoneme
     * array satisfies the one exception to the rules of breaking French
     * words into syllables.
     * <p>
     * This exception is: if there are two consonants
     * surrounded by a vowel on either side, but the second consonant is 'r' or
     * 'l' and the first consonant is neither 'r' nor 'l', the syllable break
     * is placed between the first vowel and first consonant, as opposed to
     * between the two consonants.
     * <p>
     * In French, an example is 'quatre' (the French word for the number 4).
     * 't' and 'r' are surrounded by 'a' and 'e', however, because the second
     * consonant is 'r' and the first consonant is neither 'r' nor 'l', the
     * syllable break is placed in between 'a' and 't' instead of in between
     * 't' and 'r'.
     * <p>
     * Another example is 'simple' (French for 'simple'). In 'simple', 'p' and
     * 'l' are surrounded by 'im' (a nasal vowel) and 'e'. However, because the
     * second consonant is 'l' and the first consonant is neither 'r' nor 'l',
     * the syllable break is placed in between 'im' and 'p' instead of in
     * between 'p' and 'l'.
     *
     * @param ps the given phoneme array
     * @param i  the given position in the array
     * @return whether the phoneme in the given position in the given array
     * is subject to any of the exceptions to the rules of breaking
     * French words into syllables
     */
    private static boolean syllableException(Phoneme[] ps, int i) {
        Phoneme curr = ps[i];
        Phoneme succ = ps[i + 1];

        /* Exception to the two consonants, two vowels rule: if the second
         * consonant is 'r' or 'l', the syllable break occurs before the first
         * consonant, not in between the two consonants.
         * NB: this rule doesn't apply if the first consonant is 'r' or 'l'. */
        return (!curr.isVowel && !curr.id.equals("r") && !curr.id.equals("l")) &&
                (succ.id.equals("r") || succ.id.equals("l"));
    }

    /**
     * Splits a given array of phonemes into a matrix of phonemes. This method
     * returns a placeholder data structure for creating syllables.
     *
     * @param ps the given phoneme array
     * @return the same array, split according to rules for breaking French
     * words up into syllables
     */
    private static Phoneme[][] breakIntoSyllables(Phoneme[] ps) {

        // Set up placeholder and pointers for array and syllable break
        Phoneme[][] syllables = new Phoneme[ps.length][];
        int idx = 0;
        int from = 0;
        for (int i = 1; i < ps.length - 1; i++) {

            // Evaluate syllable-splitting rules
            boolean exception = syllableException(ps, i);
            boolean one = oneConsonantTwoVowels(ps, i);
            boolean two = twoConsonantsTwoVowels(ps, i);
            if (one || two || exception) {

                /* Create a syllable break and update the syllable break
                 * pointer if any of the syllable-splitting rules are
                 * satisfied. */
                syllables[idx] = Arrays.copyOfRange(ps, from, i);
                idx++;
                from = i;
            }
        }

        // Add any trailing phonemes that were not added before
        syllables[idx] = Arrays.copyOfRange(ps, from, ps.length);
        idx++;

        /* Create a new matrix that fits to the actual number of syllables in
         * this word. */
        Phoneme[][] out = new Phoneme[idx][];
        for (int i = 0; i < idx; i++) {
            out[i] = syllables[i];
        }
        return out;
    }

    /**
     * Splits a given array of phonemes into syllables, using the rules for
     * breaking French words into syllables. For a detailed description of
     * these rules, please consult the README.
     *
     * @param ps the given array of phonemes
     * @return these phonemes, now split into syllables
     */
    public static Syllable[] splitIntoSyllables(Phoneme[] ps) {
        // FIXME Task 4 complete this method
        return new Syllable[]{new Syllable(ps)};
    }

    /**
     * Takes a given array of syllables, and for each syllable that has no
     * vowel, combines it with the previous syllable.
     *
     * @param syllables the given array of syllables
     * @return the same array of syllables with vowel-free syllables combined
     * with their preceding syllable
     */
    public static Syllable[] condenseSyllables(Syllable[] syllables) {
        // FIXME Task 11 complete this method
        return syllables;
    }

    /**
     * Given an array of syllables, find any neighbouring Phonemes with the
     * same sound. For each such pair of Phonemes, make the sound of the first
     * Phoneme silent (set the sound field of the Phoneme to an empty String).
     *
     * Note that this method is not affected by syllable breaks, meaning that
     * the last Phoneme of the i-th Syllable neighbours the first Phoneme of
     * the (i + 1)-th Syllable.
     *
     * @param syllables the given array of syllables
     */
    public static void removeDoubles(Syllable[] syllables) {
        // FIXME Task 2 complete this method
    }

    /**
     * Returns the string form of a transcribed Syllable.
     *
     * @return the string form of a transcribed Syllable
     */
    public String transcribe() {
        String out = "";
        for (Syllable s : syllables) {
            /* Transcribes each individual syllable and concatenates that
             * transcription to the overall result. */
            out += s.transcribe() + ".";
        }
        return out.substring(0, out.length() - 1);
    }
}
