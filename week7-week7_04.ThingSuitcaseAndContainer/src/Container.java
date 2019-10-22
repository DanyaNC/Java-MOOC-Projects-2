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

public class Container {
    private int maxWeight;
    private ArrayList<Suitcase> container;
    
    public Container(int maxWeight) {
        this.maxWeight = maxWeight;
        this.container = new ArrayList<Suitcase>();
    }
    
    
    public void addSuitcase(Suitcase suitcase) {
        int temp = this.containerWeight() + suitcase.totalWeight();
        if(temp <= maxWeight) {
            container.add(suitcase);
        }
    }
    
    public String toString() {
        return container.size() + " suitcases (" + this.containerWeight() + " kg)";
    }
    
    public int containerWeight() {
        int output = 0;
        for(Suitcase suitcase : this.container) {
            output += suitcase.totalWeight();
        }
        return output;
    }
    
    public void printThings() {
        for(Suitcase suitcase : this.container) {
            for(Thing thing: suitcase.getSuitcaseContent()) {
                System.out.println(thing);
            }
        }
    }
}
