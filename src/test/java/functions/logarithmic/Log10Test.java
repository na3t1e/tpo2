package functions.logarithmic;


import static org.junit.jupiter.api.Assertions.assertEquals;

import functions.Mocks;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Log10Test {
    private Ln ln;
    private static Mocks mocks;
    private Log log10;

    @BeforeAll
    public static void setUp() {
        mocks = new Mocks();
    }

    @BeforeEach
    public void init() {
        ln = mocks.getLn();
        log10 = new Log(ln, 10);
    }

    @Test
    public void testCalculateInvalidParams() {
        assertEquals(Double.NaN, log10.log(Double.NaN, 10), 1e-10);
        assertEquals(Double.NaN, log10.log(Double.POSITIVE_INFINITY, 10), 1e-10);
        assertEquals(Double.NaN, log10.log(Double.NEGATIVE_INFINITY, 10), 1e-10);
    }

    @Test
    public void testCalculateZero() {
        assertEquals(Double.NaN, log10.log(0, 10), 1e-10);
    }

    @Test
    public void testCalculateLessThanZero() {
        assertEquals(Double.NaN, log10.log(-1, 10), 1e-10);
        assertEquals(Double.NaN, log10.log(-10, 10), 1e-10);
    }

    @Test
    public void testCalculateLessThanOne() {
        assertEquals(-0.3010299956639812, log10.log(0.5, 10), 1e-3);
        assertEquals(-0.6989700043360189, log10.log(0.2, 10), 1e-3);
    }

    @Test
    public void testCalculateOne() {
        assertEquals(0.0, log10.log(1, 10), 1e-10);
    }

    @Test
    public void testCalculateTens() {
        assertEquals(1.0, log10.log(10, 10), 1e-10);
        assertEquals(2.0, log10.log(100, 10), 1e-10);
        assertEquals(3.0, log10.log(1000, 10), 1e-10);
    }
}
