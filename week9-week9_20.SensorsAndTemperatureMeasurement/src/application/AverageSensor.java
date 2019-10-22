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
import java.util.List;
import java.util.ArrayList;
public class AverageSensor implements Sensor{
    private List<Sensor> sensorList;
    private List<Integer> readingsList;
    
    public AverageSensor() {
        this.sensorList = new ArrayList<Sensor>();
        this.readingsList = new ArrayList<Integer>();
    }
    
    public void addSensor(Sensor additional) {
        sensorList.add(additional);
        checkStates();
    }
    
    public boolean checkStates() {
        for(Sensor sensor : sensorList) {
            if(!sensor.isOn()) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public boolean isOn() {
        return checkStates();
    }
    
    @Override
    public int measure() {
        if(!checkStates()) {
            throw new IllegalStateException("The average sensor is off.");
        }
        int average = 0;
        for(Sensor sensor : sensorList) {
            average += sensor.measure();
        }
        average = average/sensorList.size();
        this.readingsList.add(average);
        return average;
    }
   
    @Override
    public void on() {
        for(Sensor sensor : sensorList) {
            sensor.on();
        }
    }
    
    @Override
    public void off() {
        for(Sensor sensor: sensorList) {
            sensor.off();
        }
    }
    
    
    public List<Integer> readings() {
        return this.readingsList;
    }
    
    
}
