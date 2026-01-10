package shift.filter;

public class Main {

    public static void main(String[] args) {
        System.out.println("Утилита запущена.");

        ArgsParser parser = new ArgsParser(args);

        System.out.println("Append mode: " + parser.isAppend());
        System.out.println("Output path: " + parser.getOutputPath());
        System.out.println("Prefix: " + parser.getPrefix());

        if (parser.isFullStat()) {
            System.out.println("Statistics: FULL");
        } else if (parser.isShortStat()) {
            System.out.println("Statistics: SHORT");
        } else {
            System.out.println("Statistics: NONE");
        }

        System.out.println("Input files:");
        for (String file : parser.getInputFiles()) {
            System.out.println(" - " + file);
        }

        System.out.println("Обработка данных пока не реализована.");
    }
}
