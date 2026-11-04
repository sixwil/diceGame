import java.util.ArrayList;

public class PlayerFile {

    static class Player {
        int guess;
        String name;
        int points = 0;
        ArrayList<DieFile.Die> playerDice = new ArrayList<DieFile.Die>();

        Player(String name, int dieNumberOfsides) {
            this.name = name;
            addDie(dieNumberOfsides);
        }

        void addDie(int numberOfSides) {
            this.playerDice.add(new DieFile.Die(numberOfSides));
        }

        void rollDice() {
            playerDice.getLast().roll();
        }

        int getDieValue() {
            return playerDice.getLast().getSideUp();
        }

        String getName() {
            return name;
        }

        void increaseScore() {
            points++;
        }

        int getPoints() {
            return points;
        }

        void setPoints(int points) {
            this.points = points;
        }

    }

    // public static void main(String[] args) {

    //     Player player1 = new Player("tom", 4);

    //     player1.addDie(99);

    //     player1.rollDice();

    //     System.out.println(player1.getDieValue());
    //     System.out.println(player1.getPoints());
    //     System.out.println(player1.getName());

    // }
}
