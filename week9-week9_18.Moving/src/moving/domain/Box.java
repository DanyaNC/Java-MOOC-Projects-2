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
import java.util.List;
import java.util.ArrayList;
public class Box implements Thing{
    private int maximumCapacity;
    private List<Thing> contents;
    
    public Box(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
        this.contents = new ArrayList<Thing>();
    }
    
    public boolean addThing(Thing thing) {
        if(this.getVolume() + thing.getVolume() <= maximumCapacity) {
            this.contents.add(thing);
            return true;
        }
        return false;
    }
    
    public void clear() {
        this.contents.clear();
    }
    
    @Override
    public int getVolume() {
        int volumeOfBox = 0;
        for(Thing thing : contents) {
            volumeOfBox += thing.getVolume();
        }
        return volumeOfBox;
    }
    
}
