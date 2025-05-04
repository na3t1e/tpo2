package functions;

import functions.logarithmic.Ln;
import functions.logarithmic.Log;
import functions.trigonometric.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class FunctionSystemTest {
    private final double DELTA = 1e-4;
    private Sin sin;
    private Sec sec;
    private Csc csc;
    private Tan tan;
    private Cos cos;
    private Cot cot;
    private Ln ln;
    private Log log3;
    private Log log10;
    private Log log2;
    private static Mocks mocks;
    private FunctionSystem functionSystem;

    @BeforeAll
    public static void setUp() {
        mocks = new Mocks();
    }

    @BeforeEach
    public void init() {
        sin = mocks.getSin();
        sec = mocks.getSec();
        csc = mocks.getCsc();
        tan = mocks.getTan();
        cos = mocks.getCos();
        cot = mocks.getCot();
        ln = mocks.getLn();
        log3 = mocks.getLog3();
        log10 = mocks.getLog10();
        log2 = mocks.getLog2();
        functionSystem = new FunctionSystem(sin, sec, csc, tan, cos, cot, ln, log3, log10, log2);
    }



    @Test
    public void testCalculateInvalidParams() {
        assertEquals(Double.NaN, functionSystem.calculate(Double.NaN, 10), 1e-10);
        assertEquals(Double.NaN, functionSystem.calculate(Double.POSITIVE_INFINITY, 10), 1e-10);
        assertEquals(Double.NaN, functionSystem.calculate(Double.NEGATIVE_INFINITY, 10), 1e-10);
    }

    @Test
    public void testCalculateZero() {
        assertEquals(Double.NaN, functionSystem.calculate(0, 10), 1e-10);
    }

    @Test
    public void testMoreThanZero() {
        // Пример для x > 0
        double result1 = functionSystem.calculate(0.41465, 10); // Например, 0.41465 должно быть округлено в PI / 4
        assertEquals(Math.PI / 4, result1, DELTA);

        double result2 = functionSystem.calculate(3.03169, 10); // Пример для x > 0, который должен быть близким к PI
        assertEquals(Math.PI, result2, DELTA);

        double result3 = functionSystem.calculate(2.87829, 10); // Пример для x > 0, который должен быть близким к 3PI / 4
        assertEquals(3 * Math.PI / 4, result3, DELTA);
    }

    @Test
    public void testLessThanZero() {
        // Пример для x < 0
        double result1 = functionSystem.calculate(-0.30817, 10); // Пример для x < 0
        assertEquals(-Math.PI, result1, DELTA);

        double result2 = functionSystem.calculate(-0.40137, 10); // Пример для x < 0
        assertEquals(-3 * Math.PI / 4, result2, DELTA);
    }

}



