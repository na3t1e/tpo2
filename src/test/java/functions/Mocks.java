package functions;

import functions.logarithmic.Ln;
import functions.logarithmic.Log;
import functions.trigonometric.*;
import lombok.Data;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@Data
public class Mocks {
    @Mock
    private Sin sin;

    @Mock
    private Cos cos;

    @Mock
    private Tan tan;

    @Mock
    private Cot cot;

    @Mock
    private Csc csc;

    @Mock
    private Sec sec;

    @Mock
    private Ln ln;

    @Mock
    private Log log2;

    @Mock
    private Log log3;

    @Mock
    private Log log10;

    @Mock
    private FunctionSystem functionSystem;

    public Mocks() {
        MockitoAnnotations.openMocks(this);
        setupMocks();
    }

    private void setupMocks() {
        when(sin.sin(anyDouble(), anyInt())).thenAnswer(invocation -> {
            Object[] args = invocation.getArguments();
            return mockSinValue((double) args[0]);
        });

        when(cos.cos(anyDouble(), anyInt())).thenAnswer(invocation -> {
            Object[] args = invocation.getArguments();
            return mockCosValue((double) args[0]);
        });

        when(tan.tan(anyDouble(), anyInt())).thenAnswer(invocation -> {
            Object[] args = invocation.getArguments();
            return mockTanValue((double) args[0]);
        });

        when(cot.cot(anyDouble(), anyInt())).thenAnswer(invocation -> {
            Object[] args = invocation.getArguments();
            return mockCotValue((double) args[0]);
        });

        when(csc.csc(anyDouble(), anyInt())).thenAnswer(invocation -> {
            Object[] args = invocation.getArguments();
            return mockCscValue((double) args[0]);
        });

        when(sec.sec(anyDouble(), anyInt())).thenAnswer(invocation -> {
            Object[] args = invocation.getArguments();
            return mockSecValue((double) args[0]);
        });

        when(ln.ln(anyDouble(), anyInt())).thenAnswer(invocation -> {
            Object[] args = invocation.getArguments();
            return mockLnValue((double) args[0]);
        });

        when(log2.log(anyDouble(), anyInt())).thenAnswer(invocation -> {
            Object[] args = invocation.getArguments();
            return mockLog2Value((double) args[0]);
        });

        when(log3.log(anyDouble(), anyInt())).thenAnswer(invocation -> {
            Object[] args = invocation.getArguments();
            return mockLog3Value((double) args[0]);
        });

        when(log10.log(anyDouble(), anyInt())).thenAnswer(invocation -> {
            Object[] args = invocation.getArguments();
            return mockLog10Value((double) args[0]);
        });

        when(functionSystem.calculate(anyDouble(), anyInt())).thenAnswer(invocation -> {
            Object[] args = invocation.getArguments();
            return mockFunctionSystemValue((double) args[0]);
        });
    }

    private static double mockSinValue(double x) {
        if (x == 0)
            return 0.0;
        if (x == Math.PI / 4)
            return Math.sqrt(2) / 2;
        if (x == Math.PI / 2)
            return 1.0;
        if (x == Math.PI)
            return 0.0;
        if (x == 3 * Math.PI / 2)
            return -1.0;
        if (x == 3 * Math.PI / 4)
            return Math.sqrt(2) / 2;
        if (x == 2 * Math.PI)
            return 0.0;
        if (x == -2 * Math.PI)
            return 0.0;
        if (x == -3 * Math.PI / 4)
            return -Math.sqrt(2) / 2;
        if (x == -Math.PI / 2)
            return -1.0;
        if (x == -Math.PI)
            return 0.0;
        if (x == -Math.PI / 2)
            return -1.0;
        if (x == -Math.PI / 4)
            return -Math.sqrt(2) / 2;
        return Math.sin(x);
    }

    private static double mockCosValue(double x) {
        if (x == 0.0)
            return 1.0;
        if (x == Math.PI / 4)
            return Math.sqrt(2) / 2;
        if (x == Math.PI / 2)
            return 0.0;
        if (x == Math.PI)
            return -1.0;
        if (x == 3 * Math.PI / 2)
            return 0.0;
        if (x == 3 * Math.PI / 4)
            return -Math.sqrt(2) / 2;
        if (x == 2 * Math.PI)
            return 1.0;
        if (x == -2 * Math.PI)
            return 1.0;
        if (x == -3 * Math.PI / 4)
            return -Math.sqrt(2) / 2;
        if (x == -3 * Math.PI / 2)
            return 0.0;
        if (x == -Math.PI)
            return -1.0;
        if (x == -Math.PI / 2)
            return 0.0;
        if (x == -Math.PI / 4)
            return Math.sqrt(2) / 2;
        return Math.cos(x);
    }

    private static double mockTanValue(double x) {
        if (x == 0)
            return 0.0;
        if (x == Math.PI / 4)
            return 1.0;
        if (x == Math.PI / 2)
            return Double.NaN;
        if (x == Math.PI)
            return 0.0;
        if (x == -Math.PI)
            return 0.0;
        if (x == -Math.PI / 2)
            return Double.NaN;
        if (x == -Math.PI / 4)
            return -1.0;
        return Math.tan(x);
    }

    private static double mockCotValue(double x) {
        if (x == 0)
            return Double.NaN;
        if (x == Math.PI / 4)
            return 1.0;
        if (x == Math.PI / 2)
            return 0.0;
        if (x == Math.PI)
            return Double.NaN;
        if (x == -Math.PI)
            return Double.NaN;
        if (x == -Math.PI / 2)
            return 0.0;
        if (x == -Math.PI / 4)
            return -1.0;
        return 1 / Math.tan(x);
    }

    private static double mockCscValue(double x) {
        if (x == 0)
            return Double.NaN;
        if (x == Math.PI / 4)
            return Math.sqrt(2);
        if (x == Math.PI / 2)
            return Double.NaN;
        if (x == Math.PI)
            return Double.NaN;
        if (x == -Math.PI)
            return Double.NaN;
        if (x == -Math.PI / 2)
            return Double.NaN;
        if (x == -Math.PI / 4)
            return -Math.sqrt(2);
        return 1 / Math.sin(x);
    }

    private static double mockSecValue(double x) {
        if (x == 0)
            return 1.0;
        if (x == Math.PI / 4)
            return Math.sqrt(2);
        if (x == Math.PI / 2)
            return Double.NaN;  // sec(π/2) не определен, так как cos(π/2) = 0
        if (x == Math.PI)
            return -1.0;
        if (x == 3 * Math.PI / 2)
            return Double.NaN;  // sec(3π/2) не определен, так как cos(3π/2) = 0
        if (x == 3 * Math.PI / 4)
            return -Math.sqrt(2);
        if (x == 2 * Math.PI)
            return 1.0;
        if (x == -2 * Math.PI)
            return 1.0;
        if (x == -3 * Math.PI / 4)
            return Math.sqrt(2);
        if (x == -Math.PI / 2)
            return Double.NaN;  // sec(-π/2) не определен, так как cos(-π/2) = 0
        if (x == -Math.PI)
            return -1.0;
        if (x == -Math.PI / 4)
            return -Math.sqrt(2);
        return 1 / Math.cos(x);  // Для остальных значений
    }

    private static double mockLnValue(double x) {
        if (x < 0)
            return Double.NaN;
        if (x == 0)
            return Double.NaN;
        if (x == 0.5)
            return -0.6931471805599453;
        if (x == 1)
            return 0.0;
        if (x == Math.E)
            return 1.0;
        if (x == Math.E * Math.E)
            return 2.0;
        if (x == Math.E * Math.E * Math.E)
            return 3.0;
        if (x == 10)
            return 2.302585092994046;
        if (x == 2)
            return 0.6931471805599453;
        if (x == 5)
            return 1.6094379124341003;
        return Math.log(x);
    }

    private static double mockLog2Value(double x) {
        if (x < 0)
            return Double.NaN;
        if (x == 0)
            return Double.NaN;
        if (x == 0.5)
            return -1.0;
        if (x == 1)
            return 0.0;
        if (x == 2)
            return 1.0;
        if (x == 4)
            return 2.0;
        if (x == 8)
            return 3.0;
        return Math.log(x) / Math.log(2);
    }

    private static double mockLog3Value(double x) {
        if (x < 0)
            return Double.NaN;
        if (x == 0)
            return Double.NaN;
        if (x == 0.5)
            return Math.log(0.5) / Math.log(3); // log3(0.5)
        if (x == 1)
            return 0.0; // log3(1) = 0
        if (x == 2)
            return Math.log(2) / Math.log(3); // log3(2)
        if (x == 3)
            return 1.0; // log3(3) = 1
        if (x == 9)
            return 2.0; // log3(9) = 2
        if (x == 27)
            return 3.0; // log3(27) = 3
        return Math.log(x) / Math.log(3); // Для всех других значений
    }

    private static double mockLog10Value(double x) {
        if (x < 0)
            return Double.NaN;
        if (x == 0)
            return Double.NaN;
        if (x == 0.5)
            return -0.3010299956639812;
        if (x == 1)
            return 0.0;
        if (x == 10)
            return 1.0;
        if (x == 100)
            return 2.0;
        if (x == 1000)
            return 3.0;
        return Math.log10(x);
    }

    private static double mockTrigFunction(double x) {
        double csc_res = mockCscValue(x);
        double tan_res = mockTanValue(x);
        double cos_res = mockCosValue(x);
        double cot_res = mockCotValue(x);
        double sin_res = mockSinValue(x);
        double sec_res = mockSecValue(x);

        double part1 = Math.pow(((csc_res / sin_res) - csc_res), 2);
        double part2 = (cot_res - cos_res) * sin_res;
        double part3 = (((csc_res - sin_res) + cos_res) / sec_res) - Math.pow(tan_res, 3);
        double part4 = tan_res * (sin_res + cos_res);
        double part5 = (sin_res / cot_res) + (Math.pow(tan_res, 2) - csc_res);
        return (((part1 * part2) * part3) + part4) * part5;
    }

    private static double mockLogFunction(double x) {
        double log3_res = mockLog3Value(x);
        double log10_res = mockLog10Value(x);
        double log2_res = mockLog2Value(x);
        double ln_res = mockLnValue(x);

        double part1 = (ln_res - log10_res) - log3_res;
        double part2 = Math.pow(log2_res, 3);

        return ((part1 + part2) * ln_res) - Math.pow(ln_res, 2);
    }

    private static double mockFunctionSystemValue(double x) {
        if (x <= 0)
            return mockTrigFunction(x);
        return mockLogFunction(x);
    }
}
