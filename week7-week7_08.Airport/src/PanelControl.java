
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Danya
 */

public class PanelControl {
    private Scanner reader;
    private Airport airport;
    
    public PanelControl(Scanner reader) {
        this.reader = reader;
        this.airport = new Airport();
    }
    
    public void start() {
        //Airport Panel
        System.out.println("Airport panel");
        System.out.println("--------------------" + "\n");
        while(true) {
            printAirportCommands();
            String command = this.reader.nextLine();
            if(command.equals("1")) {
                createPlane();
            } else if(command.equals("2")) {
                createFlight();
            } else if(command.equals("x")) {
                break;
            }          
        }
        //Flight service
        System.out.println("Flight service");
        System.out.println("------------" + "\n");
        while(true) {
            printFlightServiceCommands();
            String command = this.reader.nextLine();
            if(command.equals("1")) {
                this.airport.printPlanes();
                System.out.println();
            } else if(command.equals("2")) {
                this.airport.printFlights();
                System.out.println();
            } else if(command.equals("3")) {
                this.airport.printOnePlane(reader);
                System.out.println();
            } else if (command.equals("x")) {
                break;
            }
        }
    }
    
    public void printAirportCommands() {
        System.out.println("Choose operation:");
        System.out.println("[1] Add airplane");
        System.out.println("[2] Add flight");
        System.out.println("[x] Exit");
    }
    
    public void printFlightServiceCommands() {
        System.out.println("Choose operation:");
        System.out.println("[1] Print planes");
        System.out.println("[2] Print flights");
        System.out.println("[3] Print plane info");
        System.out.println("[x] Quit");      
    }
    
    public String cleanString(String string) {
        string = string.toUpperCase();
        string = string.trim();
        return string;
    }
    
    public void createPlane() {
        System.out.print("Give plane ID: ");
        String name = this.reader.nextLine();
        System.out.print("Give plane capacity: ");
        int capacity = Integer.parseInt(this.reader.nextLine());
        Plane plane = new Plane(name, capacity);
        this.airport.addPlane(plane);
    }
    
    public void createFlight() {
        System.out.print("Give plane ID: ");
        String planeID = this.reader.nextLine();
        System.out.print("Give departure airport code: ");
        String dept = this.reader.nextLine();
        System.out.print("Give destination airport code: ");
        String dest = this.reader.nextLine();
        this.airport.addFlight(planeID, dept, dest);
    }
}
