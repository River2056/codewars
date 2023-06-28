package codewars;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * SecretStringTriplets
 */
public class SecretStringTriplets {

    public String recoverSecret(char[][] triplets) {
        Set<Character> set = new HashSet<>();
        for (char[] arr : triplets)
            for (char c : arr)
                set.add(c);
        
        List<Character> list = new ArrayList<>(set);
        int count;
        do {
            count = 0;
            for (int i = 0; i < triplets.length; i++) {
                for (int j = 0; j < triplets[i].length - 1; j++) {
                    int indexA = list.indexOf(triplets[i][j]);
                    int indexB = list.indexOf(triplets[i][j + 1]);
                    if (indexA > indexB) {
                        char temp = list.get(indexB);
                        list.set(indexB, list.get(indexA));
                        list.set(indexA, temp);
                        count++;
                    }
                }
            }
        } while (count > 0);
        
        return list.stream().map(String::valueOf).collect(Collectors.joining(""));
    }

    public String recoverSecretAttempt2(char[][] triplets) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Set<Character>> map = buildMap(triplets);

        while (!map.isEmpty()) {
            Map.Entry<Character, Set<Character>> last = findLast(map);
            sb.insert(0, last.getKey());
            remove(map, last.getKey());
        }

        return sb.toString();
    }

    private Map<Character, Set<Character>> buildMap(char[][] triplets) {
        Map<Character, Set<Character>> map = new HashMap<>();
        for (char[] cs : triplets) {
            for (char c : cs) {
                map.computeIfAbsent(c, key -> new HashSet<>());
            }
            map.get(cs[0]).add(cs[1]);
            map.get(cs[1]).add(cs[2]);
        }
        return map;
    }

    private Map.Entry<Character, Set<Character>> findLast(Map<Character, Set<Character>> map) {
        for (Map.Entry<Character, Set<Character>> entry : map.entrySet()) {
            if (entry.getValue().isEmpty())
                return entry;
        }
        return null;
    }

    private void remove(Map<Character, Set<Character>> map, char c) {
        map.remove(c);
        for (Set<Character> values : map.values()) {
            values.remove(c);
        }
    }
}
