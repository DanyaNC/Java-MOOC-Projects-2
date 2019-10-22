/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Danya
 */
import java.util.Scanner;

public class UserInterface {

    private Scanner read;

    public UserInterface(Scanner scanner) {
        this.read = scanner;
    }

    public void start() {
        SkiSimulator skiSim = new SkiSimulator();
        System.out.println("Kumpula ski jumping week" + "\n");
        System.out.println("Write the names of the participants one at a time; "
                + "an empty string brings you to the jumping phase.");
        while (true) {
            System.out.print("  Participant name: ");
            String name = read.nextLine();
            if (name.isEmpty()) {
                break;
            }
            skiSim.addParticipant(name);
        }
        System.out.println();
        System.out.println("The tournament begins!");

        while (true) {
            System.out.print("\n" + "Write \"jump\" to jump; otherwise you quit: ");
            String command = read.nextLine();
            System.out.println();
            if (!command.equals("jump")) {
                break;
            }
            skiSim.jumpRound();
        }
        System.out.println("Thanks!" + "\n");
        skiSim.printResults();
    }

}
