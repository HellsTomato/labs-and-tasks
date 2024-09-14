public class tasks1 {
    // №1
    static double gallonsToLiters(int gallons) {
        double liters = gallons * 3.785411784;
        return liters;
    }
    // №2
    static int fitCalc(int minute, int intensive) {
        int result = 0;
        switch (intensive) {
            // низкая
            case 1:
                result = minute * 1;
                return result;
            // средняя
            case 2:
                result = minute * 2;
                return result;
            // высокая
            case 3:
                result = minute * 3;
                return result;
            default:
                System.err.println("Ошибка");
                return 0;
        }
    }
    // №3
    static int containers(int boxNumber, int bagsNumber, int barrelsNumber) {
        int box = 20;
        int bags = 50;
        int barrels = 100;

        int result = (boxNumber * box) + (bags * bagsNumber) + (barrels * barrelsNumber);

        return result;
    }
    // №4
    static String triagleType(int x, int y, int z) {

        if (x + y <= z || y + z <= x || x + z <= y) {
            return "The triangle does not exist";
        } else if (x == y && y == z) {
            return "equilateral";
        } else if (x == y || x == z || y == z) {
            return "isosceles";
        } else if (x != y && x != z || y != z) {
            return "different-sided";
        }
        return "undefined";
    }
    // №5
    static int ternaryEvaluation(int a, int b) {
        return (a > b) ? a : b;
    }
    // №6
    static int howManyItems(int length, double width, double height) {
        int result = (int) (length / (width * height * 2));
        return result;
    }
    // №7
    static int factorial(int number) {
        int result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }
    // №8
    static int gcd(int firstNumber, int secondNumber) {
        int result = 0;
        for (int divider = 1; divider <= firstNumber; divider++) {
            if (firstNumber % divider == 0 && secondNumber % divider == 0) {
                result = divider;
            }
        }
        return result;
    }
    // №9
    static int ticketSaler(int numberOfTicket, int ticketPrice) {
        int netProfit = ticketPrice - (int) (ticketPrice * 0.28);
        return numberOfTicket * netProfit;
    }

    // №10
    static int tables(int numberStudents, int desks) {
        if ((desks / 2) >= numberStudents) {
            return 0;
        }
        int missingPlace = numberStudents - (desks * 2);
        if (missingPlace % 2 == 0){
            return missingPlace / 2;
        }
        return (missingPlace + 1) / 2;

    }
}
