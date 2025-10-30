package lab_no4.age_project;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите возраст: ");
        int age = sc.nextInt();

        try {
            AgeChecker.checkAge(age);
        } catch (CustomAgeException e) {
            System.out.println("Ошибка: " + e.getMessage());
            AgeChecker.logException(e);
        }
    }
} 
