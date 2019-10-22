/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordinspection;

/**
 *
 * @author Danya
 */
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class WordInspection {

    private File file;
    private List<String> fileContents;
    private Scanner reader;

    public WordInspection(File file) {
        try {
            this.file = file;
            this.fileContents = new ArrayList<String>();
            this.reader = new Scanner(file, "UTF-8");
            loadContents();
        }
        catch (Exception e) {
            throw new IllegalArgumentException("No file found.");
        }

    }

    private void loadContents() {
        while (reader.hasNextLine()) {
            String eachLine = reader.nextLine();
            fileContents.add(eachLine);
        }
    }

    public int wordCount() {
        return fileContents.size();
    }

    public List<String> wordsContainingZ() {
        List<String> zWords = new ArrayList<String>();
        for (String line : fileContents) {
            if (line.contains("z")) {
                zWords.add(line);
            }
        }
        return zWords;
    }
    
    public List<String> wordsEndingInL() {
        List<String> lEndingWords = new ArrayList<String>();
        for (String line : fileContents) {
            if(line.endsWith("l")) {
                lEndingWords.add(line);
            }
        }
        return lEndingWords;
    }
    
    public List<String> palindromes() {
        List<String> palindromeWords = new ArrayList<String>();
        for(String line : fileContents) {
            String check = reversedString(line);
            if (check.equals(line)) {
                palindromeWords.add(line);
            }
        }
        return palindromeWords;
    }

    private String reversedString(String normalString) {
        String reversedString = "";
        for(int i = normalString.length() - 1; i >= 0; i--) {
            reversedString += normalString.charAt(i);
        }
        return reversedString;
    }
    
    public List<String> wordsWhichContainAllVowels() {
        List<String> allVowels = new ArrayList<String>();
        for (String word : fileContents) {
            if(checkForVowels(word)) {
                allVowels.add(word);
            }
        }
        return allVowels;
    }
    
    
    private boolean checkForVowels(String word) {
        return word.contains("a") && word.contains("e") && word.contains("i") && 
                word.contains("o") && word.contains("u") && word.contains("y")
                && word.contains("ä") && word.contains("ö");
    }
}
