public class arithmeticMean {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int sum = 0;
        double average = 0.0;

        try {
            for (int i = 0; i <= arr.length; i++) { // /Обработка массива
                sum += arr[i];
            }
            average = sum / arr.length;
            System.out.println("Среднее арифметическое: " + average); //Вывод массива
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Ошибка: выход за пределы массива!");
        }
        catch (ArithmeticException e) {
            System.out.println("Ошибка: деление на ноль!");
        }
        finally {
            System.out.println("Программа завершена.");
        }
    }
}