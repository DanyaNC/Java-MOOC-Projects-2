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
public class BulkTank {
    private double tankCapacity;
    private double volume;
    
    
    public BulkTank() {
        tankCapacity = 2000;
        volume = 0;
    }
    
    public BulkTank(double capacity) {
        this.tankCapacity = capacity;
        volume = 0;
    }
    
    public double getCapacity() {
        return tankCapacity;
    }
    
    public double getVolume() {
        return volume;
    }
    
    public double howMuchFreeSpace() {
        return tankCapacity - volume;
    }
    
    public void addToTank(double amount) {
        volume += amount;
        if(tankCapacity < volume) {
            volume = tankCapacity;
        }
    }
    
    public double getFromTank(double amount) {
        double output = amount;
        volume -= amount;
        if(volume < 0) {
            output += Math.abs(volume);
            volume = 0;
        }
        return output;
    }
    
    @Override
    public String toString() {
        return "" + Math.ceil(volume) + "/" + Math.ceil(tankCapacity);
    }
}
