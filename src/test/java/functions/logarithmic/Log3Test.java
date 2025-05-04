package functions.logarithmic;


import static org.junit.jupiter.api.Assertions.assertEquals;


import functions.Mocks;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Log3Test {
    private Ln ln;
    private static Mocks mocks;
    private Log log3;

    @BeforeAll
    public static void setUp() {
        mocks = new Mocks();
    }

    @BeforeEach
    public void init() {
        ln = mocks.getLn();
        log3 = new Log(ln, 5);
    }

    @Test
    public void testCalculateInvalidParams() {
        assertEquals(Double.NaN, log3.log(Double.NaN, 10), 1e-10);
        assertEquals(Double.NaN, log3.log(Double.POSITIVE_INFINITY, 10), 1e-10);
        assertEquals(Double.NaN, log3.log(Double.NEGATIVE_INFINITY, 10), 1e-10);
    }

    @Test
    public void testCalculateZero() {
        assertEquals(Double.NaN, log3.log(0, 10), 1e-10);
    }

    @Test
    public void testCalculateLessThanZero() {
        assertEquals(Double.NaN, log3.log(-1, 10), 1e-10);
        assertEquals(Double.NaN, log3.log(-10, 10), 1e-10);
    }

    @Test
    public void testCalculateLessThanOne() {
        assertEquals(-0.43067655807339306, log3.log(0.5, 10), 1e-3);
        assertEquals(-1, log3.log(0.2, 10), 1e-3);
    }

    @Test
    public void testCalculateOne() {
        assertEquals(0.0, log3.log(1, 10), 1e-10);
    }

    @Test
    public void testCalculateFives() {
        assertEquals(1.0, log3.log(5, 10), 1e-10);
        assertEquals(2.0, log3.log(25, 10), 1e-10);
        assertEquals(3.0, log3.log(125, 10), 1e-10);
    }

}
