/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movable;

/**
 *
 * @author Danya
 */
import java.util.List;
import java.util.ArrayList;
public class Group implements Movable {
    private List<Movable> movableList;
    
    public Group() {
        this.movableList = new ArrayList<Movable>();
    }
    
    @Override
    public String toString() {
        String printableList = "";
        for(Movable movableObject : movableList) {
            printableList += movableObject.toString() + "\n";
        }
        return printableList;
    }

    public void addToGroup(Movable movable) {
        movableList.add(movable);
    }
    
    @Override
    public void move(int dx, int dy) {
        for(Movable movable : movableList) {
            movable.move(dx, dy);
        }
    }
    
}
