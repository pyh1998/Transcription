# Assignment One Feedback
## Tutor Comment

Congratulations on completing all of the tasks!
You could improve the readability of your code by using local variables, for example in `Phoneme.beforeEorI()`, the expression `context.phonemes[index + 1].getId()` appears often, and could be replaced with a sensibly-named local variable. You can also use IntelliJ Reformat Code (Ctrl+Alt+L) to clean up the code according to a nice Java coding style; this will make your code more consistent and easier to read.


## Mark

**  4.25/5.0**

## Miscellaneous marks

| Level | Requirement | Result |
|:-:|---|:-:|
|P|Forked assignment 1 repository | 0.5/0.5 |
|P|Originality statement edited, committed, pushed | 0.5/0.5 |
|P|Git log file reveals healthy use of Git | 0.25/0.25 |
|P|Edited classes compile correctly | 0.25/0.25 |
|CR|Code is of high quality | 0.25/0.5 |
|HD|Solution is outstanding in its design and implementation | /0.5 |

**Total for miscellaneous marks:** 1.75/2.5

## Test results
```
Test Name   Tests Passed  Weighting    Score
-----              -----      -----    -----
task1                3/3        0.2      0.2
task2                4/4        0.4      0.4
task3                3/3        0.2      0.2
task4                3/3        0.2      0.2
task5                8/8        0.4      0.4
task6                2/2        0.1      0.1
task7                3/3        0.3      0.3
task8                4/4        0.2      0.2
task9                4/4        0.2      0.2
task10               3/3        0.1      0.1
task11               3/3        0.2      0.2
-----              -----     Total:  2.5/2.5
```
## Originality statement
# IMPORTANT: It is very important that you correctly complete this originality
# statement.
#
# This is your statement of your submitted work being your own.
# Incorrectly filling out this statement could lead to charges
# of academic misconduct.
# 
# For information on how to fill this out correctly, see
# https://cs.anu.edu.au/courses/comp1110/help/faq/09-originality/
#

declaration: >-
  I declare that everything I have submitted in this assignment is entirely my
  own work, with the following exceptions:


# Use this to list any assets (artwork, sound, etc) that you used.
# Provide a comment explaining your use of that asset and the URL
# and license for the asset
#
# Add as many "url+licence+comment" entries as necessary
# (or remove it altogether if you haven't used any external assets)
assets:
  - comment: Speaker_Icon.png (Wikipedia User:Mobius, rescaled from original)
    url: https://commons.wikimedia.org/wiki/File:Speaker_Icon.svg
    license: Public Domain




# sign *your* name and uid here
name: Yuhui Pang
uid: u7211790
## Git Log
```
commit 6602a2a6623ebc0dfc36823b87e0f8fe1c26ea55
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Fri Mar 5 16:25:11 2021 +0800

    Finished task1-11!

commit c8234fabbeae7b310a189af7c4e622195f53931d
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Mon Mar 1 15:15:25 2021 +0800

    task1-4

commit 591ee7b9c4f96816278d8a26fb10256497579f95
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Mon Mar 1 15:13:51 2021 +0800

    task1-4

commit cd4e457a0dd45594f7cf4f7c31905c872d81cff7
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Mon Mar 1 14:49:30 2021 +0800

    task1-4

commit d5dea9f64ed212fc4428124378222bb1e7a9c7cf
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Mon Mar 1 14:41:25 2021 +0800

    task1-4

commit efded9fd7d11864adc66765df7094b282df5fdea
Merge: 78eebfd d741939
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Sat Feb 27 23:28:38 2021 +0800

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/comp1110/comp1110-ass1

commit 78eebfd713adf127f56bccdffc6c0876bca01771
Author: Yuhui Pang <u7211790@anu.edu.au>
Date:   Sat Feb 27 23:26:32 2021 +0800

    task1-3

commit d74193901864bafad89fdf1122f5218f31c75be2
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Fri Feb 26 21:14:13 2021 +1100

    fix CI classpaths for build and test

commit 229d006b5fe7e325f11ceae089ce38e3fa2750d0
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Fri Feb 26 11:49:58 2021 +1100

    improve Javadoc for early tasks

commit 64a3d4fa62c222a0d314bb92403194f2919b78fe
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Fri Feb 26 11:46:39 2021 +1100

    fix tests for tasks 8 and 9 to remove dependency on later task

commit 0160f723ef81a09d07237a960dc9fd31cabb23ec
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Fri Feb 26 08:33:50 2021 +1100

    Initial import
```
## Changes
``` diff
diff -ru -x .git /mnt/c/git/comp1110-tutors/master/comp1110-ass1/README.md comp1110-ass1/README.md
--- /mnt/c/git/comp1110-tutors/master/comp1110-ass1/README.md	2021-03-12 21:44:28.659475700 +1100
+++ comp1110-ass1/README.md	2021-03-18 17:06:37.505627600 +1100
@@ -138,7 +138,6 @@
 | **v**  | Like the letter 'v' in English | /v/ |
 | **w**  | Like the letter 'w' in English | /w/ |
 | **x**  | Like the letter 'x' in English | /ks/ |
-| **y**  | Before a vowel, pronounced like 'y' in English | /j/ |
 
 #### Consonants at the end of words
 
@@ -157,14 +156,13 @@
 |-------|----------------------------|---------------|
 | **a**, **à** | Like 'ah' in English | /a/ |
 | **â** | Like 'ah' in English, but longer | /ɑ/ |
-| **e** | At the end of a word with more than two phonemes (including itself), is silent | // |
-| **e** | At the end of a syllable with more than one phoneme, like 'a' in 'soda' | /ə/ |
+| **e** | At the end of a multi-syllable word, is silent | // |
+| **e** | At the end of a syllable, like 'a' in 'soda' | /ə/ |
 | **e** | Elsewhere, like 'ai' in 'fairy' | /ɛ/ |
 | **é** | Like 'ey' in 'hey' | /e/ |
 | **è**, **ê** | Like 'ai' in 'fairy' | /ɛ/ |
-| **i** | Before another vowel, pronounced like 'y' in English | /j/ |
-| **i** | Elsewhere, like 'i' in 'meet' | /i/ |
-| **y** | If not before a vowel, like 'i' in 'meet' | /i/ |
+| **i**, **y** | Before another vowel, pronounced like 'y' in English | /j/ |
+| **i**, **y** | Elsewhere, like 'i' in 'meet' | /i/ |
 | **o** | Like 'au' in 'fault' | /ɔ/ |
 | **ô** | Like the letter 'o' in English, without the final 'u' sound | /o/ |
 | **u** | Similar to the 'ew' in 'few'; as suggested by [this website](https://www.talkinfrench.com/french-pronunciation-guide/#tab-con-1), try pronouncing 'ee' with rounded lips | /y/ |
@@ -172,7 +170,7 @@
 | **ou** | Like 'ooh' | /u/ |
 | **ai**, **ei** | Like 'ai' in 'fairy' | /ɛ/ |
 | **au**, **eau** | Like the letter 'o' in English, without the final 'u' sound | /o/ |
-| **eu**, **oeu** | Like 'er' in 'prefer' | /œ/ |
+| **eu**, **oeu** | Like 'er' in 'prefer' | /ø/ |
 
 #### Nasalized vowels
 
Only in comp1110-ass1: feedback.md
diff -ru -x .git /mnt/c/git/comp1110-tutors/master/comp1110-ass1/originality.yml comp1110-ass1/originality.yml
--- /mnt/c/git/comp1110-tutors/master/comp1110-ass1/originality.yml	2021-03-12 21:44:28.730019300 +1100
+++ comp1110-ass1/originality.yml	2021-03-18 17:06:37.526570700 +1100
@@ -14,27 +14,6 @@
   own work, with the following exceptions:
 
 
-# Use this to list names of people who you collaborated with, and a
-# comment about what you collaborated on.
-#
-# Add as many "name+comment" entries as necessary
-# (or remove it altogether if you haven't collaborated with anyone)
-collaboration:
-  - name:
-    comment: >-
-
-# Use this to list any code that you used that you did not write,
-# aside from code provided by the lecturer.  Provide a comment
-# explaining your use and the URL to that code and the licence for
-# that code
-#
-# Add as many "url+licence+comment" entries as necessary
-# (or remove it altogether if you haven't used any external code)
-code:
-  - comment:
-    url:
-    licence:
-
 # Use this to list any assets (artwork, sound, etc) that you used.
 # Provide a comment explaining your use of that asset and the URL
 # and license for the asset
@@ -45,11 +24,10 @@
   - comment: Speaker_Icon.png (Wikipedia User:Mobius, rescaled from original)
     url: https://commons.wikimedia.org/wiki/File:Speaker_Icon.svg
     license: Public Domain
-  - comment:
-    url:
-    licence:
+
+
 
 
 # sign *your* name and uid here
-name:
-uid:
+name: Yuhui Pang
+uid: u7211790
diff -ru -x .git /mnt/c/git/comp1110-tutors/master/comp1110-ass1/src/comp1110/ass1/Phoneme.java comp1110-ass1/src/comp1110/ass1/Phoneme.java
--- /mnt/c/git/comp1110-tutors/master/comp1110-ass1/src/comp1110/ass1/Phoneme.java	2021-03-12 21:44:28.762410000 +1100
+++ comp1110-ass1/src/comp1110/ass1/Phoneme.java	2021-03-18 17:06:37.529598000 +1100
@@ -96,6 +96,23 @@
      */
     public boolean lastPhoneme() {
         // FIXME Task 5
+//        System.out.println(context.isFinalSyllable());
+//        System.out.println(getId());
+        if(context.isFinalSyllable()){
+            if(index==context.phonemes.length-1) {
+                if (!isVowel && !getId().equals("c") && !getId().equals("f") && !getId().equals("l") && !getId().equals("r"))
+                    return true;
+                else if(getId().equals("e") && (index>1 || !context.isFirstSyllable()))
+                    return true;
+            }
+            else if(index==context.phonemes.length-2 && context.phonemes[index+1].getId().equals("s")){
+                if (!isVowel && !getId().equals("c") && !getId().equals("f") && !getId().equals("l") && !getId().equals("r"))
+                    return true;
+                else if(getId().equals("e") && (index>1 || !context.isFirstSyllable()))
+                    return true;
+            }
+        }
+
         return false;
     }
 
@@ -109,6 +126,10 @@
      */
     public boolean beforeEOrI() {
         // FIXME Task 6
+        if(index < context.phonemes.length-1 && (context.phonemes[index + 1].getId().equals("y") || context.phonemes[index + 1].getId().equals("i") || context.phonemes[index + 1].getId().equals("e") || context.phonemes[index + 1].getId().equals("é") || context.phonemes[index + 1].getId().equals("è") || context.phonemes[index + 1].getId().equals("ê")))
+        {
+            return true;
+        }
         return false;
     }
 
@@ -124,6 +145,35 @@
      */
     public boolean betweenTwoVowels() {
         // FIXME Task 7
+//        System.out.println("index:"+index);
+//        System.out.println(this.context.isFirstSyllable());
+//        System.out.println(this.context.isFinalSyllable());
+
+        if(index==0 && context.predecessor!=null){
+            if(context.predecessor.phonemes[context.predecessor.phonemes.length-1].isVowel && context.phonemes[1].isVowel){
+                char ending = context.predecessor.phonemes[context.predecessor.phonemes.length-1].getId().charAt(context.predecessor.phonemes[context.predecessor.phonemes.length-1].getId().length() - 1);
+                if(ending!='m' && ending!='n'){
+                    return true;
+                }
+            }
+
+        }
+        else if(index==context.phonemes.length-1 && context.successor!=null) {
+            if(context.successor.phonemes[0].isVowel && context.phonemes[index-1].isVowel) {
+                char ending = context.phonemes[index-1].getId().charAt(context.phonemes[index-1].getId().length() - 1);
+                if (ending != 'm' && ending != 'n') {
+                    return true;
+                }
+            }
+        }
+        else if(index!=0 && index!=context.phonemes.length-1){
+            if(context.phonemes[index-1].isVowel && context.phonemes[index+1].isVowel){
+                char ending = context.phonemes[index-1].getId().charAt(context.phonemes[index-1].getId().length() - 1);
+                if(ending!='m' && ending!='n'){
+                    return true;
+                }
+            }
+        }
         return false;
     }
 
@@ -136,6 +186,10 @@
      */
     public boolean beforeVowel() {
         // FIXME Task 8
+        if(index!=context.phonemes.length-1){
+            if(context.phonemes[index+1].isVowel && (getId().equals("i") || getId().equals("y")))
+                return true;
+        }
         return false;
     }
 
@@ -147,7 +201,10 @@
      */
     public boolean notAtEndOfSyllable() {
         // FIXME Task 9
-        return false;
+        if(index == context.phonemes.length-1 && index!=0){
+            return false;
+        }
+        return true;
     }
 
     /**
@@ -159,6 +216,9 @@
      */
     public boolean endsMultiSyllableWord() {
         // FIXME Task 10
+        if(context.isFinalSyllable() && !context.isFirstSyllable() && index==context.phonemes.length-1){
+            return true;
+        }
         return false;
     }
 
@@ -278,7 +338,53 @@
      */
     public void evaluate() {
         // FIXME Task 1 complete this method
-        this.sound = "a";
+        if(lastPhoneme()){
+            this.sound="";
+            return;
+        }
+
+        if(beforeEOrI()){
+            if(getId().equals("c")){
+                this.sound="s";
+                return;
+            }
+            else if(getId().equals("g")){
+                this.sound="ʒ";
+                return;
+            }
+        }
+
+        if(betweenTwoVowels() && getId().equals("s")){
+            this.sound="z";
+            return;
+        }
+
+
+        if(beforeVowel()){
+            this.sound="j";
+            return;
+        }
+
+        if(getId().equals("e") && notAtEndOfSyllable()){
+            this.sound="ɛ";
+            return;
+        }
+
+        if(getId().equals("er") && endsMultiSyllableWord()){
+            this.sound="e";
+            return;
+        }
+
+        for (int i=0;i<BASIC_CHRS.length;i++) {
+            if(id.equals(BASIC_CHRS[i].getId()))
+            {
+                //System.out.println("id:"+id+"  p.id:"+p.id+"  i:"+i);
+                this.sound=BASIC_SOUNDS[i];
+                //System.out.println(BASIC_SOUNDS[i]);
+                break;
+            }
+        }
+
     }
 
-}
+}
\ No newline at end of file
diff -ru -x .git /mnt/c/git/comp1110-tutors/master/comp1110-ass1/src/comp1110/ass1/Word.java comp1110-ass1/src/comp1110/ass1/Word.java
--- /mnt/c/git/comp1110-tutors/master/comp1110-ass1/src/comp1110/ass1/Word.java	2021-03-12 21:44:28.843167600 +1100
+++ comp1110-ass1/src/comp1110/ass1/Word.java	2021-03-18 17:06:37.549547400 +1100
@@ -72,7 +72,7 @@
 
             /* Start as far as possible along the string and get the
              * corresponding substring. */
-            int lookahead = Math.min(data.length(), pointer + Phoneme.MAX_PHONEME_LENGTH);
+            int lookahead = Math.max(data.length(), pointer + Phoneme.MAX_PHONEME_LENGTH);
             String s = data.substring(pointer, lookahead);
 
             // Delimiter is needed to figure out if a vowel is nasal or not
@@ -84,7 +84,7 @@
             /* Find the given substring in both vowel and consonant lookup
              * tables. */
             Phoneme p = Phoneme.find(s, delimiter);
-            while (p == null) {
+            while (p==null) {
 
                 /* Couldn't find substring in either lookup table, so shorten
                  * the substring. */
@@ -166,25 +166,29 @@
      * array satisfies the one exception to the rules of breaking French
      * words into syllables.
      * <p>
-     * This exception is: if there are two neighbouring consonants, and the
-     * second consonant is 'r' or 'l' and the first consonant is neither 'r'
-     * nor 'l', the syllable break is placed before the two consonants.
+     * This exception is: if there are two consonants
+     * surrounded by a vowel on either side, but the second consonant is 'r' or
+     * 'l' and the first consonant is neither 'r' nor 'l', the syllable break
+     * is placed between the first vowel and first consonant, as opposed to
+     * between the two consonants.
      * <p>
      * In French, an example is 'quatre' (the French word for the number 4).
-     * 't' and 'r' are neighbours, and because the second
-     * consonant is 'r' and the first consonant is neither 'r' nor 'l', a
-     * syllable break is placed in between 'a' and 't'.
+     * 't' and 'r' are surrounded by 'a' and 'e', however, because the second
+     * consonant is 'r' and the first consonant is neither 'r' nor 'l', the
+     * syllable break is placed in between 'a' and 't' instead of in between
+     * 't' and 'r'.
      * <p>
      * Another example is 'simple' (French for 'simple'). In 'simple', 'p' and
-     * 'l' are neighbours. Again, because the second consonant is 'l' and the
-     * first consonant is neither 'r' nor 'l', the syllable break is placed in
-     * between 'im' and 'p'.
+     * 'l' are surrounded by 'im' (a nasal vowel) and 'e'. However, because the
+     * second consonant is 'l' and the first consonant is neither 'r' nor 'l',
+     * the syllable break is placed in between 'im' and 'p' instead of in
+     * between 'p' and 'l'.
      *
      * @param ps the given phoneme array
      * @param i  the given position in the array
      * @return whether the phoneme in the given position in the given array
-     * is a consonant, is not 'r' and 'l' and its neighbour to the right is
-     * either 'r' or 'l'
+     * is subject to any of the exceptions to the rules of breaking
+     * French words into syllables
      */
     private static boolean syllableException(Phoneme[] ps, int i) {
         Phoneme curr = ps[i];
@@ -252,7 +256,40 @@
      */
     public static Syllable[] splitIntoSyllables(Phoneme[] ps) {
         // FIXME Task 4 complete this method
-        return new Syllable[]{new Syllable(ps)};
+//        for(int i=0;i<ps.length;i++){
+//            //System.out.println(ps[i].id);
+//            //ps[i].evaluate();
+//            //System.out.println(ps[i].sound);
+//            if(i != 0 && i < ps.length-1){
+//                if(oneConsonantTwoVowels(ps,i)){
+//                    //breakIntoSyllables(ps);
+//                    ps[i-1].sound+='.';
+//                    //System.out.println(ps[i-1].sound+ps[i].sound+ps[i+1].sound);
+//                }
+//            }
+//            if(i > 1 && i < ps.length-1){
+//                if(syllableException(ps,i)){
+//                    ps[i-1].sound+='.';
+//                }
+//                else if(twoConsonantsTwoVowels(ps,i)){
+//                     if(ps[i].sound.equals(ps[i-1].sound)){
+//                        ps[i-1].sound="";
+//                    }
+//                    else ps[i-1].sound+='.';
+//                    //System.out.println(ps[i-1].sound+ps[i].sound+ps[i+1].sound);
+//                }
+//            }
+//        }
+//        return new Syllable[]{new Syllable(ps)};
+        Phoneme[][] p=breakIntoSyllables(ps);
+        Syllable[] s=new Syllable[p.length];
+        for(int i=0;i<p.length;i++){
+            s[i]=new Syllable(p[i]);
+            if(i>0){
+                s[i].setPredecessor(s[i-1]);
+            }
+        }
+        return s;
     }
 
     /**
@@ -265,6 +302,49 @@
      */
     public static Syllable[] condenseSyllables(Syllable[] syllables) {
         // FIXME Task 11 complete this method
+        Syllable s1 = syllables[syllables.length-1];
+        if(syllables.length>1){
+            for(int i=0;i<s1.phonemes.length;i++){
+                if(s1.phonemes[i].isVowel){
+                    if(i!=s1.phonemes.length-1){
+                        return syllables;
+                    }
+                    else if(!s1.phonemes[i].sound.equals(""))
+                    {
+                        return syllables;
+                    }
+                }
+            }
+            Syllable s2 = syllables[syllables.length-2];
+            Phoneme[] p = new Phoneme[s1.phonemes.length+s2.phonemes.length];
+
+            for(int i=0;i<s2.phonemes.length;i++){
+                p[i] = s2.phonemes[i];
+            }
+            for(int i=0;i<s1.phonemes.length;i++){
+                p[i+s2.phonemes.length] = s1.phonemes[i];
+            }
+            Syllable s=new Syllable(p);
+            Syllable[] ss = new Syllable[syllables.length-1];
+            for(int i=0;i<syllables.length-1;i++){
+                if(i!=syllables.length-2){
+                    ss[i]=syllables[i];
+                }
+                else{
+                    ss[i]=s;
+                    if(i>0){
+                        ss[i].setPredecessor(ss[i-1]);
+                    }
+                }
+            }
+            return ss;
+
+        }
+
+
+
+
+
         return syllables;
     }
 
@@ -281,6 +361,22 @@
      */
     public static void removeDoubles(Syllable[] syllables) {
         // FIXME Task 2 complete this method
+        for(Syllable s:syllables) {
+            //System.out.println(s.phonemes.length);
+                for (Phoneme p : s.phonemes) {
+                    if (p.index != s.phonemes.length - 1) {
+                        if (p.sound.equals(s.phonemes[p.index + 1].sound)) {
+                            p.sound = "";
+                        }
+                    }
+                    else if(s.successor!=null)
+                    {
+                        if (p.sound.equals(s.successor.phonemes[0].sound)) {
+                            p.sound = "";
+                        }
+                    }
+                }
+        }
     }
 
     /**
```
