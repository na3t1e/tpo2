package functions.trigonometric;

public class Tan {
    private Sin sin;
    private Cos cos;

    public Tan(Sin sin, Cos cos) {
        this.sin = sin;
        this.cos = cos;
    }

    public double tan(double x, double terms) {
        if ((Double.isNaN(x)  || Double.isInfinite(x)  || terms < 0 || terms > 1e6))
            return Double.NaN;

        double sin_res = sin.sin(x, terms);
        double cos_res = cos.cos(x, terms);
        if (Math.abs(cos_res) < 1e-3)
            return Double.NaN;
        return sin_res / cos_res;
    }
}
