/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Danya
 */

public class Thing {
    private int weight;
    private String name;
    
    public Thing(String name, int kg) {
        this.weight = kg;
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getWeight() {
        return this.weight;
    }
    
    public String toString() {
        return name + " (" + this.weight + " kg)";
    }
    
}
