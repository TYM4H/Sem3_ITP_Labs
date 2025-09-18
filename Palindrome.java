package lab_no1;
public class Palindrome {
    public static String reverseString(String original) {
        String s = "";
        for (int i = original.length() - 1; i >= 0; i--) {
            s = s + original.charAt(i);
        }
        return s;
    }
    public static boolean isPalindrome(String s) {
        return s.equals(reverseString(s));
    }
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String s = args[i];
            if (isPalindrome(s)) System.out.println(s + " is palindrome");
        }
    }
}
