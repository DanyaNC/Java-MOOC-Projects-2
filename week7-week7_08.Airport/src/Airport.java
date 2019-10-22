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
import java.util.HashMap;
import java.util.Scanner;

public class Airport {

    private HashMap<String, Plane> planes;
    private HashMap<String, String> flights;

    public Airport() {
        this.planes = new HashMap<String, Plane>();
        this.flights = new HashMap<String, String>();
    }

    public void addPlane(Plane plane) {
        planes.put(plane.getName(), plane);
    }

    public void addFlight(String planeID, String dept, String dest) {
        this.planes.get(planeID).addFlight(dept, dest);
    }

    public void printFlights() {
        for (String key : planes.keySet()) {
            for (String flight : planes.get(key).getFlights().keySet()) {
                System.out.println(planes.get(key) + " (" + flight + "-"
                        + planes.get(key).getFlights().get(flight) + ")");
            }
        }
    }

    public void printPlanes() {
        for (String key : planes.keySet()) {
            System.out.print(planes.get(key));
        }
    }

    public void prepFlightsHashMap(HashMap<String, String> flights) {
        String cleanFlights = flights.toString();
        cleanFlights.replace("{", "(");
    }

    public void printOnePlane(Scanner reader) {
        System.out.println("Give plane ID: ");
        String planeID = reader.nextLine();
        System.out.println(planes.get(planeID));
    }
}
