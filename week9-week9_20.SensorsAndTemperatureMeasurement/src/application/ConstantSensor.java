/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

/**
 *
 * @author Danya
 */
public class ConstantSensor implements Sensor{
    private int heldValue;
    
    public ConstantSensor(int heldValue) {
        this.heldValue = heldValue;
    }
    
    @Override
    public void on() {
        
    }
    
    @Override
    public void off() {
        
    }
    
    @Override
    public int measure() {
        return this.heldValue;
    }
    
    @Override
    public boolean isOn() {
        return true;
    }
}
