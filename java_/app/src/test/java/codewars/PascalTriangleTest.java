package codewars;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**
 * PascalTriangleTest
 */
class PascalTriangleTest {

    @Test
    void testPascalTriangle() {
        assertArrayEquals(new long[] {1, 1, 1}, PascalTriangle.generate(2));
        assertArrayEquals(new long[] {1, 1, 1, 1, 2, 1, 1, 3, 3, 1}, PascalTriangle.generate(4));
    }

    @Test
    void testPascalTriangleGenerate2() {
        assertArrayEquals(new long[] {1, 1, 1}, PascalTriangle.generate2(2));
        assertArrayEquals(new long[] {1, 1, 1, 1, 2, 1, 1, 3, 3, 1}, PascalTriangle.generate2(4));
    }
}
