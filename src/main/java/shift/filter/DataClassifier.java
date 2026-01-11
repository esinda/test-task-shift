package shift.filter;

import java.util.List;
import java.util.ArrayList;

public class DataClassifier {

    private final List<Long> integers = new ArrayList<>();
    private final List<Double> floats = new ArrayList<>();
    private final List<String> strings = new ArrayList<>();

    public void classify(String line) {
        if (line == null) return;

        line = line.trim();
        if (line.isEmpty()) return;

        try {
            long l = Long.parseLong(line);
            integers.add(l);
            return;
        } catch (NumberFormatException ignored) {
        }

        try {
            double d = Double.parseDouble(line);
            floats.add(d);
            return;
        } catch (NumberFormatException ignored) {
        }

        strings.add(line);
    }

    public List<Long> getIntegers() {
        return integers;
    }

    public List<Double> getFloats() {
        return floats;
    }

    public List<String> getStrings() {
        return strings;
    }

    public void printSummary() {
        System.out.println("Статистика:");
        System.out.println("Integers: " + integers.size());
        System.out.println("Floats: " + floats.size());
        System.out.println("Strings: " + strings.size());
    }
}
