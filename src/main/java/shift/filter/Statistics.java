package shift.filter;

import java.util.Collections;
import java.util.List;

public class Statistics {

    public static void printFullStatistics(List<Long> integers, List<Double> floats, List<String> strings) {

        if (!integers.isEmpty()) {
            long min = Collections.min(integers);
            long max = Collections.max(integers);
            long sum = integers.stream().mapToLong(Long::longValue).sum();
            double avg = sum / (double) integers.size();

            System.out.println("Integers:");
            System.out.println("  Count: " + integers.size());
            System.out.println("  Min: " + min);
            System.out.println("  Max: " + max);
            System.out.println("  Sum: " + sum);
            System.out.println("  Avg: " + avg);
        }

        if (!floats.isEmpty()) {
            double min = Collections.min(floats);
            double max = Collections.max(floats);
            double sum = floats.stream().mapToDouble(Double::doubleValue).sum();
            double avg = sum / floats.size();

            System.out.println("Floats:");
            System.out.println("  Count: " + floats.size());
            System.out.println("  Min: " + min);
            System.out.println("  Max: " + max);
            System.out.println("  Sum: " + sum);
            System.out.println("  Avg: " + avg);
        }

        if (!strings.isEmpty()) {
            int minLen = strings.stream().mapToInt(String::length).min().orElse(0);
            int maxLen = strings.stream().mapToInt(String::length).max().orElse(0);

            System.out.println("Strings:");
            System.out.println("  Count: " + strings.size());
            System.out.println("  Min length: " + minLen);
            System.out.println("  Max length: " + maxLen);
        }
    }
}
