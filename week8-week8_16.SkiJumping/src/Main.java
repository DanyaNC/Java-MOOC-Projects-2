import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        UserInterface ui = new UserInterface(read);
        ui.start();
    }
}
