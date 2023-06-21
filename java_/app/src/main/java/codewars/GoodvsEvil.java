package codewars;

import java.util.stream.IntStream;

public class GoodvsEvil {
    public static String battle(String goodAmounts, String evilAmounts) {
        int totalGood = calculatePower(goodAmounts, "1 2 3 3 4 10");
        int totalEvil = calculatePower(evilAmounts, "1 2 2 2 3 5 10");

        if (totalGood > totalEvil)
            return "Battle Result: Good triumphs over Evil";
        else if (totalGood < totalEvil)
            return "Battle Result: Evil eradicates all trace of Good";
        else
            return "Battle Result: No victor on this battle field";
    }

    private static int calculatePower(String party, String worth) {
        String[] partyMembers = party.split(" ");
        String[] unitPower = worth.split(" ");

        return IntStream.range(0, partyMembers.length)
            .boxed()
            .map(idx -> Integer.valueOf(partyMembers[idx]) * Integer.valueOf(unitPower[idx]))
            .reduce(0, Integer::sum);
    }

    public static void main(String[] args) {
        System.out.println(battle("0 0 0 0 0 10", "0 1 1 1 1 0 0"));
        System.out.println(battle("1918 2760 4856 5634 8564 6016", "7752 310 3282 6483 5239 557 8589"));
    }
}
