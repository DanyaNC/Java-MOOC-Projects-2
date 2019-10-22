package wordinspection;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        // test your code here

        File file = new File("src/wordList.txt");
        // all words are in file src/wordList.txt
        WordInspection wordCheck = new WordInspection(file);
        System.out.println(wordCheck.wordsContainingZ());
        System.out.println(wordCheck.wordsEndingInL());
        System.out.println(wordCheck.palindromes());
        System.out.println(wordCheck.wordsWhichContainAllVowels());
        
    }
}
