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
public class Reader {
    private Scanner read = new Scanner(System.in);
    
    public String readString(){
        return read.nextLine();
    }
    
    public int readInteger(){
        return Integer.parseInt(read.nextLine());
    }
    
}
