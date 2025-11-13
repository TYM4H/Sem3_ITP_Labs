package lab_no5;
import java.util.regex.*;

public class UpperAfterLower {
    public static void main(String[] args) {
        try {
            String text = "A1bcdEfgfhJhfaskD";
            Pattern pattern = Pattern.compile("[a-z][A-Z]");
            Matcher matcher = pattern.matcher(text);

            StringBuffer result = new StringBuffer();

            while (matcher.find()) {
                matcher.appendReplacement(result, "!" + matcher.group() + "!");
            } 
            matcher.appendTail(result);
            System.out.println(result.toString());
        } catch (PatternSyntaxException e) {
            System.out.println("Regex syntax error - " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input - " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected exception - " + e);
        }
    }
}