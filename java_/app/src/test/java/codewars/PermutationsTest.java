package codewars;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

/**
 * PermutationsTest
 */
class PermutationsTest {

    @Test public void example1() {
        assertEquals( new ArrayList<String>(Arrays.asList("a")),
                      Permutations.singlePermutations("a").stream().sorted().collect(Collectors.toList()) );
    }
    
    @Test public void example2() {
        assertEquals( new ArrayList<String>(Arrays.asList("ab","ba")),
                      Permutations.singlePermutations("ab").stream().sorted().collect(Collectors.toList()) );
    }
    
    @Test public void example3() {
        assertEquals( new ArrayList<String>(Arrays.asList("aabb", "abab", "abba", "baab", "baba", "bbaa")),
                      Permutations.singlePermutations("aabb").stream().sorted().collect(Collectors.toList()) );
    }
}
