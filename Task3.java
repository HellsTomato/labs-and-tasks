import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Task3 {

    //1
    public static boolean isStrangePair(String str1, String str2) {
        if (str1.isEmpty() && str2.isEmpty()) {
            return true;
        }
        return !str1.isEmpty() && !str2.isEmpty()
                && str1.charAt(0) == str2.charAt(str2.length() - 1)
                && str1.charAt(str1.length() - 1) == str2.charAt(0);
    }

//    public static void main(String[] args) {
//        System.out.println(isStrangePair("ratio", "orator"));
//        System.out.println(isStrangePair("sparkling", "groups"));
//        System.out.println(isStrangePair("bush", "hubris"));
//        System.out.println(isStrangePair("", ""));
//    }

    //2
    public static List<String[]> applyDiscount(List<String[]> products, int discount) {
        List<String[]> updProducts = new ArrayList<>();

        for (String[] product : products) {
            String name = product[0];
            int origPrice = Integer.parseInt(product[1]);

            int discdPrice = (int) Math.round(origPrice * (1 - discount / 100.0));

            if (discdPrice < 1) {
                discdPrice = 1;
            }
            updProducts.add(new String[]{name, String.valueOf(origPrice), String.valueOf(discdPrice)});
        }
        return updProducts;
    }

//    public static void main(String[] args) {
//        List<String[]> products = new ArrayList<>();
//        products.add(new String[]{"Laptop", "124200"});
//        products.add(new String[]{"Phone", "51450"});
//        products.add(new String[]{"Headphones", "13800"});
//
//        List<String[]> result = applyDiscount(products, 25);
//
//        for (String[] product : result) {
//            System.out.println(product[0] + ": Исходная цена = " + product[1] + ", Цена со скидкой = " + product[2]);
//        }
//    }

    //3
    public static boolean successShoot(double x, double y, double r, double m, double n) {

        double distance = Math.sqrt(Math.pow(x - m, 2) + Math.pow(y - n, 2));
        return distance <= r;
    }

//    public static void main(String[] args) {
//        System.out.println(successShoot(2, 0, 5, 2, 2));
//        System.out.println(successShoot(-2, -3, 4, 5, -6));
//    }

    //4
    public static boolean parityAnalysis(int number) {
        boolean isNumberEven = number % 2 == 0;
        int sumOfDigits = 0;
        int temp = number;

        while (temp > 0) {
            sumOfDigits += temp % 10;
            temp /= 10;
        }

        boolean isSumEven = sumOfDigits % 2 == 0;

        return isNumberEven == isSumEven;
    }

//    public static void main(String[] args) {
//        System.out.println(parityAnalysis(243));
//        System.out.println(parityAnalysis(12));
//        System.out.println(parityAnalysis(3));
//    }

    //5
    public static String rps(String player1, String player2) {

        if (player1.equals(player2)) {
            return "Tie";
        }

        if ((player1.equals("rock") && player2.equals("scissors")) ||
                (player1.equals("scissors") && player2.equals("paper")) ||
                (player1.equals("paper") && player2.equals("rock"))) {
            return "Player 1 wins";
        }

        return "Player 2 wins";
    }

//    public static void main(String[] args) {
//        System.out.println(rps("rock", "paper"));
//        System.out.println(rps("paper", "rock"));
//        System.out.println(rps("paper", "scissors"));
//        System.out.println(rps("scissors", "scissors"));
//        System.out.println(rps("scissors", "paper"));
//    }

    //6
    public static int bugger(int num) {
        int count = 0;

        while (num >= 10) {
            num = multiplyDigits(num);
            count++;
        }

        return count;
    }

    private static int multiplyDigits(int num) {
        int product = 1;

        while (num > 0) {
            product *= num % 10;
            num /= 10;
        }

        return product;
    }

//    public static void main(String[] args) {
//        System.out.println(bugger(39));
//        System.out.println(bugger(999));
//        System.out.println(bugger(4));
//    }

    //7
    public static String mostExpensive(Object[][] items) {
        String maxItem = "";
        int maxTotalValue = 0;

        for (Object[] item : items) {
            int totalValue = (int) item[1] * (int) item[2];
            if (totalValue > maxTotalValue) {
                maxTotalValue = totalValue;
                maxItem = (String) item[0];
            }
        }

        return "Наиб. общ. стоимость у предмета " + maxItem + " - " + maxTotalValue;
    }

//    public static void main(String[] args) {
//        Object[][] inventory = {
//                {"Скакалка", 550, 8},
//                {"Шлем", 3750, 4},
//                {"Мяч", 2900, 10}
//        };
//
//        System.out.println(mostExpensive(inventory));
//    }

    //8
    public static String longestUnique(String str) {
        int start = 0, maxLength = 0, maxStart = 0;
        Set<Character> seen = new HashSet<>();

        for (int end = 0; end < str.length(); end++) {
            while (seen.contains(str.charAt(end))) {
                seen.remove(str.charAt(start++));
            }
            seen.add(str.charAt(end));
            if (end - start + 1 > maxLength) {
                maxLength = end - start + 1;
                maxStart = start;
            }
        }

        return str.substring(maxStart, maxStart + maxLength);
    }

//    public static void main(String[] args) {
//        System.out.println(longestUnique("abcba"));  //
//        System.out.println(longestUnique("bbb"));    //
//        System.out.println(longestUnique("pwwkew")); //
//    }

    //9
    public static boolean isPrefix(String word, String prefix) {
        return word.startsWith(prefix.substring(0, prefix.length() - 1));
    }

    public static boolean isSuffix(String word, String suffix) {
        return word.endsWith(suffix.substring(1));
    }

//    public static void main(String[] args) {
//
//        System.out.println(isPrefix("automation", "auto-"));
//        System.out.println(isSuffix("arachnophobia", "-phobia"));
//        System.out.println(isPrefix("retrospect", "sub-"));
//        System.out.println(isSuffix("vocation", "-logy"));
//    }

    //10
    public static boolean doesBrickFit(int a, int b, int c, int w, int h) {
        return (a <= w && b <= h) || (a <= h && b <= w) ||
                (a <= w && c <= h) || (a <= h && c <= w) ||
                (b <= w && c <= h) || (b <= h && c <= w);
    }

//    public static void main(String[] args) {
//        System.out.println(doesBrickFit(1, 1, 1, 1, 1));  // ➞ true
//        System.out.println(doesBrickFit(1, 2, 1, 1, 1));  // ➞ true
//        System.out.println(doesBrickFit(1, 2, 2, 1, 1));  // ➞ false
//    }
}
