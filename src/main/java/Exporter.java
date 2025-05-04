import functions.FunctionSystem;

import java.io.FileWriter;
import java.io.IOException;

public class Exporter {
    public static void exportToCSV(double start, double end, double step, int terms, String filename, FunctionSystem func) {
        try (FileWriter writer = new FileWriter(filename + ".csv")) {
            writer.write("X,   Результаты модуля (X)\n");
            for (double x = start; x <= end; x += step) {
                double result = func.calculate(x, terms);
                writer.write(x + ",      " + result + "\n");
            }
            System.out.println("Результаты записаны в файл results.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
