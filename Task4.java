import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task4 {
    //1
//    public static void main(String[] args) {
//        System.out.println(nonRepeat("abracadabra"));
//        System.out.println(nonRepeat("abababcac"));
//    }

    public static String nonRepeat(String s) {
        return nonRepeatHelper(s, 0);
    }

    private static String nonRepeatHelper(String s, int index) {
        if (index >= s.length()) {
            return "";
        }

        char currentChar = Character.toLowerCase(s.charAt(index));

        long count = s.toLowerCase().chars().filter(ch -> ch == currentChar).count();

        if (count <= 3) {
            return s.charAt(index) + nonRepeatHelper(s, index + 1);
        }

        return nonRepeatHelper(s, index + 1);
    }

    //2
//    public static void main(String[] args) {
//        System.out.println(bruteForce(1, 5));
//        System.out.println(bruteForce(2, 2));
//        System.out.println(bruteForce(5, 3));
//    }

    public static List<String> bruteForce(int n, int k) {
        List<String> results = new ArrayList<>();

        if (n > k || k > 5) {
            return results;
        }

        char[] alphabet = new char[k];
        for (int i = 0; i < k; i++) {
            alphabet[i] = (char) ('0' + i);
        }

        generateCombinations(alphabet, n, "", results);
        return results;
    }

    private static void generateCombinations(char[] alphabet, int length, String current, List<String> results) {
        if (current.length() == length) {
            results.add(current);
            return;
        }

        for (char c : alphabet) {
            if (current.indexOf(c) == -1) {
                generateCombinations(alphabet, length, current + c, results);
            }
        }
    }

    //3
//    public static void main(String[] args) {
//        System.out.println(encode(new int[]{0, 31, 28, 10, 29}, "MKIIT"));
//        System.out.println(decode("MTUCI", "MKIIT"));
//    }


    public static List<Integer> decode(String message, String key) {
        List<Integer> decoded = new ArrayList<>();

        for (int i = 0; i < message.length(); i++) {
            int messageChar = message.charAt(i);
            int keyChar = key.charAt(i);
            int decodedValue = messageChar ^ keyChar;
            decoded.add(decodedValue);
        }

        return decoded;
    }

    public static String encode(int[] numbers, String key) {
        StringBuilder encoded = new StringBuilder();

        for (int i = 0; i < numbers.length; i++) {
            int keyChar = key.charAt(i);
            int encodedChar = numbers[i] ^ keyChar;
            encoded.append((char) encodedChar);
        }

        return encoded.toString();
    }

    //4
//    public static void main(String[] args) {
//        System.out.println(split("()()()"));
//        System.out.println(split("((()))"));
//        System.out.println(split("((()))(())()()(()())"));
//        System.out.println(split("((())())(()(()()))"));
//    }

    public static List<String> split(String str) {
        List<String> result = new ArrayList<>();
        StringBuilder cluster = new StringBuilder();
        int balance = 0;

        for (char ch : str.toCharArray()) {
            cluster.append(ch);

            if (ch == '(') {
                balance++;
            } else {
                balance--;
            }

            if (balance == 0) {
                result.add(cluster.toString());
                cluster.setLength(0);
            }
        }

        return result;
    }

    //5
//    public static void main(String[] args) {
//        System.out.println(shortHand("abbccc"));
//        System.out.println(shortHand("vvvvaajaaaaa"));
//    }

    public static String shortHand(String str) {
        StringBuilder result = new StringBuilder();
        int count = 1;

        for (int i = 0; i < str.length(); i++) {
            if (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else {

                result.append(str.charAt(i));
                if (count > 1) {
                    result.append('*').append(count);
                }
                count = 1;
            }
        }

        return result.toString();
    }

    //6
    public static String convertToRome(int number) {
        if (number <= 0 || number > 1502) {
            throw new IllegalArgumentException("Число должно быть положительным и не превышать 1502.");
        }

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder roman = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (number >= values[i]) {
                number -= values[i];
                roman.append(symbols[i]);
            }
        }

        return roman.toString();
    }

//    public static void main(String[] args) {
//        System.out.println(convertToRome(8));
//        System.out.println(convertToRome(1234));
//        System.out.println(convertToRome(52));
//    }

    //7
//    public static void main(String[] args) {
//        System.out.println(uniqueSubstring("31312131"));
//        System.out.println(uniqueSubstring("1111111"));
//        System.out.println(uniqueSubstring("12223234333"));
//    }

    public static String uniqueSubstring(String str) {
        Map<Character, Integer[]> countMap = new HashMap<>();

        int maxEven = 0, maxOdd = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            countMap.putIfAbsent(ch, new Integer[]{0, 0});

            countMap.get(ch)[i % 2]++;

            if (i % 2 == 0) {
                maxEven = Math.max(maxEven, countMap.get(ch)[0]);
            } else {
                maxOdd = Math.max(maxOdd, countMap.get(ch)[1]);
            }
        }

        return maxEven > maxOdd ? "чет" : maxOdd > maxEven ? "нечет" : "чет";
    }

    //8
    public static List<String> labirint(int[][] grid) {
        int n = grid.length;

        if (grid[0][0] < 0 || grid[n - 1][n - 1] < 0) {
            return List.of("Прохода нет");
        }

        int[][] cost = new int[n][n];

        cost[n - 1][n - 1] = grid[n - 1][n - 1];

        for (int j = n - 2; j >= 0; j--) {
            if (grid[n - 1][j] < 0 || cost[n - 1][j + 1] == Integer.MAX_VALUE) {
                cost[n - 1][j] = Integer.MAX_VALUE;
            } else {
                cost[n - 1][j] = cost[n - 1][j + 1] + grid[n - 1][j];
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (grid[i][n - 1] < 0 || cost[i + 1][n - 1] == Integer.MAX_VALUE) {
                cost[i][n - 1] = Integer.MAX_VALUE;
            } else {
                cost[i][n - 1] = cost[i + 1][n - 1] + grid[i][n - 1];
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (grid[i][j] < 0) {
                    cost[i][j] = Integer.MAX_VALUE;
                } else {
                    int right = (j < n - 1) ? cost[i][j + 1] : Integer.MAX_VALUE;
                    int down = (i < n - 1) ? cost[i + 1][j] : Integer.MAX_VALUE;
                    cost[i][j] = Math.min(right, down);
                    if (cost[i][j] != Integer.MAX_VALUE) {
                        cost[i][j] += grid[i][j];
                    }
                }
            }
        }


        if (cost[0][0] == Integer.MAX_VALUE) {
            return List.of("Прохода нет");
        }

        List<String> path = new ArrayList<>();
        int i = 0, j = 0;
        while (i < n - 1 || j < n - 1) {
            path.add(String.valueOf(grid[i][j]));

            if (j < n - 1 && cost[i][j + 1] != Integer.MAX_VALUE
                    && (i == n - 1 || cost[i][j + 1] <= cost[i + 1][j])) {
                j++;
            } else if (i < n - 1 && cost[i + 1][j] != Integer.MAX_VALUE) {
                i++;
            }
        }
        path.add(String.valueOf(grid[n - 1][n - 1]));

        return List.of(String.join("-", path), String.valueOf(cost[0][0]));
    }

//    public static void main(String[] args) {
//        int[][] labirint1 = {
//                {1, 3, 1},
//                {1, -1, 1},
//                {4, 2, 1}
//        };
//        System.out.println(labirint(labirint1));
//
//        int[][] labirint2 = {
//                {2, -7, 3},
//                {-4, -1, 8},
//                {4, 5, 9}
//        };
//        System.out.println(labirint(labirint2));
//    }

    //9
    public static String numericOrder(String input) {
        String[] words = input.split(" ");

        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String word1, String word2) {
                return extractNumber(word1) - extractNumber(word2);
            }
        });

        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].replaceAll("\\d+", "");
        }

        return String.join(" ", words);
    }

    private static int extractNumber(String word) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(word);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group());
        }
        return Integer.MAX_VALUE;
    }

//    public static void main(String[] args) {
//        System.out.println(numericOrder("t3o the5m 1One all6 r4ule ri2ng"));
//
//        System.out.println(numericOrder("re6sponsibility Wit1h gr5eat power3 4comes g2reat"));
//    }

    //10
    public static boolean fibString(String input) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : input.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        Set<Integer> frequencies = new HashSet<>(frequencyMap.values());

        if (frequencies.size() == 1 && frequencies.contains(1)) {
            return false;
        }

        for (int frequency : frequencies) {
            if (!isFibonacci(frequency)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isFibonacci(int number) {
        if (number == 0) {
            return false;
        }
        int a = 1, b = 1;
        while (b < number) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b == number || a == number;
    }

//    public static void main(String[] args) {
//        System.out.println(fibString("CCCABDD"));
//        System.out.println(fibString("ABC"));
//    }
}
