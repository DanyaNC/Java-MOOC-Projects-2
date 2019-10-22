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
public class Box implements ToBeStored {
    private ArrayList<ToBeStored> toBeStoredList;
    private double maxWeight;
    
    public Box (double maxWeight) {
        this.maxWeight = maxWeight;
        this.toBeStoredList = new ArrayList<ToBeStored>();
    }
    
    public double weight() {
        double weight = 0;
        for(ToBeStored thing : toBeStoredList) {
            weight += thing.weight();
        }
        return weight;
    }
    
    public void add(ToBeStored toBeStored) {
        if (toBeStored.weight() + this.weight() <= this.maxWeight) {
            this.toBeStoredList.add(toBeStored);
        }
    }
    
    @Override
    public String toString() {
        return "Box: " + this.toBeStoredList.size() + 
               " things, total weight " + this.weight() + " kg";
    }
    
}
