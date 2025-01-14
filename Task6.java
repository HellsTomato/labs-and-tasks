import java.util.*;
import java.util.Stack;

public class Task6 {

    // 1. Поиск скрытой анаграммы
    public static class HiddenAnagram {
        public static String hiddenAnagram(String str1, String str2) {
            str1 = str1.replaceAll("[^a-zA-Z]", "").toLowerCase();
            str2 = str2.replaceAll("[^a-zA-Z]", "").toLowerCase();
            
            if (str2.length() > str1.length()) return "noutfond";
            
            Map<Character, Integer> target = new HashMap<>();
            for (char c : str2.toCharArray()) {
                target.put(c, target.getOrDefault(c, 0) + 1);
            }
            
            int left = 0, right = 0, matchCount = 0;
            Map<Character, Integer> window = new HashMap<>();
            
            while (right < str1.length()) {
                char c = str1.charAt(right);
                right++;
                window.put(c, window.getOrDefault(c, 0) + 1);
                
                if (target.containsKey(c) && window.get(c).equals(target.get(c))) {
                    matchCount++;
                }
                
                if (matchCount == target.size()) {
                    return str1.substring(left, right);
                }
                
                while (right - left > str2.length()) {
                    char leftChar = str1.charAt(left);
                    left++;
                    if (window.containsKey(leftChar)) {
                        window.put(leftChar, window.get(leftChar) - 1);
                        if (window.get(leftChar) < target.getOrDefault(leftChar, 0)) {
                            matchCount--;
                        }
                    }
                }
            }
            return "noutfond";
        }
    }

    // 2. Удаление дублирующихся параметров URL
    public static class URLStripper {
        public static String stripUrlParams(String url, String[] excludeParams) {
            String baseUrl = url.split("\\?")[0];
            String queryString = url.contains("?") ? url.split("\\?")[1] : "";
            
            String[] pairs = queryString.split("&");
            Set<String> excludeSet = new HashSet<>(Arrays.asList(excludeParams));
            Map<String, String> paramMap = new LinkedHashMap<>();
            
            for (String pair : pairs) {
                String[] keyValue = pair.split("=");
                if (!excludeSet.contains(keyValue[0])) {
                    paramMap.put(keyValue[0], keyValue[1]);
                }
            }
            
            StringBuilder result = new StringBuilder(baseUrl);
            if (!paramMap.isEmpty()) {
                result.append("?");
                paramMap.forEach((key, value) -> result.append(key).append("=").append(value).append("&"));
                result.deleteCharAt(result.length() - 1);
            }
            
            return result.toString();
        }
    }

    // 3. Шифр Нико
    public static class NicoCipher {
        public static String nicoCipher(String message, String key) {
            List<Character> sortedKey = new ArrayList<>();
            for (char c : key.toCharArray()) {
                sortedKey.add(c);
            }
            Collections.sort(sortedKey);
            
            Map<Character, Integer> indexMap = new HashMap<>();
            for (int i = 0; i < key.length(); i++) {
                indexMap.put(sortedKey.get(i), i);
            }
            
            int rows = (int) Math.ceil((double) message.length() / key.length());
            char[][] matrix = new char[rows][key.length()];
            int index = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < key.length(); j++) {
                    if (index < message.length()) {
                        matrix[i][j] = message.charAt(index++);
                    } else {
                        matrix[i][j] = ' ';
                    }
                }
            }
            
            StringBuilder encrypted = new StringBuilder();
            for (int i = 0; i < key.length(); i++) {
                char keyChar = sortedKey.get(i);
                int col = indexMap.get(keyChar);
                for (int j = 0; j < rows; j++) {
                    encrypted.append(matrix[j][col]);
                }
            }
            
            return encrypted.toString();
        }
    }

    // 4. Поиск пары чисел с заданным произведением
    public static class TwoProduct {
        public static int[] twoProduct(int[] arr, int n) {
            Map<Integer, Integer> seen = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                int target = n / arr[i];
                if (n % arr[i] == 0 && seen.containsKey(target)) {
                    return new int[] {target, arr[i]};
                }
                seen.put(arr[i], i);
            }
            return new int[] {};
        }
    }

    // 5. Проверка точности верхней границы факториала
    public static class FactorialBoundary {
        public static int[] isExact(int n) {
            return isExactHelper(n, 1, 1);
        }

        private static int[] isExactHelper(int n, int factorial, int i) {
            if (factorial == n) {
                return new int[] {n, i};
            }
            if (factorial > n) {
                return new int[] {};
            }
            return isExactHelper(n, factorial * (i + 1), i + 1);
        }
    }

    // 6. Преобразование повторяющейся десятичной дроби в дробь
    public static class Fraction {
        public static String fractions(String decimal) {
            String[] parts = decimal.split("\\.");
            String nonRepeating = parts[0];
            String repeating = parts.length > 1 ? parts[1] : "";

            if (repeating.isEmpty()) {
                return nonRepeating + "/1";
            }

            String numerator = nonRepeating + repeating;
            String denominator = "9".repeat(repeating.length());
            
            int num = Integer.parseInt(numerator);
            int denom = Integer.parseInt(denominator);
            
            return num + "/" + denom;
        }
    }

    // 7. Формирование строки по цифрам числа Пи
    public static class PilishString {
        private static final int[] PI_DIGITS = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5, 8, 9, 7, 9};

        public static String pilishString(String txt) {
            StringBuilder result = new StringBuilder();
            int idx = 0;
            
            for (int digit : PI_DIGITS) {
                if (idx >= txt.length()) {
                    break;
                }
                String word = txt.substring(idx, Math.min(idx + digit, txt.length()));
                result.append(word);
                if (word.length() < digit) {
                    char lastChar = word.charAt(word.length() - 1);
                    while (word.length() < digit) {
                        word += lastChar;
                    }
                }
                idx += digit;
            }
            
            return result.toString();
        }
    }

    // 8. Проверка правильности математической формулы
    public static class FormulaValidator {
        public static boolean formula(String formula) {
            if (formula == null || formula.isEmpty()) return false;
            
            Stack<Character> stack = new Stack<>();
            for (char ch : formula.toCharArray()) {
                if (ch == '(') {
                    stack.push(ch);
                } else if (ch == ')') {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }
    }

    // 9. Проверка на действительность строки
    public static class ValidString {
        public static String isValid(String str) {
            Map<Character, Integer> frequency = new HashMap<>();
            for (char c : str.toCharArray()) {
                frequency.put(c, frequency.getOrDefault(c, 0) + 1);
            }
            
            Set<Integer> counts = new HashSet<>(frequency.values());
            if (counts.size() > 2) {
                return "not valid";
            }
            
            if (counts.size() == 1 || (counts.size() == 2 && counts.contains(1))) {
                return "valid";
            }
            return "not valid";
        }
    }

    // 10. Палиндром потомков числа
    public static class PalindromeDescendant {
        public static boolean palindromeDescendant(int num) {
            String numStr = String.valueOf(num);
            while (numStr.length() > 1) {
                numStr = sumAdjacentDigits(numStr);
                if (isPalindrome(numStr)) {
                    return true;
                }
            }
            return false;
        }

        private static String sumAdjacentDigits(String numStr) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < numStr.length() - 1; i++) {
                sb.append(Integer.parseInt(String.valueOf(numStr.charAt(i))) +
                        Integer.parseInt(String.valueOf(numStr.charAt(i + 1))));
            }
            return sb.toString();
        }

        private static boolean isPalindrome(String str) {
            return str.equals(new StringBuilder(str).reverse().toString());
        }
    }

    public static void main(String[] args) {
    
    }
}
