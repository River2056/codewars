package codewars;

import java.util.stream.Stream;

/**
 * TotalPoints
 */
public class TotalPoints {

    public static int points(String[] games) {
        return Stream.of(games).map(scoreStr -> {
            String[] scoreArr = scoreStr.split(":");
            int x = Integer.parseInt(scoreArr[0]);
            int y = Integer.parseInt(scoreArr[1]);
            if (x > y)
                return 3;
            else if (x < y)
                return 0;
            else
                return 1;
        }).reduce(0, (acc, element) -> acc + element);
    }
}
