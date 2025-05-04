package functions;

import java.io.FileWriter;
import java.io.IOException;

public class CSVExporter {
    public static void exportToCSV(double start, double end, double step, double terms, String filename, FunctionSystem func) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.append("X, Result\n");
            for (double x = start; x <= end; x += step) {
                double result = func.calculate(x, terms);
                writer.append(String.valueOf(x)).append(",").append(String.valueOf(result)).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}