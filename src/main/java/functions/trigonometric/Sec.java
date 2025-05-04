package functions.trigonometric;

public class Sec {
    private final Cos cos;

    public Sec(Cos cos) {
        this.cos = cos;
    }

    public double sec(double x, double terms) {
        if ((Double.isNaN(x) || Double.isInfinite(x) || terms < 0 || terms > 1e6))
            return Double.NaN;

        double res = cos.cos(x, terms);
        if (Math.abs(res) < 1e-3)
            return Double.NaN;
        return 1 / res;
    }
}
