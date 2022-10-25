package utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandUtils {

    public static String getRandomString() {
        String allChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
        StringBuilder strB = new StringBuilder(10);
        strB.append("a");

        for (int i = 0; i < 10; i++) {
            int index = (int)(allChars.length() * Math.random());
            strB.append(allChars.charAt(index));
        }

        return strB.toString();
    }

    public static List<Integer> getRands(int range, int exclude, int numOfRands) {
        List<Integer> indexes = new ArrayList<>();
        for(int i=1; i<range; i++) {
            if(i == exclude) {
                continue;
            }
            indexes.add(i);
        }
        Random rand = new Random();
        List<Integer> chosenRands = new ArrayList<>();
        for (int i = 0; i < numOfRands; i++) {
            int randomIndex = rand.nextInt(indexes.size());
            chosenRands.add(indexes.get(randomIndex));
            indexes.remove(randomIndex);
        }
        return chosenRands;
    }
}
