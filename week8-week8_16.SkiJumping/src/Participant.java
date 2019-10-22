/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Danya
 */
import java.util.List;
import java.util.ArrayList;

public class Participant implements Comparable<Participant> {

    private int points;
    private final String name;
    private List<String> jumpLengths;

    public Participant(String name) {
        this.points = 0;
        this.name = name;
        this.jumpLengths = new ArrayList<String>();
    }

    public int getPoints() {
        return this.points;
    }

    public void addPoints(int integer) {
        this.points += integer;
    }

    public String getName() {
        return this.name;
    }

    public void jump(int length) {
        addPoints(length);
        this.jumpLengths.add(length + " m");
    }

    @Override
    public String toString() {
        String jumpLengthsInString = "";
        for (String jump : this.jumpLengths) {
            jumpLengthsInString += jump + ", ";
        }
        jumpLengthsInString
                = jumpLengthsInString.substring(0, jumpLengthsInString.length() - 2);
        String output = "" + this.name + " (" + this.points + " points)" + "\n"
                + "            " + "jump lengths: " + jumpLengthsInString;
        return output;
    }

    @Override
    public int compareTo(Participant participant2) {
        return this.points - participant2.getPoints();
    }

}
