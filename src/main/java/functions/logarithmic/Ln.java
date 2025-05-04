package functions.logarithmic;



public class Ln {
    public double ln(double x, double terms) {
        if (x <= 0) return Double.NaN;
        if ((Double.isNaN(x) || Double.isNaN(terms) || Double.isInfinite(x) || Double.isInfinite(terms) || terms < 0 || terms > 1e6))
            return Double.NaN;
        double y = (x - 1) / (x + 1);
        double term = y, sum = 2 * y;
        int n = 1;
        for (int i = 0; i < terms; i++) {
            term *= (y * y) * (2 * n - 1) / (2 * n + 1);
            sum += 2 * term;
            n++;
        }
        return sum;
    }
}
