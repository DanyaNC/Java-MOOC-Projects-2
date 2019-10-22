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

public class Suitcase {

    private int maxWeight;
    private ArrayList<Thing> list;

    public Suitcase(int maxWeight) {
        this.maxWeight = maxWeight;
        this.list = new ArrayList<Thing>();
    }

    public void addThing(Thing thing) {
        int temp = this.totalWeight() + thing.getWeight();
        if (temp <= maxWeight) {
            this.list.add(thing);
        }
    }

    public String toString() {
        switch (this.list.size()) {
            case 0:
                return "empty (0 kg)";
            case 1:
                return "1 thing (" + this.totalWeight() + " kg";
            default:
                return this.list.size() + " things (" + this.totalWeight() + " kg)";
        }
    }

    public int totalWeight() {
        int output = 0;
        for (Thing thing : this.list) {
            output += thing.getWeight();
        }
        return output;
    }
    
    public Thing heaviestThing() {
        int heaviestIndex = 0;
        if(this.list.size() == 0) {
            return null;
        }
        for(int i=0; i < this.list.size(); i++) {
            if(this.list.get(i).getWeight() >= this.list.get(heaviestIndex).getWeight()) {
                heaviestIndex = i;
            }
        }
        return this.list.get(heaviestIndex);
    }
    
    public void printThings() {
        for(Thing thing: this.list) {
            System.out.println(thing);
        }
    }
        
    public ArrayList<Thing> getSuitcaseContent() {
        return this.list;
    }
    
}
