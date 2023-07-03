package codewars;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Permutations
 */
public class Permutations {

    public static List<String> singlePermutations(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() == 1) {
            res.add(s);
            return res;
        }

        for (int i = 0; i < s.length(); i++) {
            String head = s.substring(i, i + 1);
            StringBuilder rest = new StringBuilder();
            rest.append(s.substring(0, i)).append(s.substring(i + 1));

            List<String> innerRes = singlePermutations(rest.toString());
            for (int j = 0; j < innerRes.size(); j++) {
                rest = new StringBuilder();
                innerRes.set(j, rest.append(innerRes.get(j)).append(head).toString());
            }
            res.addAll(innerRes);
        }
        return new ArrayList<>(new HashSet<>(res));
    }
}
