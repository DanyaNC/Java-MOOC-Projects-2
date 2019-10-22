/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Danya
 */
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class RingingCentre {

    private Map<Bird, List<String>> observations;

    public RingingCentre() {
        this.observations = new HashMap<Bird, List<String>>();
    }

    public void observe(Bird bird, String place) {
        if (!this.observations.containsKey(bird)) {
            observations.put(bird, new ArrayList<String>());
        }
        observations.get(bird).add(place);
    }

    public void observations(Bird bird) {
        //Print observation info of the bird
        for (Bird listBird : this.observations.keySet()) {
            /* Prints in the format :
            Name (year) observations : #
            Observation 1
            Observation n
             */
            
            if (listBird.equals(bird)) {
                System.out.println(listBird.getLatinName() + " ("
                        + listBird.getYear() + ") observations: "
                        + observations.get(bird).size());
                for (String place : observations.get(bird)) {
                    System.out.println(place);
                }
            }
        }
        if (!this.observations.keySet().contains(bird)) {
                System.out.println(bird.getLatinName() + " ("+
                        bird.getYear() + ") observations: 0");
            } 
    }

}
