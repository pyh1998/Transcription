package comp1110.ass1;

public class Syllable {
    Phoneme[] phonemes;   // the phonemes that make up this syllable
    Syllable predecessor; // the syllable that precedes this one
    Syllable successor;   // the syllable that follows this one

    /**
     * Constructor for a Syllable. Given an array of Phonemes, gives each
     * Phoneme a context (itself) and an index (depending on where the phoneme
     * is location in the syllable).
     *
     * @param ps the given array of Phonemes
     */
    public Syllable(Phoneme[] ps) {
        // Set instance field and initialize accumulator
        this.phonemes = ps;
        int i = 0;
        for (Phoneme p : ps) {
            // Give each Phoneme a context (to call on later) and an index
            p.context = this;
            p.index = i++;
        }
        // Predecessor and successor to be defined later
        this.predecessor = null;
        this.successor = null;
    }

    /**
     * Determines if this Syllable is the last Syllable in the Word.
     *
     * @return whether this Syllable is the last Syllable in the Word
     */
    public boolean isFinalSyllable() {
        return this.successor == null;
    }

    /**
     * Determines if this Syllable is the first Syllable in the Word.
     *
     * @return whether this Syllable is the first Syllable in the Word
     */
    public boolean isFirstSyllable() {
        return this.predecessor == null;
    }

    /**
     * Sets the Syllable that precedes this Syllable.
     *
     * @param predecessor the given Syllable that precedes this Syllable
     */
    public void setPredecessor(Syllable predecessor) {
        this.predecessor = predecessor;
        // Creates a two-way linkage between the two Syllables
        predecessor.setSuccessor(this);
    }

    /**
     * Sets the Syllable that follows this Syllable.
     *
     * @param successor the given Syllable that follows this Syllable
     */
    public void setSuccessor(Syllable successor) {
        this.successor = successor;
    }

    /**
     * For each Phoneme in this Syllable, determines which sound that Phoneme
     * should take. This is done by evaluating the phoneme rules in a given
     * order. Both the rules and the order of evaluation can be found in the
     * Phoneme class.
     */
    public void evaluate() {
        for (Phoneme p : phonemes) {
            /* Hint: you can press ctrl+B (or cmd+B on Mac) on `evaluate` to
             * see exactly how p.evaluate() is written! */
            p.evaluate();
        }
    }

    /**
     * Transcribes each Phoneme in this Syllable.
     *
     * @return the transcribed sound from each Phoneme, concatenated together
     * in the order of the Phonemes.
     */
    public String transcribe() {
        String out = "";
        for (Phoneme p : phonemes) {
            // Add the sound of the given Phoneme onto the end of the result
            out += p.sound;
        }
        return out;
    }

}
