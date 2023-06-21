package codewars;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * NumberOfTrailingZerosofNFactorialTest
 */
class NumberOfTrailingZerosofNFactorialTest {

    @Test
    void testNumberOfTrailingZerosofNFactorial() {
        assertEquals(0, NumberOfTrailingZerosofNFactorial.zeroes(0)); 
        assertEquals(1, NumberOfTrailingZerosofNFactorial.zeroes(6)); 
        assertEquals(2, NumberOfTrailingZerosofNFactorial.zeroes(14));
    }

    @Test
    void testNumberOfTrailingZerosofNFactorial2() {
        assertEquals(0, NumberOfTrailingZerosofNFactorial.zeroes2(0)); 
        assertEquals(1, NumberOfTrailingZerosofNFactorial.zeroes2(6)); 
        assertEquals(2, NumberOfTrailingZerosofNFactorial.zeroes2(14));
    }
}
