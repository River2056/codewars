package codewars;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * RgbToHexConversionTest
 */
class RgbToHexConversionTest {

    @Test
    void testRgbToHexConversion() {
        assertEquals("FFFFFF", RgbToHexConversion.rgb(255, 255, 255));
        assertEquals("FFFFFF", RgbToHexConversion.rgb(255, 255, 300));
        assertEquals("000000", RgbToHexConversion.rgb(0, 0, 0));
        assertEquals("9400D3", RgbToHexConversion.rgb(148, 0, 211));
    }

    void testRgbToHexConversionStringFormat() {
        assertEquals("FFFFFF", RgbToHexConversion.rgbStringformat(255, 255, 255));
        assertEquals("FFFFFF", RgbToHexConversion.rgbStringformat(255, 255, 300));
        assertEquals("000000", RgbToHexConversion.rgbStringformat(0, 0, 0));
        assertEquals("9400D3", RgbToHexConversion.rgbStringformat(148, 0, 211));
    }
}
