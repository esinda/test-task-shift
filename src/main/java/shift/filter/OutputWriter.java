package shift.filter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.util.List;

public class OutputWriter {

    private final String outputPath;
    private final String prefix;
    private final boolean append;
    public OutputWriter(String outputPath, String prefix, boolean append) {
        this.outputPath = (outputPath == null || outputPath.isEmpty()) ? "." : outputPath;
        this.prefix = (prefix == null) ? "" : prefix;
        this.append = append;
    }

    public void writeIntegers(List<Long> integers) {
        writeListToFile(integers, "integers.txt");
    }

    public void writeFloats(List<Double> floats) {
        writeListToFile(floats, "floats.txt");
    }

    public void writeStrings(List<String> strings) {
        writeListToFile(strings, "strings.txt");
    }

    private <T> void writeListToFile(List<T> list, String defaultFileName) {
        if (list == null || list.isEmpty()) return;

        String fullPath = outputPath + File.separator + prefix + defaultFileName;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fullPath, append))) {
            for (T item : list) {
                writer.write(item.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл " + fullPath + ": " + e.getMessage());
        }
    }
}
