/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

/**
 *
 * @author Danya
 */
import java.util.List;
import java.util.ArrayList;
public class Farm implements Alive {
    private List<Cow> cowsOnFarm;
    private Barn farmBarn;
    private String owner;
    
    public Farm(String owner, Barn barn) {
        cowsOnFarm = new ArrayList<Cow>();
        farmBarn = barn;
        this.owner = owner;
    }
    
    public void addCow(Cow cow) {
        cowsOnFarm.add(cow);
    }
    
    @Override
    public void liveHour() {
        for(Cow cow : cowsOnFarm) {
            cow.liveHour();
        }
    }
    
    public String getOwner() {
        return this.owner;
    }
    
    public void manageCows() {
        farmBarn.takeCareOf(cowsOnFarm);
    }
    
    public void installMilkingRobot(MilkingRobot robot) {
        farmBarn.installMilkingRobot(robot);
    }
    
    @Override
    public String toString() {
        String output = "Farm Owner : " + owner + "\n" +
                "Barn bulk tank : " + farmBarn;
        if(cowsOnFarm.isEmpty()) {
            output += "\n No cows";
            return output;
        }
        output += "\nAnimals:";
        for(Cow cow : cowsOnFarm) {
            output += "\n " + "        " + cow;
        }
        return output;
    }
}
