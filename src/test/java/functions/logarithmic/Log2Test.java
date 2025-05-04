package functions.logarithmic;

import functions.Mocks;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Log2Test {
    private Ln ln;
    private static Mocks mocks;
    private Log log2;
    
    @BeforeAll
    public static void setUp() {
        mocks = new Mocks();
    }

    @BeforeEach
    public void init() {
        ln = mocks.getLn();
        log2 = new Log(ln, 2);
    }

    @Test
    public void testCalculateInvalidParams() {
        assertEquals(Double.NaN, log2.log(Double.NaN, 10), 1e-10);
        assertEquals(Double.NaN, log2.log(Double.POSITIVE_INFINITY, 10), 1e-10);
        assertEquals(Double.NaN, log2.log(Double.NEGATIVE_INFINITY, 10), 1e-10);
    }

    @Test
    public void testCalculateZero() {
        assertEquals(Double.NaN, log2.log(0, 10), 1e-10);
    }

    @Test
    public void testCalculateLessThanZero() {
        assertEquals(Double.NaN, log2.log(-1, 10), 1e-10);
        assertEquals(Double.NaN, log2.log(-10, 10), 1e-10);
    }

    @Test
    public void testCalculateLessThanOne() {
        assertEquals(-1.0, log2.log(0.5, 10), 1e-3);
        assertEquals(-2.321928094887362, log2.log(0.2, 10), 1e-3);
    }

    @Test
    public void testCalculateOne() {
        assertEquals(0.0, log2.log(1, 10), 1e-10);
    }

    @Test
    public void testCalculateTwos() {
        assertEquals(1.0, log2.log(2, 10), 1e-10);
        assertEquals(2.0, log2.log(4, 10), 1e-10);
        assertEquals(3.0, log2.log(8, 10), 1e-10);
    }
}
