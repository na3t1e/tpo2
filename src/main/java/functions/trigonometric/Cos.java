package functions.trigonometric;

public class Cos {
    private final Sin sin;

    public Cos(Sin sin){
            this.sin = sin;
        }

    public double cos(double x, double terms) {
        if ((Double.isNaN(x) || Double.isInfinite(x) ||  terms < 0 || terms > 1e6))
            return Double.NaN;

        x = normalize(x + Math.PI / 2);
        return sin.sin(x, terms);
    }
    private double normalize(double x){
        return ((x % (2 * Math.PI)) + 2 * Math.PI) % (2 * Math.PI);
    }
}
