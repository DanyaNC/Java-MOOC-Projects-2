/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moving.domain;

/**
 *
 * @author Danya
 */
public class Item implements Thing, Comparable<Item> {
    private String name;
    private int weight;
    
    public Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }
    
    public String getName() {
        return this.name;
    }
    
    @Override
    public String toString() {
        return this.name + " (" + this.weight + " dm^3)";
    }
    
    @Override
    public int getVolume() {
        return this.weight;
    }
    
    @Override
    public int compareTo(Item otherItem) {
        return this.weight - otherItem.getVolume();
    }
    
}
