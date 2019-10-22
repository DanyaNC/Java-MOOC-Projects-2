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
public class Thermometer implements Sensor{
    private boolean state;
    
    public Thermometer() {
        
    }
    
    @Override
    public int measure() {
        if(state == false) {
            throw new IllegalStateException("The thermometer is off");
        }
        return (int) (Math.random() * 60 - 30);
    }
    
    @Override
    public void off() {
        this.state = false;
    }
    
    @Override
    public void on() {
        this.state = true;
    }
    
    @Override
    public boolean isOn() {
        return this.state;
    }
    
}
