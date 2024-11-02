import java.io.*;
public class FileProcessing {
    public static void main(String[] args) {
        File inputFile = new File("input.txt");
        File outputFile = new File("output.txt");

        // BufferedReader — это класс, который используется для более эффективного
        // чтения текстовых файлов построчно или символами, обеспечивая буферизацию чтения.
        // new FileReader(inputFile) — это объект, который открывает файл для чтения. Поскольку
        // это низкоуровневая операция, используется буферизация с помощью BufferedReader, чтобы улучшить производительность чтения.
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            // Конструкция try-with-resources автоматически закрывает все ресурсы, которые были открыты внутри круглых скобок try,
            // когда программа выходит из блока try — будь то успешное выполнение или в случае возникновения исключения.

            // Чтение и запись содержимого файла
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            System.out.println("Файл успешно скопирован.");
        } catch (FileNotFoundException e) {
            // Обработка ошибок открытия файлов
            System.out.println("Ошибка: файл не найден!");
        } catch (IOException e) {
            // Обработка ошибок чтения или записи файла
            System.out.println("Ошибка при чтении или записи файла!");
        }
    }
}
