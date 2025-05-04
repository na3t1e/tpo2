package functions.trigonometric;

public class Sin {
    public double sin(double x, double terms) {
        if ((Double.isNaN(x) || Double.isInfinite(x) || terms < 0 || terms > 1e6))
            return Double.NaN;
        x = normalize(x);
        double term = x, res = x;
        int n = 1;
        for (int i = 0; i < terms; i++) {
            term *= -x * x / ((2 * n) * (2 * n + 1));
            res += term;
            n++;
        }
        return res;
    }

    private double normalize(double x){
        return ((x % (2 * Math.PI)) + 2 * Math.PI) % (2 * Math.PI);
    }
}

