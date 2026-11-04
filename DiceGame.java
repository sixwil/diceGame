import java.util.Scanner;

public class DiceGame {

    static class generalValues{
        static Scanner consoleScanner = new Scanner(System.in);
        static boolean setupFinished = false;
        
        static gameSettings game1Settings = new gameSettings();
        static PlayerFile.Player player1 = new PlayerFile.Player(generalValues.game1Settings.playerName, generalValues.game1Settings.numberOfDiceSides);
    }

    public static void main(String[] args) {

        for (int round = 0; round < generalValues.game1Settings.totalRounds; round++) {
            System.out.println();
            System.out.println(
                    "round: " + (round + 1) + "/" + generalValues.game1Settings.totalRounds + ", score: " + generalValues.player1.getPoints());
            

            generalValues.player1.guess = Integer.parseInt(
                    stubbornPrompt(true,
                            "1 -> " + generalValues.player1.playerDice.getLast().numberOfSides + ", vad tror du tärningen slår?: "));

            System.out.println();
            generalValues.player1.rollDice();

            if (generalValues.player1.guess == generalValues.player1.getDieValue()) {
                System.out.print("rätt! ");
                generalValues.player1.increaseScore();
            } else {
                System.out.print("fel, ");
            }
            System.out.println("rolled: " + generalValues.player1.playerDice.getLast().getSideUp() + "/"
                    + generalValues.player1.playerDice.getLast().numberOfSides);

        }
        System.out.println();
        System.out.println("Final score: " + generalValues.player1.getPoints());
        System.out.println();

    }

    static String stubbornPrompt(boolean isNumber, String questionText) {
        String input;

        do {

            System.out.print(questionText);
            input = generalValues.consoleScanner.nextLine();

            if (isNumber) {
                try {

                    int intImp = Integer.parseInt(input);

                    if (generalValues.setupFinished){

                        if (intImp > generalValues.game1Settings.numberOfDiceSides){
                            System.out.println("maximum of: " + generalValues.game1Settings.numberOfDiceSides);
                            continue;
                        }
                    }
                    if (intImp > 0){
                        break;
                    } else {
                        System.out.println("Has to be bigger than 0");
                    }
                } catch (Exception e) {
                    System.out.println("Error, has to be a positive integer (whole number)");
                }
            }

        } while (isNumber);

        // if (!isNumber){
        //     generalValues.setupFinished = true;
        // }

        return input;
    }

    static class gameSettings {
        int totalRounds = 0;
        int numberOfDiceSides;
        String playerName;

        gameSettings() {

            this.totalRounds = Integer.parseInt(stubbornPrompt(true, "Hur många omgångar?: "));
            this.numberOfDiceSides = Integer.parseInt(stubbornPrompt(true, "Hur många sidor på tärningen?: "));
            this.playerName = stubbornPrompt(false, "Vad vill du kallas?: ");
            generalValues.setupFinished = true;

        }
    }

}
