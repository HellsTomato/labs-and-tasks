import java.util.regex.*;
public class IPAddressValidator {
    public static void main(String[] args) {
        String ip = "192.168.1.1";
        Pattern pattern = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)\\." +
                "(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)$");
        Matcher matcher = pattern.matcher(ip);
        if (matcher.matches()) {
            System.out.println("Valid IP address!");
        } else {
            System.out.println("Invalid IP address.");
        }
    }
}