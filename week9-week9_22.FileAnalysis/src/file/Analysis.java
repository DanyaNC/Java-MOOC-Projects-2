/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

/**
 *
 * @author Danya
 */
import java.io.File;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Analysis {

    private File file;
    private Scanner reader;
    private List<String> fileContents;

    public Analysis(File file) {
        try {
            this.file = file;
            this.reader = new Scanner(file);
            this.fileContents = new ArrayList<String>();
            loadContents();

        } catch (Exception e) {
            throw new IllegalArgumentException("Please enter a valid file directory");
        }

    }

    private void loadContents() {
        while (reader.hasNextLine()) {
            String eachLine = reader.nextLine();
            fileContents.add(eachLine);
        }
    }

    public int lines() {
        return fileContents.size();
    }

    public int characters() {
        int characterCount = 0;
        try {
            for (String line : fileContents) {
                System.out.println(line);
                characterCount += line.length() + 1;
                System.out.println(characterCount + " Length: " + line.length());
            }
            return characterCount;
        }
        catch (Exception e) {
            throw new IllegalArgumentException("No file found.");
        }

    }

}
