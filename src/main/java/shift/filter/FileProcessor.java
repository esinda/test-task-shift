package shift.filter;

import java.util.List;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class FileProcessor {

    public void processFiles(List<String> files, LineHandler handler) {
        for (String file : files) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

                String line;
                while ((line = reader.readLine()) != null) {
                    handler.handle(line);
                }

            } catch (IOException e) {
                System.out.println("Ошибка чтения файла: " + file +
                        ". Причина: " + e.getMessage());
            }
        }
    }
}
