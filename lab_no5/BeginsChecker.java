package lab_no5;

import java.util.regex.*;

public class BeginsChecker {
    public static void main(String[] args) {
        try {
            String beginLetter = "t";
            String text = "A simple text to demonstrate the abilities of this programm";
            Pattern pattern = Pattern.compile("\\b" + beginLetter + "[a-zA-Z]*\\b");
            Matcher matcher = pattern.matcher(text);
            boolean found = false;

            while (matcher.find()) {
                System.out.println(matcher.group());
                found = true;
            }

            if (!found) {
                System.out.print("Nothing begins with " + beginLetter + "in text");
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
