package shift.filter;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Утилита запущена.");

        ArgsParser parser = new ArgsParser(args);

        List<String> inputFiles = parser.getInputFiles();
        if (inputFiles.isEmpty()) {
            System.out.println("Не указаны входные файлы. Завершение работы.");
            return;
        }

        DataClassifier classifier = new DataClassifier();
        FileProcessor fileProcessor = new FileProcessor();
        fileProcessor.processFiles(inputFiles, classifier::classify);

        OutputWriter writer = new OutputWriter(parser.getOutputPath(), parser.getPrefix(), parser.isAppend());
        writer.writeIntegers(classifier.getIntegers());
        writer.writeFloats(classifier.getFloats());
        writer.writeStrings(classifier.getStrings());

        if (parser.isShortStat()) {
            System.out.println("\n=== Краткая статистика ===");
            classifier.printSummary();
        }

        if (parser.isFullStat()) {
            System.out.println("\n=== Полная статистика ===");
            Statistics.printFullStatistics(
                    classifier.getIntegers(),
                    classifier.getFloats(),
                    classifier.getStrings()
            );
        }

        if (!parser.isShortStat() && !parser.isFullStat()) {
            System.out.println("\n=== Краткая статистика (по умолчанию) ===");
            classifier.printSummary();
        }
    }
}
