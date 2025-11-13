package lab_no5;
import java.util.regex.*;

public class IPvalidation {
    public static void main(String[] args) {
        try {
            String text = "192.168.1.1";
            Pattern pattern = Pattern.compile("^(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\." +
                                              "(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\." +
                                              "(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\." + 
                                              "(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)$");
            Matcher matcher = pattern.matcher(text);
            if (matcher.matches()) {
                System.out.println("IP is valid");
            } else System.out.print("IP is invalid");

        } catch (PatternSyntaxException e) {
            System.out.println("Regex syntax error - " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input - " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected exception - " + e);
        }
    }
}
