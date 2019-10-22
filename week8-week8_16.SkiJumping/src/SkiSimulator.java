
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Danya
 */
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class SkiSimulator {

    private List<Participant> participants;
    private Random random;
    private int roundNumber;

    public SkiSimulator() {
        this.participants = new ArrayList<Participant>();
        this.random = new Random();
        this.roundNumber = 0;
    }

    public void addParticipant(String name) {
        Participant participant = new Participant(name);
        this.participants.add(participant);
    }

    public void jumpRound() {
        roundNumber++;
        System.out.println("Round " + roundNumber);
        System.out.println();

        //List of participants needs to be sorted first for order of jumps
        //Then printed
        Collections.sort(this.participants);
        System.out.println("Jumping order:");
        for (int i = 0; i < this.participants.size(); i++) {
            String name = this.participants.get(i).getName();
            int points = this.participants.get(i).getPoints();
            System.out.println("  " + (i + 1) + ". " + name + " ("
                    + points + " points)");
        }

        System.out.println("\n" + "Results of round " + roundNumber);
        //For every partcipant print the name, length of jump, and judge scores
        for (Participant participant : this.participants) {
            System.out.println("  " + participant.getName());
            int randomLength = random.nextInt(60) + 61;
            System.out.println("     length: " + randomLength);
            participant.jump(randomLength);
            System.out.println("     judge votes: " + judgeScores(participant));
        }
    }

    public String judgeScores(Participant participant) {
        List<Integer> scores = new ArrayList<Integer>();
        //Allocate a random judged score for 5 judges
        for (int i = 0; i < 5; i++) {
            scores.add(random.nextInt(10) + 10);
        }
        //Sort them by score awarded + declare variable to prepare to add points
        Collections.sort(scores);
        int pointsToBeAdded = 0;

        //Add the judge scores except for least and highest score
        for (int i = 1; i < 4; i++) {
            pointsToBeAdded += scores.get(i);
        }
        participant.addPoints(pointsToBeAdded);
        return scores.toString();
    }

    public void printResults() {
        System.out.println("Tournament results:");
        System.out.println("Position    Name");
        Collections.sort(participants);
        Collections.reverse(participants);
        for (int i = 0; i < this.participants.size(); i++) {
            System.out.print((i + 1) + "           " + participants.get(i).toString());
            System.out.println();
        }
    }

}
