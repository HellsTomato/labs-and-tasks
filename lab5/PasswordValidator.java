import java.util.regex.*;
public class PasswordValidator {
    public static void main(String[] args) {
        String password = "Password1";
        Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)[A-Za-z\\d]{8,16}$");
        Matcher matcher = pattern.matcher(password);
        if (matcher.matches()) {
            System.out.println("Valid password!");
        } else {
            System.out.println("Неверный пароль. Убедитесь, что он состоит из 8-16 символов и содержит как минимум одну заглавную букву, одну строчную букву и одну цифру.");
        }
    }
}
