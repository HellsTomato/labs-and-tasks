import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TopWords {
    public static void main(String[] args) {
        // Указал путь к текстовому файлу
        String filePath = "C:\\Users\\Smart\\IdeaProjects\\untitled\\lab6\\src\\text.txt";

        // Map для хранения слов и их количества
        Map<String, Integer> wordCount = new HashMap<>();

        // Читаем файл и подсчитываем количество слов
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            // Работает пока в файле есть слова
            while (scanner.hasNext()) {
                // читаем след слово из файла, ниж рег, замена части строки, найти любой символ...
                String word = scanner.next().toLowerCase().replaceAll("[^a-zа-я0-9]", "");
                // проверка, что слово не пустое
                if (!word.isEmpty()) {
                    // ещё одна проверка, чтобы найти слово в Map - +1(скок кол-во), либо его нет - 0.
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
            return;
        }

        // получаем все пары слов и их количества из Map и преобразуем их в список
        List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordCount.entrySet());
        // сортируем список в порядке убывания количества повторений(сравниваем кол-во слов)
        // это лямбда выражение,2 элемента для сравнения, 2 и 1 - убывание, 1 и 2 - возрастание
        sortedWords.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        // Выводим топ-10 самых часто встречающихся слов
        System.out.println("Топ-10 самых часто встречающихся слов:");
        // если меньше 10 выводим как есть(1-9), если больше, то ток 10
        for (int i = 0; i < Math.min(10, sortedWords.size()); i++) {
            // берём поочерёдно пару из отсортированного списка
            Map.Entry<String, Integer> entry = sortedWords.get(i);
            System.out.println((i + 1) + ". " + entry.getKey() + ": " + entry.getValue() + " раз(а)");
        }
    }
}
