import java.util.Random;

public class DieFile {

    static class Die{
        int sideUp;
        int numberOfSides;
        private Random rand = new Random();

        Die(int numberOfSides){
            this.numberOfSides = numberOfSides;
            roll();
        }

        int getSideUp(){
            return sideUp;
        }
        
        int getAmmountOfSides(){
            return numberOfSides;
        }


        public void roll(){
            sideUp = rand.nextInt(numberOfSides) + 1;
        }

    }

    // public static void main(String[] args) {

    //     Die d10 = new Die(10);

    //     for (int i = 0; i < 100; i++) {
    //         d10.roll();
    //     }
        
    // }
}
