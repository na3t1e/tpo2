package functions;

import functions.logarithmic.Ln;
import functions.logarithmic.Log;
import functions.trigonometric.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IntegrationTests {
    @Test
    public void testFunctionSystem() {
        Mocks mocks = new Mocks();
        Sin sin = new Sin();
        Sin sin_mocked = mocks.getSin();
        Cos cos_mocked = mocks.getCos();
        Cos cos = new Cos(sin);
        Tan tan_mocked = mocks.getTan();
        Tan tan = new Tan(sin, cos);
        Cot cot_mocked = mocks.getCot();
        Cot cot = new Cot(sin, cos);
        Csc csc_mocked = mocks.getCsc();
        Csc csc = new Csc(sin);
        Sec sec_mocked = mocks.getSec();
        Sec sec = new Sec(cos);
        Ln ln_mocked = mocks.getLn();
        Ln ln = new Ln();
        Log log2_mocked = mocks.getLog2();
        Log log2 = new Log(ln, 2);
        Log log3_mocked = mocks.getLog3();
        Log log3 = new Log(ln, 3);
        Log log10_mocked = mocks.getLog10();
        Log log10 = new Log(ln, 10);

        double angle = -Math.PI / 4;
        double value = 8.0;


        double log2_res = Math.log(8) / Math.log(2);
        double log3_res = Math.log(8) / Math.log(3);
        double log10_res = Math.log(8) / Math.log(10);
        double ln_res = Math.log(8);
        double part1 = (ln_res - log10_res) - log3_res;
        double part2 = Math.pow(log2_res, 3);

        double expected = ((part1 + part2) * ln_res) - Math.pow(ln_res, 2);

        FunctionSystem functionSystem1 = new FunctionSystem(sin, sec_mocked, csc_mocked, tan_mocked, cos_mocked, cot_mocked, ln_mocked, log3_mocked, log10_mocked, log2_mocked);
        assertEquals(-(Math.sqrt(2) * 1.0) * (Math.sqrt(2) / 2 * 1.0), functionSystem1.calculate(angle, 10), 1e-5, "Function System 1 is incorrect");
        FunctionSystem functionSystem2 = new FunctionSystem(sin_mocked, sec, csc_mocked, tan_mocked, cos_mocked, cot_mocked, ln_mocked, log3_mocked, log10_mocked, log2_mocked);
        assertEquals(-(Math.sqrt(2) * 1.0) * (Math.sqrt(2) / 2 * 1.0), functionSystem2.calculate(angle, 10), 1e-5, "Function System 2 is incorrect");
        FunctionSystem functionSystem3 = new FunctionSystem(sin_mocked, sec_mocked, csc, tan_mocked, cos_mocked, cot_mocked, ln_mocked, log3_mocked, log10_mocked, log2_mocked);
        assertEquals(-(Math.sqrt(2) * 1.0) * (Math.sqrt(2) / 2 * 1.0), functionSystem3.calculate(angle, 10), 1e-5, "Function System 3 is incorrect");
        FunctionSystem functionSystem4 = new FunctionSystem(sin_mocked, sec_mocked, csc_mocked, tan, cos_mocked, cot_mocked, ln_mocked, log3_mocked, log10_mocked, log2_mocked);
        assertEquals(-(Math.sqrt(2) * 1.0) * (Math.sqrt(2) / 2 * 1.0), functionSystem4.calculate(angle, 10), 1e-5, "Function System 4 is incorrect");
        FunctionSystem functionSystem5 = new FunctionSystem(sin_mocked, sec_mocked, csc_mocked, tan_mocked, cos, cot_mocked, ln_mocked, log3_mocked, log10_mocked, log2_mocked);
        assertEquals(-(Math.sqrt(2) * 1.0) * (Math.sqrt(2) / 2 * 1.0), functionSystem5.calculate(angle, 10), 1e-5, "Function System 5 is incorrect");
        FunctionSystem functionSystem6 = new FunctionSystem(sin_mocked, sec_mocked, csc_mocked, tan_mocked, cos_mocked, cot, ln_mocked, log3_mocked, log10_mocked, log2_mocked);
        assertEquals(-(Math.sqrt(2) * 1.0) * (Math.sqrt(2) / 2 * 1.0), functionSystem5.calculate(angle, 10), 1e-5, "Function System 6 is incorrect");

        FunctionSystem functionSystem7 = new  FunctionSystem(sin_mocked, sec_mocked, csc_mocked, tan_mocked, cos_mocked, cot_mocked, ln_mocked, log3, log10_mocked, log2_mocked);
        assertEquals(expected, functionSystem6.calculate(value, 100), 1e-5, "Function System 7 is incorrect");
        FunctionSystem functionSystem8 = new  FunctionSystem(sin_mocked, sec_mocked, csc_mocked, tan_mocked, cos_mocked, cot_mocked, ln_mocked, log3_mocked, log10, log2_mocked);
        assertEquals(expected, functionSystem7.calculate(value, 100), 1e-5, "Function System 8 is incorrect");
        FunctionSystem functionSystem9 = new  FunctionSystem(sin_mocked, sec_mocked, csc_mocked, tan_mocked, cos_mocked, cot_mocked, ln_mocked, log3_mocked, log10_mocked, log2);
        assertEquals(expected, functionSystem8.calculate(value, 100), 1e-5, "Function System 9 is incorrect");
    }


    @Test
    @DisplayName("Integration Test: Basic Trigonometric Functions")
    public void testBasicTrigonometricFunctions() {
        Sin sin = new Sin();
        Cos cos = new Cos(sin);
        Tan tan = new Tan(sin, cos);
        Cot cot = new Cot(sin, cos);
        Csc csc = new Csc(sin);
        Sec sec = new Sec(cos);

        double angle = Math.PI / 4; // 45 degrees
        assertEquals(Math.sqrt(2) / 2, sin.sin(angle, 10), 1e-5, "Sin value is incorrect");
        assertEquals(Math.sqrt(2) / 2, cos.cos(angle, 10), 1e-5, "Cos value is incorrect");
        assertEquals(1.0, tan.tan(angle, 10), 1e-5, "Tan value is incorrect");
        assertEquals(1.0, cot.cot(angle, 10), 1e-5, "Cot value is incorrect");
        assertEquals(Math.sqrt(2), csc.csc(angle, 10), 1e-5, "Csc value is incorrect");
        assertEquals(Math.sqrt(2), sec.sec(angle, 10), 1e-5, "Sec value is incorrect");

    }

    @Test
    @DisplayName("Integration Test: Basic Logarithmic Functions")
    public void testBasicLogarithmicFunctions() {
        Ln ln = new Ln();
        Log log2 = new Log(ln, 2);
        Log log3 = new Log(ln, 3);
        Log log10 = new Log(ln, 10);

        double value = 8.0;
        assertEquals(Math.log(8), ln.ln(value, 100), 1e-5, "Ln value is incorrect");
        assertEquals(Math.log(8) / Math.log(2), log2.log(value, 100), 1e-5, "Log base 2 value is incorrect");
        assertEquals(Math.log(8) / Math.log(3), log3.log(value, 100), 1e-5, "Log base 3 value is incorrect");
        assertEquals(Math.log(8) / Math.log(10), log10.log(value, 100), 1e-5, "Log base 10 value is incorrect");
    }

    @Test
    @DisplayName("Integration Test: CSV Exporter with Function System")
    public void testCSVExporterWithFunctionSystem() {
        Sin sin = new Sin();
        Cos cos = new Cos(sin);
        Sec sec = new Sec(cos);
        Tan tan = new Tan(sin, cos);
        Cot cot = new Cot(sin, cos);
        Csc csc = new Csc(sin);
        Ln ln = new Ln();
        Log log2 = new Log(ln, 2);
        Log log3 = new Log(ln, 3);
        Log log10 = new Log(ln, 10);

        FunctionSystem functionSystem = new FunctionSystem(sin, sec, csc, tan, cos, cot, ln, log3, log10, log2);

        double[] testValues = {-Math.PI, 1, Math.PI / 20};
        CSVExporter.exportToCSV(testValues[0], testValues[1], testValues[2], 10, "output.csv", functionSystem);

        assertTrue(new java.io.File("output.csv").exists(), "CSV file was not created");
    }

}
