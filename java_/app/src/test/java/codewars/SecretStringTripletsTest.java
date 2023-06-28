package codewars;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * SecretStringTripletsTest
 */
class SecretStringTripletsTest {

    @Test
    void testSecretStringTriplets() {
        SecretStringTriplets s = new SecretStringTriplets();
        assertEquals("whatisup", s.recoverSecret(new char[][] {
            {'t','u','p'},
            {'w','h','i'},
            {'t','s','u'},
            {'a','t','s'},
            {'h','a','p'},
            {'t','i','s'},
            {'w','h','s'}
        }));
    }

    @Test
    void testSecretStringTripletsAttempt2() {
        SecretStringTriplets s = new SecretStringTriplets();
        assertEquals("whatisup", s.recoverSecretAttempt2(new char[][] {
            {'t','u','p'},
            {'w','h','i'},
            {'t','s','u'},
            {'a','t','s'},
            {'h','a','p'},
            {'t','i','s'},
            {'w','h','s'}
        }));
    }
}
