/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Danya
 */
import java.util.ArrayList;
public class Calculator {
    private Reader reader = new Reader();
    private int calculations;
    public void start() {
        calculations = 0;
        while(true) {
            System.out.print("command: ");
            String command = reader.readString();
            if(command.equals("end")){
                break;
            } 
            if (command.equals("sum")){
                sum();
            }
            else if (command.equals("difference")){
                difference();
            } else if (command.equals("product")){
                product();
            }         
        }
        statistics();
    }

    private void sum() {
        ArrayList<Integer> list = this.askForValues();
        System.out.println("sum of the values " + (list.get(0) + list.get(1)));
        calculations++;
    }
    
    private void difference() {
        ArrayList<Integer> list = this.askForValues();
        System.out.println("difference of the values " + (list.get(0) - list.get(1)));
        calculations++;
    }
    
    private void product() {
        ArrayList<Integer> list = this.askForValues();
        System.out.print("product of the values" + (list.get(0) * list.get(1)));
        calculations++;
    }
    
    private void statistics() {
        System.out.println("Calculations done " + calculations);
    }
    
    private ArrayList<Integer> askForValues() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        System.out.print("value1: ");
        int value1 = reader.readInteger();
        list.add(value1);
        System.out.print("value2: ");
        int value2 = reader.readInteger();
        list.add(value2);
        return list;
    }
    
}
