public class Main1 {
    public static void main(String[] args) {
        // Создаем экземпляр StudentHashTable
        StudentHashTable studentHashTable = new StudentHashTable();

        // Создаем студентов
        Student student1 = new Student("John", "Doe", 20, 3.5);
        Student student2 = new Student("Jane", "Smith", 22, 3.9);
        Student student3 = new Student("Alice", "Johnson", 19, 3.8);

        // Добавляем студентов в хэш-таблицу
        studentHashTable.addStudent("S12345", student1);
        studentHashTable.addStudent("S23456", student2);
        studentHashTable.addStudent("S34567", student3);

        // Поиск студента по номеру зачетной книжки
        String searchId = "S12345";
        Student foundStudent = studentHashTable.getStudent(searchId);
        if (foundStudent != null) {
            System.out.println("Найден студент: " + foundStudent);
        } else {
            System.out.println("Студент с номером " + searchId + " не найден.");
        }

        // Удаление студента
        String removeId = "S23456";
        studentHashTable.removeStudent(removeId);
        System.out.println("Студент с номером " + removeId + " удален.");

        // Проверка наличия студента
        if (!studentHashTable.containsStudent(removeId)) {
            System.out.println("Студент с номером " + removeId + " не найден.");
        }
    }
}
