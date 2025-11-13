package lab_no5;
import java.util.regex.*;

public class NumberFinder {
    public static void main(String[] args) {
        try {
            String text = "The price of the 2 products is $19.99";
            Pattern pattern = Pattern.compile("\\d+(\\.\\d+)?");
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                System.out.println(matcher.group());
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
