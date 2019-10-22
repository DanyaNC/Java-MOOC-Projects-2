
public class Smileys {

    public static void main(String[] args) {
        // Test your method at least with the following
        // printWithSmileys("Method");
        // printWithSmileys("Beerbottle");
        // printWithSmileys("Interface");

    }

    private static void printWithSmileys(String characterString) {
        printRow(characterString);
        System.out.println(printMiddle(characterString));
        printRow(characterString);
    }

    public static void printRow(String characterString) {
        for(int i = 0; i < printMiddle(characterString).length()/2; i++) {
            System.out.print(":)");
        }
        System.out.println();
    }
    
    public static String printMiddle(String characterString) {
        if (characterString.length() % 2 == 1) {
            return ":) " + characterString + "  :)";
        } 
        return ":) " + characterString + " :)";
    }
}
