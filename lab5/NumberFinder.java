import java.util.regex.*;
public class NumberFinder {
    public static void main(String[] args) {
        String text = "Цена товара составляет $19.99, а скидка - 25.23%";
        Pattern getPattern = Pattern.compile("\\d+(\\.\\d+)?"); // Подходит для целых и десятичных чисел
        Matcher getMatcher = getPattern.matcher(text);
        while (getMatcher.find()) {
            System.out.println(getMatcher.group());
        }
    }
}
