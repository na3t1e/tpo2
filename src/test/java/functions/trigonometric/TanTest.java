package functions.trigonometric;

import functions.Mocks;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TanTest {
    private Sin sin;
    private Cos cos;
    private static Mocks mocks;
    private Tan tan;

    @BeforeAll
    public static void setUp() {
        mocks = new Mocks();
    }

    @BeforeEach
    public void init() {
        sin = mocks.getSin();
        cos = mocks.getCos();
        tan = new Tan(sin, cos);
    }

    @Test
    public void testCalculateInvalidParams() {
        assertEquals(Double.NaN, tan.tan(Double.NaN, 10), 1e-10);
        assertEquals(Double.NaN, tan.tan(Double.POSITIVE_INFINITY, 10), 1e-10);
        assertEquals(Double.NaN, tan.tan(Double.NEGATIVE_INFINITY, 10), 1e-10);
    }

    @Test
    public void testCalculateZero() {
        assertEquals(0.0, tan.tan(0, 10), 1e-10);
        assertEquals(0.0, tan.tan(2 * Math.PI, 10), 1e-10);
        assertEquals(0.0, tan.tan(-2 * Math.PI, 10), 1e-10);
    }

    @Test
    public void testCalculatePi() {
        assertEquals(0.0, tan.tan(Math.PI, 10), 1e-10);
        assertEquals(0.0, tan.tan(-Math.PI, 10), 1e-10);
    }

    @Test
    public void testCalculatePiDividedByTwo() {
        assertEquals(Double.NaN, tan.tan(Math.PI / 2, 10), 1e-10);
        assertEquals(Double.NaN, tan.tan(-Math.PI / 2, 10), 1e-10);
    }

    @Test
    public void testCalculatePiDividedByFour() {
        assertEquals(1.0, tan.tan(Math.PI / 4, 10), 1e-10);
        assertEquals(-1.0, tan.tan(-Math.PI / 4, 10), 1e-10);
    }
}
