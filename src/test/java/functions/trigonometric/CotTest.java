package functions.trigonometric;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import functions.Mocks;

public class CotTest {
    private Sin sin;
    private Cos cos;
    private static Mocks mocks;
    private Cot cot;

    @BeforeAll
    public static void setUp() {
        mocks = new Mocks();
    }

    @BeforeEach
    public void init() {
        sin = mocks.getSin();
        cos = mocks.getCos();
        cot = new Cot(sin, cos);
    }

    @Test
    public void testCalculateInvalidParams() {
        assertEquals(Double.NaN, cot.cot(Double.NaN, 10), 1e-10);
        assertEquals(Double.NaN, cot.cot(Double.POSITIVE_INFINITY, 10), 1e-10);
        assertEquals(Double.NaN, cot.cot(Double.NEGATIVE_INFINITY, 10), 1e-10);
    }

    @Test
    public void testCalculateZero() {
        assertEquals(Double.NaN, cot.cot(0, 10), 1e-10);
        assertEquals(Double.NaN, cot.cot(2 * Math.PI, 10), 1e-10);
        assertEquals(Double.NaN, cot.cot(-2 * Math.PI, 10), 1e-10);
    }

    @Test
    public void testCalculatePi() {
        assertEquals(Double.NaN, cot.cot(Math.PI, 10), 1e-10);
        assertEquals(Double.NaN, cot.cot(-Math.PI, 10), 1e-10);
    }

    @Test
    public void testCalculatePiDividedByTwo() {
        assertEquals(0.0, cot.cot(Math.PI / 2, 10), 1e-10);
        assertEquals(0.0, cot.cot(-Math.PI / 2, 10), 1e-10);
    }

    @Test
    public void testCalculatePiDividedByFour() {
        assertEquals(1.0, cot.cot(Math.PI / 4, 10), 1e-10);
        assertEquals(-1.0, cot.cot(-Math.PI / 4, 10), 1e-10);
    }
}
