package lab_no5;
import java.util.regex.*;

public class PasswordChecker {
        public static void main(String[] args) {
        try {
            String password = "A1bcdEfg";
            Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*[0-9])[A-Za-z0-9]{8,16}$");
            Matcher matcher = pattern.matcher(password);
            if (matcher.matches()) {
                System.out.println("Password is valid");
            } else {
                System.out.println("Password is invalid");
            }
        } catch (PatternSyntaxException e) {
            System.out.println("Regex syntax error - " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input - " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected exception - " + e);
        }
    }
}