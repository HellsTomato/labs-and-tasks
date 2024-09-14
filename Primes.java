public class Primes {
    public static void main(String[] args) {
        // Перебираем числа от 2 до 100 включительно
        for (int t = 0; t < 100; t++) {
            // Если число i является простым, выводим его на экран
            if (isPrime(t)) {
                System.out.println(t);
            }
        }
    }
    public static boolean isPrime(int n) {
        // Так как предполагается, что n всегда
        // будет больше 2, можно начинать проверку с 2
        if (n < 2) {
            return false;
        }
        // Проверяем, существует ли какое-либо
        // число от 2 до n-1, которое делит n без остатка
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        // Если не нашли ни одного делителя, то число n - простое
        return true;
    }
}