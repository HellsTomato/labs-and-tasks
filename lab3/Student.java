// Класс для хранения информации о студенте
public class Student {
    private String firstName;
    private String lastName;
    private int age;
    private double gpa;

    public Student(String firstName, String lastName, int age, double gpa) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gpa = gpa;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {                      // toString() в Java — это метод, который возвращает строковое представление объекта.
        return "Student{" +                         // возвращает строковое представление объекта.
                "firstName='" + firstName + '\'' +  // toString - Переопределение этого метода позволяет предоставить более информативное
                ", lastName='" + lastName + '\'' +  // и понятное строковое представление объекта. Если метод toString() не переопределён,
                ", age=" + age +                    // стандартная реализация возвращает строку, состоящую из имени класса и хэш-кода объекта.
                ", gpa=" + gpa +
                '}';
    }
}

