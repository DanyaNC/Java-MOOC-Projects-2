/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

import java.util.Random;

/**
 *
 * @author Danya
 */
public class Cow implements Milkable, Alive {

    private static final String[] NAMES = new String[]{
        "Anu", "Arpa", "Essi", "Heluna", "Hely",
        "Hento", "Hilke", "Hilsu", "Hymy", "Ihq", "Ilme", "Ilo",
        "Jaana", "Jami", "Jatta", "Laku", "Liekki",
        "Mainikki", "Mella", "Mimmi", "Naatti",
        "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
        "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};

    private String name;
    private double udderCapacity;
    private double currentVolume;
    private Random random;

    public Cow() {
        random = new Random();
        name = NAMES[random.nextInt(32)];
        udderCapacity = 15 + random.nextInt(26);
        currentVolume = 0;
    }

    public Cow(String name) {
        this.name = name;
        random = new Random();
        udderCapacity = 15 + random.nextInt(26); 
        currentVolume = 0;
    }

    public String getName() {
        return this.name;
    }

    public double getCapacity() {
        return udderCapacity;
    }

    public double getAmount() {
        return currentVolume;
    }
    
    @Override
    public String toString() {
        return "" + name + " " + Math.ceil(currentVolume) + "/" + udderCapacity;
    }
    
    @Override
    public double milk() {
        double output = currentVolume;
        currentVolume = 0;
        return output;
    }

    @Override
    public void liveHour() {
        if(currentVolume < udderCapacity) {
            currentVolume += (.7 + (1.0*random.nextInt(13))/10);
        }
        if(currentVolume > udderCapacity) {
            currentVolume = udderCapacity;
        }
        
    } 
    
}
