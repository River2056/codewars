package codewars;

import java.util.Map;

public class RgbToHexConversion {
    private static Map<Integer, String> map = Map.of(
        10, "A",
        11, "B",
        12, "C",
        13, "D",
        14, "E",
        15, "F"
    );
    
    public static String rgb(int r, int g, int b) {
        return String.join("", getHex(r), getHex(g), getHex(b));
    }

    private static String getHex(int n) {
        if (n > 255)
            n = 255;
        if (n < 0)
            n = 0;
        StringBuilder result = new StringBuilder();
        do {
            int r = n % 16;
            if (!map.containsKey(r))
                result.append(String.valueOf(r));
            else
                result.append(map.get(r));
            n /= 16;
        } while (n > 0);

        if (result.toString().length() == 1)
            result.append("0");

        return result.reverse().toString();
    }

    public static String rgbStringformat(int r, int g, int b) {
        if (r < 0) r = 0;
        if (g < 0) g = 0;
        if (b < 0) b = 0;
        if (r > 255) r = 255;
        if (g > 255) g = 255;
        if (b > 255) b = 255;
        return String.format("%02X%02X%02X", r, g, b);
    }
}
