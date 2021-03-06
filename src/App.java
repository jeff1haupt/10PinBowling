import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) {

        String game1 = "1/ 11 11 11 1/ 11 11 11 11 11";
        String game2 = "X X X X X X X X X XXX";

        bowlingScore(game1);
        bowlingScore(game2);
    }

    public static int bowlingScore(String score) {

        int numScore = 0;
        int counter = 1;
        Map<Integer, String> frames = new HashMap<>();
        Map<Integer, Integer> framesScore = new HashMap<>();

        for (String str : score.split(" ")) {
            frames.put(counter, str);
            counter++;
        }

        int tempScore = 0;
        char tempChar;
        String tempString;

        for (int i = 1; i <= 10; i++) {
            tempString = frames.get(i);
            if ( !tempString.contains("X") && !tempString.contains("/") ) {
                tempChar = tempString.charAt(0);
                tempScore += Character.getNumericValue(tempChar);
                tempChar = tempString.charAt(1);
                tempScore += Character.getNumericValue(tempChar);
            } else if ( tempString.contains("/") ) {
                tempScore += 10;
                tempString = frames.get(i + 1);
                tempChar = tempString.charAt(0);
                if ( tempChar == 'X' ) {
                    tempScore += 10;
                } else {
                    tempScore += Character.getNumericValue(tempChar);
                }
            } else {
                tempScore += 10;
                if ( i < 9 ) {
                    for ( int k = 1; k <= 2; k++ ) {
                        tempString = frames.get(i + k);
                        tempChar = tempString.charAt(0);
                        if ( tempChar == 'X' ) {
                            tempScore += 10;
                        } else {
                            tempScore += Character.getNumericValue(tempChar);
                        }
                    }


                }


            }

        }
        System.out.println(tempScore);
        return 0;
    }
}
