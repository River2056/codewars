package java_.com.river;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PascalTriangle {

    public static long[] generate(int level) {
        Map<Integer, List<Long>> tri = new HashMap<>();
        List<Long> result = new ArrayList<>();
        triangle(level, 1, tri);

        for (int i = 1; i <= level; i++)
            result.addAll(tri.get(i));

        return result.stream().mapToLong(i -> i).toArray();
    }

    // generate each layer recursively, save to cache
    private static void triangle(int level, int current, Map<Integer, List<Long>> cache) {
        List<Long> layer = new ArrayList<>();
        if (current <= 2) {
            for (int i = 0; i < current; i++)
                layer.add(1L);
        } else {
            for (int i = 0; i < 2; i++)
                layer.add(1L);

            List<Long> previousLayer = cache.get(current - 1);
            for (int i = 1; i < current - 1; i++) {
                Long element = previousLayer.get(i) + previousLayer.get(i - 1);
                layer.add(i, element);
            }
        }

        cache.computeIfAbsent(current, l -> layer);
        if (level == current)
            return;
        triangle(level, current + 1, cache);
    }

    public static long[] generate2(int level) {
        final List<Long> res = new ArrayList<>();
        for (int i = 0; i < level; i++) {
            long num = 1;
            for (int j = 0; j <= i; j++) {
                res.add(num);
                num = (num * (i - j)) / (j + 1);
            }
        }

        return res.stream().mapToLong(i -> i).toArray();
    }

    public static void main(String[] args) {
        long[] result = generate(2);
        System.out.println(Arrays.toString(result));

        result = generate(4);
        System.out.println(Arrays.toString(result));
    }
}
