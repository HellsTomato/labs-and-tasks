import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

// Исключение для деления на ноль
class CustomDivisionException extends Exception {                 // есть обрабатываемые и необрабатываемые исключения
    public CustomDivisionException(String message) {              //необрабатываемые исключения у них в коде, программа
        super(message);                                           // запуститься, но когда произойдёт ошибка она рванёт
    }                                                             // на том месте, если её не обработали try cath
}                                                                 //Обрабатываемые исключения у них в коде программа не
                                                                  // запустится, если нет перехвата try cach, если в этом
// Исключение для неверного возраста                              // методе не хочу писать try cath, то нужно прописать
class CustomAgeException extends Exception {                      // в объявление метода trows, и тот кто вызовет этот метод должен
    public CustomAgeException(String message) {                   // делать перехватка с помощью try cath это исключение.
        super(message);
    }                                                             //мы выбрасываем наше исключение, далее создаём его экземпляр
}                                                                 //с помощью конструктора в него передаём текстовку которую увидим
                                                                  // в терминале. Далее c помощью super обращаемся к конструктору наследуемого
// Исключение для отсутствующего файла                            // класса ексепшен, далее в конструктор наследуемого класса тровабл, там уже
class CustomFileNotFoundException extends FileNotFoundException { // он присваивается в детейлмеседж. значение из которого мы получаем когда
    public CustomFileNotFoundException(String message) {          // вызываем getmassage на экземпляре нашего исключения
        super(message);
    }
}

// Исключение для неправильного формата числа
class CustomNumberFormatException extends NumberFormatException {
    public CustomNumberFormatException(String message) {
        super(message);
    }
}

// Исключение для пустого стека
class CustomEmptyStackException extends Exception {
    public CustomEmptyStackException(String message) {
        super(message);
    }
}

// Исключение для ошибки ввода
class CustomInputMismatchException extends InputMismatchException {
    public CustomInputMismatchException(String message) {
        super(message);
    }
}

// Исключение для неверного формата email
class CustomEmailFormatException extends Exception {
    public CustomEmailFormatException(String message) {
        super(message);
    }
}

// Исключение для неподдерживаемой операции
class CustomUnsupportedOperationException extends UnsupportedOperationException {
    public CustomUnsupportedOperationException(String message) {
        super(message);
    }
}

public class ExceptionHandler {

    // Метод для деления чисел
    public static void divide(int a, int b) throws CustomDivisionException {
        if (b == 0) {
            throw new CustomDivisionException("Ошибка: деление на ноль!");
        }
        System.out.println("Результат деления: " + a / b);
    }

    // Метод для проверки возраста
    public static void checkAge(int age) throws CustomAgeException {
        if (age < 0 || age > 120) {
            throw new CustomAgeException("Недопустимый возраст: " + age);
        }
        System.out.println("Возраст корректен: " + age);
    }

    // Метод для чтения файла
    public static void readFile(String fileName) throws CustomFileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new CustomFileNotFoundException("Файл не найден: " + fileName);
        }
        System.out.println("Файл найден: " + fileName);
    }

    // Метод для преобразования строки в число
    public static void parseNumber(String str) {
        try {
            Integer.parseInt(str);
            System.out.println("Число корректное: " + str);
        } catch (NumberFormatException e) {
            throw new CustomNumberFormatException("Неверный формат числа: " + str);
        }
    }

    // Метод для работы со стеком
    public static void popFromStack(Stack<Integer> stack) throws CustomEmptyStackException {
        if (stack.isEmpty()) {
            throw new CustomEmptyStackException("Ошибка: стек пустой!");
        }
        System.out.println("Извлечено из стека: " + stack.pop());
    }

    // Метод для проверки ввода с клавиатуры
    public static void readInteger(Scanner scanner) {
        try {
            int number = scanner.nextInt();
            System.out.println("Число введено корректно: " + number);
        } catch (InputMismatchException e) {
            throw new CustomInputMismatchException("Ошибка: введено не число!");
        }
    }

    // Метод для проверки email формата
    public static void checkEmail(String email) throws CustomEmailFormatException {
        if (!email.contains("@") || !email.contains(".")) {
            throw new CustomEmailFormatException("Неверный формат email: " + email);
        }
        System.out.println("Email корректен: " + email);
    }

    // Метод для выполнения математической операции
    public static void performOperation(String operation, int a, int b) {
        switch (operation) {
            case "add":
                System.out.println("Сложение: " + (a + b));
                break;
            case "subtract":
                System.out.println("Вычитание: " + (a - b));
                break;
            case "multiply":
                System.out.println("Умножение: " + (a * b));
                break;
            case "divide":
                if (b == 0) {
                    throw new CustomUnsupportedOperationException("Ошибка: деление на ноль!");
                }
                System.out.println("Деление: " + (a / b));
                break;
            default:
                throw new CustomUnsupportedOperationException("Операция не поддерживается: " + operation);
        }
    }

    public static void main(String[] args) {
        // Примеры работы с каждым исключением

        try {
            divide(10, 0);
        } catch (CustomDivisionException e) {
            System.out.println(e.getMessage());
        }

        try {
            checkAge(130);
        } catch (CustomAgeException e) {
            System.out.println(e.getMessage());
        }

        try {
            readFile("non_existent_file.txt");
        } catch (CustomFileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            parseNumber("abc");
        } catch (CustomNumberFormatException e) {
            System.out.println(e.getMessage());
        }

        Stack<Integer> stack = new Stack<>();
        try {
            popFromStack(stack);
        } catch (CustomEmptyStackException e) {
            System.out.println(e.getMessage());
        }

        Scanner scanner = new Scanner(System.in);
        try {
            readInteger(scanner);
        } catch (CustomInputMismatchException e) {
            System.out.println(e.getMessage());
        }

        try {
            checkEmail("invalid-email");
        } catch (CustomEmailFormatException e) {
            System.out.println(e.getMessage());
        }

        try {
            performOperation("power", 2, 3);
        } catch (CustomUnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }
    }
}

