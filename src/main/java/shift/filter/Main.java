package shift.filter;

public class Main {

    public static void main(String[] args) {
        System.out.println("Утилита запущена.");

        ArgsParser parser = new ArgsParser(args);

        if (parser.getInputFiles().isEmpty()) {
            System.out.println("Не указаны входные файлы. Завершение работы.");
            return;
        }

        FileProcessor fileProcessor = new FileProcessor();

        fileProcessor.processFiles(parser.getInputFiles(),
                line -> System.out.println("Прочитано: " + line));

        System.out.println("Чтение файлов завершено.");
    }
}
