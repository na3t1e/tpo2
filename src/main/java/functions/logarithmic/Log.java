package functions.logarithmic;

public class Log {
    private final Ln ln;
    private final int base;

    public Log(Ln ln, int base) {
        this.ln = ln;
        this.base = base;
    }

    public double log(double x, double terms) {
        if ((Double.isNaN(x) || Double.isNaN(terms) || Double.isInfinite(x) || Double.isInfinite(terms) || terms < 0 || terms > 1e6))
            return Double.NaN;
        double lnx_res = ln.ln(x, terms);
        double lnb_res = ln.ln(base, terms);
        if (lnb_res == 0) {
            return Double.NaN;
        }
        if (Double.isNaN(lnx_res) || Double.isNaN(lnb_res)) {
            return Double.NaN;
        }
        return lnx_res / lnb_res;
    }
}
