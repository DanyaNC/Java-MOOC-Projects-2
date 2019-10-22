/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

/**
 *
 * @author Danya
 */
import logic.PhoneSystem;
import java.util.Scanner;

public class UserInterface {

    private Scanner reader;

    public UserInterface() {
        this.reader = new Scanner(System.in);
    }

    public void start() {
        PhoneSystem phoneSystem = new PhoneSystem();
        printCommands();
        while (true) {
            System.out.print("command: ");
            String command = reader.nextLine();
            if (command.equals("x")) {
                break;
            }
            int numcommand = Integer.parseInt(command);
            switch (numcommand) {
                case 1:
                    //Add a number
                    addNumberCommand(phoneSystem);
                    break;
                case 2:
                    //Search for a number by person name
                    searchNumberCommand(phoneSystem);
                    break;
                case 3:
                    //Search for a person by phone number
                    searchByNumberCommand(phoneSystem);
                    break;
                case 4:
                    //Add an address
                    addAddressCommand(phoneSystem);
                    break;
                case 5:
                    //Search for personal information
                    searchPersonalInfoCommand(phoneSystem);
                    break;
                case 6:
                    //Remove personal info
                    removeInfoCommand(phoneSystem);
                    break;
                case 7:
                    //Search the names + addresses for a keyword
                    //Otherwise print all
                    filteredListCommand(phoneSystem);
                    break;
                default:
                    System.out.println("Please enter a valid command");
            }

        }
    }

    private void printCommands() {
        System.out.println("phone search");
        System.out.println("available operations:");
        System.out.println(" 1 add a number");
        System.out.println(" 2 search for a number");
        System.out.println(" 3 search for a person by phone number");
        System.out.println(" 4 add an address");
        System.out.println(" 5 search for personal information");
        System.out.println(" 6 delete personal information");
        System.out.println(" 7 filtered listing");
        System.out.println(" x quit");
        System.out.println();
    }

    private void addNumberCommand(PhoneSystem phoneSystem) {
        System.out.print("whose number: ");
        String name = reader.nextLine();
        System.out.print("number: ");
        String number = reader.nextLine();
        phoneSystem.addNumber(name, number);
        System.out.println();
    }
    
    private void searchNumberCommand(PhoneSystem phoneSystem) {
        System.out.print("whose number: ");
        String name = reader.nextLine();
        phoneSystem.searchByPerson(name);
        System.out.println();
    }
    
    private void searchByNumberCommand(PhoneSystem phoneSystem) {
        System.out.print("number: ");
        String number = reader.nextLine();
        phoneSystem.searchByNumber(number);
        System.out.println();
    }
    
    private void addAddressCommand(PhoneSystem phoneSystem) {
        System.out.print("whose address: ");
        String name = reader.nextLine();
        System.out.print("street: ");
        String address = reader.nextLine();
        System.out.print("city: ");
        address += " " + reader.nextLine();
        phoneSystem.addAddress(name, address);
        System.out.println();
    }

    private void searchPersonalInfoCommand(PhoneSystem phoneSystem) {
        System.out.print("whose information: ");
        String name = reader.nextLine();
        phoneSystem.searchForPersonalInfo(name);
        System.out.println();
    }
    
    private void removeInfoCommand(PhoneSystem phoneSystem) {
        System.out.print("whose information: ");
        String name = reader.nextLine();
        phoneSystem.removeInfo(name);
        System.out.println();
    }
    
    private void filteredListCommand(PhoneSystem phoneSystem) {
        System.out.print("keyword (if empty, all listed) ");
        String keyword = reader.nextLine();
        System.out.println();
        phoneSystem.filteredListInfo(keyword);
    }
    
}
