package shift.filter;

import java.util.ArrayList;
import java.util.List;

public class ArgsParser {

    private boolean append = false;
    private boolean shortStat = false;
    private boolean fullStat = false;
    private String outputPath = ".";
    private String prefix = "";
    private final List<String> inputFiles = new ArrayList<>();

    public ArgsParser(String[] args) {
        parse(args);
    }

    private void parse(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];

            switch (arg) {
                case "-a" -> append = true;
                case "-s" -> shortStat = true;
                case "-f" -> fullStat = true;

                case "-o" -> {
                    if (i + 1 < args.length) {
                        outputPath = args[++i];
                    } else {
                        System.out.println("Ошибка: после -o должен быть указан путь.");
                    }
                }

                case "-p" -> {
                    if (i + 1 < args.length) {
                        prefix = args[++i];
                    } else {
                        System.out.println("Ошибка: после -p должен быть указан префикс.");
                    }
                }

                default -> {
                    if (arg.startsWith("-")) {
                        System.out.println("Предупреждение: неизвестная опция " + arg);
                    } else {
                        inputFiles.add(arg);
                    }
                }
            }
        }
    }

    public boolean isAppend() {
        return append;
    }

    public boolean isShortStat() {
        return shortStat;
    }

    public boolean isFullStat() {
        return fullStat;
    }

    public String getOutputPath() {
        return outputPath;
    }

    public String getPrefix() {
        return prefix;
    }

    public List<String> getInputFiles() {
        return inputFiles;
    }
}
