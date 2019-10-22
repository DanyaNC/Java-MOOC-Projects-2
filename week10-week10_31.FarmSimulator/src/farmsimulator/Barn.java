/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

import java.util.Collection;

/**
 *
 * @author Danya
 */
public class Barn {

    private BulkTank barnTank;
    private MilkingRobot robot;

    public Barn(BulkTank tank) {
        barnTank = tank;
    }

    public BulkTank getBulkTank() {
        return this.barnTank;
    }

    public void installMilkingRobot(MilkingRobot milkingRobot) {
        milkingRobot.setBulkTank(barnTank);
        robot = milkingRobot;
    }
    
    public void takeCareOf(Cow cow) {
        try {
            robot.milk(cow);
        }
        catch (Exception e) {
            throw new IllegalStateException("The robot hasn't been installed yet");
        }
    }
    
    public void takeCareOf(Collection<Cow> cows) {
        for(Cow cow : cows) {
            try {
                robot.milk(cow);
            }
            catch (Exception e) {
                throw new IllegalStateException("The robot hasn't been installed yet");
            }
        }
    }
    
    @Override
    public String toString() {
        return "" + Math.ceil(barnTank.getVolume()) + "/" + barnTank.getCapacity();
    }
}
