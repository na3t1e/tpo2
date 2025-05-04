package functions.trigonometric;

public class Cot {
    private final Sin sin;
    private final Cos cos;

    public Cot(Sin sin, Cos cos) {
        this.sin = sin;
        this.cos = cos;
    }

    public double cot(double x, double terms) {
        if ((Double.isNaN(x) || Double.isInfinite(x) || terms < 0 || terms > 1e6))
            return Double.NaN;
        double sin_res = sin.sin(x, terms);
        double cos_res = cos.cos(x, terms);
        if (Math.abs(sin_res) < 1e-3)
            return Double.NaN;
        return cos_res / sin_res;
    }
}
