/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Danya
 */
import java.util.Scanner;
import java.util.HashMap;

public class TextUserInterface {
    private Dictionary dictionary;
    private Scanner reader;
    
    
    public TextUserInterface(Scanner reader, Dictionary dictionary) {
        this.reader = reader;
        this.dictionary = dictionary;
    }
    
    public void start() {
        String command;
        
        //Describe commands
        System.out.println("Statement: ");
        System.out.println("    add - adds a word pair to the dictionary");
        System.out.println("    translate - asks a word and prints its translation");       
        System.out.println("    quit - quit the text user interface");
        //Start the ui loop
        while(true) {
            //Input of the command
            System.out.print("Statement: ");
            command = reader.nextLine();
            //Translation of the command to a process
            if(command.equals("quit")) {
                System.out.println("Cheers!");
                break;
            } else if(command.equals("add")) {
                System.out.print("In Finnish: ");
                String word = reader.nextLine();
                System.out.print("Translation: ");
                String translation = reader.nextLine();
                this.add(word, translation);
                System.out.println();
            } else if(command.equals("translate")) {
                System.out.print("Give a word: ");
                String word = reader.nextLine();
                this.translate(word);
                System.out.println();
            } else {
                System.out.println("Unknown statement");
                System.out.println();
            }          
        }
    }
    
    public void add(String word, String translation) {
        this.dictionary.add(word, translation);
    }
    
    public void translate(String word) {
        System.out.println("Translation: " + this.dictionary.translate(word));       
    }
    
}
