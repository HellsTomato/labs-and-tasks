import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Task5 {

    //1
//    public static boolean sameLetterPattern(String str1, String str2) {
//        if (str1.length() != str2.length()) {
//            return false; // Разные длины строк сразу исключают совпадение шаблонов
//        }
//
//        return getPattern(str1).equals(getPattern(str2));
//    }
//
//    private static String getPattern(String str) {
//        HashMap<Character, Integer> charMap = new HashMap<>();
//        StringBuilder pattern = new StringBuilder();
//        int uniqueCharIndex = 0;
//
//        for (char ch : str.toCharArray()) {
//            if (!charMap.containsKey(ch)) {
//                charMap.put(ch, uniqueCharIndex++);
//            }
//            pattern.append(charMap.get(ch));
//        }
//
//        return pattern.toString();
//    }
//
//    public static void main(String[] args) {
//        System.out.println(sameLetterPattern("ABAB", "CDCD"));
//        System.out.println(sameLetterPattern("ABCBA", "BCDCB"));
//        System.out.println(sameLetterPattern("FFGG", "CDCD"));
//        System.out.println(sameLetterPattern("FFFF", "ABCD"));
//    }

    //2
//    public static int memeSum(int num1, int num2) {
//        StringBuilder result = new StringBuilder();
//        String str1 = String.valueOf(num1);
//        String str2 = String.valueOf(num2);
//
//        while (str1.length() < str2.length()) str1 = "0" + str1;
//        while (str2.length() < str1.length()) str2 = "0" + str2;
//
//        for (int i = 0; i < str1.length(); i++) {
//            int digit1 = str1.charAt(i) - '0';
//            int digit2 = str2.charAt(i) - '0';
//            result.append(digit1 + digit2);
//        }
//
//        return Integer.parseInt(result.toString());
//    }
//
//    public static void main(String[] args) {
//        System.out.println(memeSum(26, 39));
//        System.out.println(memeSum(122, 81));
//        System.out.println(memeSum(1222, 30277));
//    }

    //3
//    public static int digitsCount(long num) {
//        if (num < 10 && num > -10) return 1;
//        return 1 + digitsCount(num / 10);
//    }
//
//    public static void main(String[] args) {
//        System.out.println(digitsCount(4666));
//        System.out.println(digitsCount(544));
//        System.out.println(digitsCount(121317));
//        System.out.println(digitsCount(0));
//        System.out.println(digitsCount(12345));
//        System.out.println(digitsCount(1289396387328L));
//    }

    //4
//    public static int totalPoints(String[] guessedWords, String scrambledWord) {
//        int totalPoints = 0;
//
//        for (String word : guessedWords) {
//            if (isValidWord(word, scrambledWord)) {
//                int length = word.length();
//                if (length == 3) totalPoints += 1;
//                else if (length == 4) totalPoints += 2;
//                else if (length == 5) totalPoints += 3;
//                else if (length == 6) totalPoints += 54;
//            }
//        }
//
//        return totalPoints;
//    }
//
//    private static boolean isValidWord(String word, String scrambledWord) {
//        Map<Character, Integer> scrambledCount = getCharCount(scrambledWord);
//        Map<Character, Integer> wordCount = getCharCount(word);
//
//        for (Map.Entry<Character, Integer> entry : wordCount.entrySet()) {
//            char ch = entry.getKey();
//            int count = entry.getValue();
//            if (!scrambledCount.containsKey(ch) || scrambledCount.get(ch) < count) {
//                return false;
//            }
//        }
//
//        return true;
//    }
//
//    private static Map<Character, Integer> getCharCount(String word) {
//        Map<Character, Integer> countMap = new HashMap<>();
//        for (char ch : word.toCharArray()) {
//            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
//        }
//        return countMap;
//    }
//
//    public static void main(String[] args) {
//        System.out.println(totalPoints(new String[]{"cat", "create", "sat"}, "caster"));
//        System.out.println(totalPoints(new String[]{"trance", "recant"}, "recant"));
//        System.out.println(totalPoints(new String[]{"dote", "dotes", "toes", "set", "dot", "dots", "sted"}, "tossed"));
//    }

    //5
//    public static int longestRun(int[] numbers) {
//        if (numbers.length == 0) return 0;
//
//        int maxLength = 1;
//        int currentLength = 1;
//
//        for (int i = 1; i < numbers.length; i++) {
//            if (numbers[i] == numbers[i - 1] + 1 || numbers[i] == numbers[i - 1] - 1) {
//                currentLength++;
//                maxLength = Math.max(maxLength, currentLength);
//            } else {
//                currentLength = 1;
//            }
//        }
//
//        return maxLength;
//    }
//
//    public static void main(String[] args) {
//        System.out.println(longestRun(new int[]{1, 2, 3, 5, 6, 7, 8, 9}));
//        System.out.println(longestRun(new int[]{1, 2, 3, 10, 11, 15}));
//        System.out.println(longestRun(new int[]{5, 4, 2, 1}));
//        System.out.println(longestRun(new int[]{3, 5, 7, 10, 15}));
//    }

    //6
//    public static String takeDownAverage(String[] scores) {
//        int totalSum = 0;
//
//        for (String score : scores) {
//            totalSum += Integer.parseInt(score.replace("%", ""));
//        }
//
//        int n = scores.length;
//
//        int currentAverage = totalSum / n;
//
//        int targetAverage = currentAverage - 5;
//
//        int neededTotalSum = targetAverage * (n + 1);
//
//        int neededScore = neededTotalSum - totalSum;
//
//        return neededScore + "%";
//    }
//
//    public static void main(String[] args) {
//        System.out.println(takeDownAverage(new String[]{"95%", "83%", "90%", "87%", "88%", "93%"}));
//        System.out.println(takeDownAverage(new String[]{"10%"}));
//        System.out.println(takeDownAverage(new String[]{"53%", "79%"}));
//    }

    //7
//    public static boolean canMove(String piece, String start, String end) {
//        int startCol = start.charAt(0) - 'A';
//        int startRow = start.charAt(1) - '1';
//        int endCol = end.charAt(0) - 'A';
//        int endRow = end.charAt(1) - '1';
//
//        switch (piece.toLowerCase()) {
//            case "пешка":
//                return (startCol == endCol && endRow == startRow + 1);
//            case "конь":
//                return (Math.abs(startCol - endCol) == 2 && Math.abs(startRow - endRow) == 1) ||
//                        (Math.abs(startCol - endCol) == 1 && Math.abs(startRow - endRow) == 2);
//            case "слон":
//                return Math.abs(startCol - endCol) == Math.abs(startRow - endRow);
//            case "ладья":
//                return startCol == endCol || startRow == endRow;
//            case "ферзь":
//                return (startCol == endCol || startRow == endRow) ||
//                        (Math.abs(startCol - endCol) == Math.abs(startRow - endRow));
//            case "король":
//                return Math.abs(startCol - endCol) <= 1 && Math.abs(startRow - endRow) <= 1;
//            default:
//                return false;
//        }
//    }
//
//    public static void main(String[] args) {
//        System.out.println(canMove("Ладья", "A8", "H8"));
//        System.out.println(canMove("Слон", "A7", "G1"));
//        System.out.println(canMove("Ферзь", "C4", "D6"));
//    }

    //8
//    public static int maxPossible(int num1, int num2) {
//        List<Integer> digits1 = Arrays.stream(String.valueOf(num1).split("")).map(Integer::parseInt).collect(Collectors.toList());
//        List<Integer> digits2 = Arrays.stream(String.valueOf(num2).split("")).map(Integer::parseInt).collect(Collectors.toList());
//
//        Collections.sort(digits2, Collections.reverseOrder());
//
//        int index2 = 0;
//
//        for (int i = 0; i < digits1.size(); i++) {
//            if (index2 < digits2.size() && digits2.get(index2) > digits1.get(i)) {
//                digits1.set(i, digits2.get(index2));
//                index2++;
//            }
//        }
//
//        return Integer.parseInt(digits1.stream().map(String::valueOf).collect(Collectors.joining()));
//    }
//
//    public static void main(String[] args) {
//        System.out.println(maxPossible(9328, 456));
//        System.out.println(maxPossible(523, 76));
//        System.out.println(maxPossible(9132, 5564));
//        System.out.println(maxPossible(8732, 91255));
//    }

    //9
//    public static String timeDifference(String cityA, String timestamp, String cityB) {
//        Map<String, Integer> timeOffsets = new HashMap<>();
//        timeOffsets.put("Los Angeles", -8);
//        timeOffsets.put("New York", -5);
//        timeOffsets.put("Caracas", -4);
//        timeOffsets.put("Buenos Aires", -3);
//        timeOffsets.put("London", 0);
//        timeOffsets.put("Rome", 1);
//        timeOffsets.put("Moscow", 3);
//        timeOffsets.put("Tehran", 3);
//        timeOffsets.put("New Delhi", 5);
//        timeOffsets.put("Beijing", 8);
//        timeOffsets.put("Canberra", 10);
//
//        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MMMM d, yyyy HH:mm", Locale.ENGLISH);
//        try {
//            LocalDateTime dateTimeA = LocalDateTime.parse(timestamp, inputFormatter);
//            int offsetA = timeOffsets.get(cityA);
//            int offsetB = timeOffsets.get(cityB);
//
//            ZonedDateTime zonedDateTimeA = dateTimeA.atOffset(ZoneOffset.ofHours(offsetA)).toZonedDateTime();
//            ZonedDateTime zonedDateTimeB = zonedDateTimeA.withZoneSameInstant(ZoneOffset.ofHours(offsetB));
//
//            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-M-d H:mm");
//            return zonedDateTimeB.format(outputFormatter);
//        } catch (Exception e) {
//            return null;
//        }
//    }
//
//    public static void main(String[] args) {
//        System.out.println(timeDifference("Los Angeles", "April 1, 2011 23:23", "Canberra"));
//        System.out.println(timeDifference("London", "July 31, 1983 23:01", "Rome"));
//        System.out.println(timeDifference("New York", "December 31, 1970 13:40", "Beijing"));
//    }

    //10
//    public static boolean isNew(int num) {
//        String numStr = String.valueOf(num);
//        Set<String> permutations = new HashSet<>();
//        generatePermutations("", numStr, permutations);
//
//        for (String perm : permutations) {
//            if (!perm.startsWith("0") && Integer.parseInt(perm) < num) {
//                return false;
//            }
//        }
//
//        return true;
//    }
//
//    private static void generatePermutations(String prefix, String str, Set<String> permutations) {
//        int n = str.length();
//        if (n == 0) {
//            permutations.add(prefix);
//        } else {
//            for (int i = 0; i < n; i++) {
//                generatePermutations(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), permutations);
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        System.out.println(isNew(3));
//        System.out.println(isNew(30));
//        System.out.println(isNew(321));
//        System.out.println(isNew(123));
//    }
}
