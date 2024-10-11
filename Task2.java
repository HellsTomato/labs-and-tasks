import java.util.Arrays;

public class Task2 {

    // 1
    //public static void main(String[] args) {
    //    System.out.println(duplicateChars("Barack", "Obama"));
    //}
    static String duplicateChars(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        String count = "";
        for (int i1 = 0; i1 < str1.length(); i1++) {
            boolean flag = false;
            for (int i2 = 0; i2 < str2.length(); i2++) {
                if (str1.charAt(i1) == (str2.charAt(i2))) {
                    flag = true;
                }
            }
            count += flag ? "" : str1.charAt(i1);
        }
        return count;
    }

    // 2
    public static void main(String[] args) {
        int[] numbers = {3, 12, 7, 81, 52};
        System.out.println(dividedByThree(numbers));
    }
    public static int dividedByThree(int[] array) {
        int count = 0;
        for (int numbers : array) {
            if (numbers % 2 != 0 && numbers % 3 == 0) {
                count++;
            }
        }
        return count;
    }

    // 3
    //public static void main(String[] args) {
    //    System.out.println(getInitials("simonov sergei evgenievich"));
    //    System.out.println(getInitials("kozhevnikova tatiana vitalevna"));
    //}
    static String getInitials(String fullName) {
        String[] parts = fullName.split(" ");
        return (parts[1].charAt(0) + "." + parts[2].charAt(0) + ". ").toUpperCase() +
                parts[0].substring(0, 1).toUpperCase() + parts[0].substring(1);
    }

    // 4
//    public static void main(String[] args) {
//        System.out.println(Arrays.toString(normalizator(new double[]{3.5, 7.0, 1.5, 9.0, 5.5})));
//        System.out.println(Arrays.toString(normalizator(new double[]{10.0, 10.0, 10.0, 10.0})));
//    }
    public static double[] normalizator(double[] arr) {
        double min = Double.MAX_VALUE, max = Double.MIN_VALUE;
        for (double n : arr) {
            if (n < min) min = n;
            if (n > max) max = n;
        }
        double[] res = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = (min == max) ? 0 : Math.round((arr[i] - min) / (max - min) * 10000) / 10000.0;
        }
        return res;
    }

    // 5
//    public static void main(String[] args) {
//        double[] array = {1.6, 0, 212.3, 34.8, 0, 27.5};
//        System.out.println(Arrays.toString(compressedNums(array)));
//    }
    public static int[] compressedNums(double[] array) {
        int nonZeroCount = 0;
        for (double num : array) if (num != 0) nonZeroCount++;
        int[] result = new int[nonZeroCount];
        for (double num : array) if (num != 0) result[--nonZeroCount] = (int) num;
        Arrays.sort(result);
        return result;
    }

    // 6
//    public static void main(String[] args) {
//        System.out.println(camelToSnake("helloWorld"));
//    }
    public static String camelToSnake(String str) {
        return str.replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase();
    }

    // 7
//    public static void main(String[] args) {
//        System.out.println(secondBiggest(new int[]{3, 5, 8, 1, 2, 4})); // 5
//    }
    static int secondBiggest(int[] a) {
        int max = Math.max(a[0], a[1]), secondMax = Math.min(a[0], a[1]), n = a.length;
        for (int i = 2; i < n; i++)
            if (a[i] > max) {
                secondMax = max;
                max = a[i];
            } else if (a[i] > secondMax && a[i] != max)
                secondMax = a[i];
        return n < 2 ? 0 : secondMax;
    }
    // 8
//    public static void main(String[] args) {
//        System.out.println(localReverse("baobab", 'b'));
//        System.out.println(localReverse("Hello, I’m under the water, please help me", 'e'));
//    }
    public static String localReverse(String str, char marker) {
        int first = str.indexOf(marker), last = str.lastIndexOf(marker);
        return (first == -1 || first == last) ? str :
                str.substring(0, first + 1) + new StringBuilder(str.substring(first + 1, last)).reverse() + str.substring(last);
    }

    // 9
//    public static void main(String[] args) {
//        System.out.println(equal(8, 1, 8));
//        System.out.println(equal(5, 5, 5));
//        System.out.println(equal(4, 9, 6));
//    }
    public static int equal(int a, int b, int c) {
        if (a == b && b == c) return 3;
        if (a == b || a == c || b == c) return 2;
        return 0;
    }

    // 10
//    public static void main(String[] args) {
//        System.out.println(isAnagram("LISTEN", "silent"));
//        System.out.println(isAnagram("Eleven plus two?", "Twelve plus one!"));
//        System.out.println(isAnagram("hello", "world"));
//    }
    public static boolean isAnagram(String str1, String str2) {
        return normalize(str1).equals(normalize(str2));
    }

    private static String normalize(String str) {
        char[] chars = str.replaceAll("[^a-zA-Z]", "").toLowerCase().toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
