package functions.trigonometric;

public class Csc {
    private final Sin sin;

    public Csc(Sin sin) {
        this.sin = sin;
    }

    public double csc(double x, double terms) {
        if ((Double.isNaN(x) || Double.isInfinite(x) || Double.isInfinite(terms) || terms < 0 || terms > 1e6))
            return Double.NaN;

        double res = sin.sin(x, terms);
        if (Math.abs(res) < 1e-3)
            return Double.NaN;
        return 1 / res;
    }
}
