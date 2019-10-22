/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Danya
 */
import java.util.List;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;


public class Printer {
    private File file;
    private Scanner reader;
    private List<String> fileContents;
    
    
    public Printer(String filename) throws Exception {
        this.file = new File(filename);
        this.reader = new Scanner(file);
        this.fileContents = new ArrayList<String>();    
    }
    
    private void loadContents() {
        while(this.reader.hasNextLine()) {
            String line = reader.nextLine();
            fileContents.add(line);
        }
    }
    
    public void printLinesWhichContain (String word) throws Exception {
        if(fileContents.isEmpty()) {
            loadContents();
        }
        
        if(word.isEmpty()) {
            for(String line : fileContents) {
                System.out.println(line);
            }
        } else {
            for(String line : fileContents) {
                if(line.contains(word)) {
                    System.out.println(line);
                }
            }
        }
    }
    
}
