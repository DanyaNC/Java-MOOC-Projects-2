/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Danya
 */
import java.util.HashMap;

public class Plane {
    private String name;
    private int capacity;
    private HashMap<String, String> flights;
    
    public Plane(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.flights = new HashMap<String, String>();
    }
    
    public String getName() {
        return this.name;
    }
    
    public String toString() {
        return this.name + " (" + this.capacity  + " ppl)";
    }
    
    public void addFlight(String dept, String dest) {
        this.flights.put(dept, dest);
    }
    
    public HashMap<String, String> getFlights() {
        return this.flights;
    }
}
