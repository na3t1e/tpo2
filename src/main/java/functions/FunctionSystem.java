package functions;

import functions.logarithmic.Ln;
import functions.logarithmic.Log;
import functions.trigonometric.*;

public class FunctionSystem {
    private Sin sin;
    private Cos cos;
    private Tan tan;
    private Cot cot;
    private Sec sec;
    private Csc csc;


    private final Ln ln;
    private final Log log2;
    private final Log log3;
    private final Log log10;

    public FunctionSystem(Sin sin, Sec sec, Csc csc, Tan tan, Cos cos, Cot cot, Ln ln, Log log3, Log log10, Log log2) {
        this.sin = sin;
        this.sec = sec;
        this.csc = csc;
        this.tan = tan;
        this.cos = cos;
        this.cot = cot;
        this.ln = ln;
        this.log3 = log3;
        this.log10 = log10;
        this.log2 = log2;
    }

    public double calculate(double x, double terms) {
        if ((Double.isNaN(x) || Double.isNaN(terms) || Double.isInfinite(x) || Double.isInfinite(terms) || terms < 0 || terms > 1e6))
            return Double.NaN;
        if (x <= 0) {
            try {
                double sin_res = sin.sin(x, terms);
                double cos_res = cos.cos(x, terms);
                double tan_res = tan.tan(x, terms);
                double cot_res = cot.cot(x, terms);
                double sec_res = sec.sec(x, terms);
                double csc_res = csc.csc(x, terms);

                double part1 = Math.pow(((csc_res / sin_res) - csc_res), 2);
                double part2 = (cot_res - cos_res) * sin_res;
                double part3 = (((csc_res - sin_res) + cos_res) / sec_res) - Math.pow(tan_res, 3);
                double part4 = tan_res * (sin_res + cos_res);
                double part5 = (sin_res / cot_res) + (Math.pow(tan_res, 2) - csc_res);

                return (((part1 * part2) * part3) + part4) * part5;

            } catch (Exception e) {
                return Double.NaN;
            }
        } else {
            try {
                double ln_res = ln.ln(x, terms);
                double log2_res = log2.log(x, terms);
                double log3_res = log3.log(x, terms);
                double log10_res = log10.log(x, terms);

                double part1 = (ln_res - log10_res) - log3_res;
                double part2 = Math.pow(log2_res, 3);

                return ((part1 + part2) * ln_res) - Math.pow(ln_res, 2);
            } catch (Exception e) {
                return Double.NaN;
            }
        }
    }
}
