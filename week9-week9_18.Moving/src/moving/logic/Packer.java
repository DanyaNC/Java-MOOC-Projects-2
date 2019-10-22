/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moving.logic;

/**
 *
 * @author Danya
 */
import java.util.List;
import java.util.ArrayList;
import moving.domain.Thing;
import moving.domain.Box;

public class Packer {
    private int boxesVolume;
    
    public Packer(int boxesVolume) {
        this.boxesVolume = boxesVolume;
    }
    
    public List<Box> packThings(List<Thing> things) {
        List<Box> boxes = new ArrayList<Box>();
        
        for(Thing thing : things) {
            Box nBox = new Box(boxesVolume);
            while(true) {
                if(nBox.addThing(thing)) {
                    ;
                } else {
                    boxes.add(nBox);
                    break;
                }
            }
        }
        return boxes;
    }
    
}
