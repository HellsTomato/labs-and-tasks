import java.util.HashMap;
import java.util.Map;

// Класс для работы с хэш-таблицей
public class StudentHashTable {
    // Используем HashMap для хранения данных о студентах
    private Map<String, Student> studentTable; // это интерфейс, который определяет структуру для хранения пар "ключ-значение

    public StudentHashTable() {
        studentTable = new HashMap<>();  // это класс, который реализует интерфейс Map
                                         // Нельзя создавать экземпляр по интерфейсу, так же как и абстрактный класс.
                                         // HashMap - реализует интерфейс Map, и поэтому мы можем присваивать ссылку на
                                         // экземпляр переменной типа Map
    }
    // Метод для добавления студента
    public void addStudent(String studentId, Student student) {
        studentTable.put(studentId, student);
        System.out.println("С номером " +  studentId + " добавлен студент: " + student);
    }

    // Метод для поиска студента по номеру зачетной книжки
    public Student getStudent(String studentId) {
        return studentTable.get(studentId);
    }

    // Метод для удаления студента по номеру зачетной книжки
    public void removeStudent(String studentId) {
        studentTable.remove(studentId);
    }

    // Метод для проверки наличия студента в таблице
    public boolean containsStudent(String studentId) {
        return studentTable.containsKey(studentId);
    }
}