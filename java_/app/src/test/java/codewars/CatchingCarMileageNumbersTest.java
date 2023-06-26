package codewars;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * CatchingCarMileageNumbersTest
 */
class CatchingCarMileageNumbersTest {

    @Test
    void testCatchingCarMileageNumbers() {
        assertEquals(0, CatchingCarMileageNumbers.isInteresting(3, new int[] {1337, 256}));
        assertEquals(1, CatchingCarMileageNumbers.isInteresting(11209, new int[] {1337, 256}));
        assertEquals(1, CatchingCarMileageNumbers.isInteresting(109, new int[] {}));
        assertEquals(1, CatchingCarMileageNumbers.isInteresting(110, new int[] {}));
        assertEquals(1, CatchingCarMileageNumbers.isInteresting(3208, new int[] {}));
        assertEquals(1, CatchingCarMileageNumbers.isInteresting(3209, new int[] {}));
        assertEquals(1, CatchingCarMileageNumbers.isInteresting(119, new int[] {}));
        assertEquals(1, CatchingCarMileageNumbers.isInteresting(120, new int[] {}));
    }
}
