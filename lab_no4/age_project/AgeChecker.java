package lab_no4.age_project;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class AgeChecker {
    public static void checkAge(int age) throws CustomAgeException {
        if (age < 0 || age > 120) {
            throw new CustomAgeException("Недопустимый возраст: " + age);
        } else {
            System.out.println("Возраст корректный: " + age);
        }
    }

    public static void logException(Exception e) {
        try  {
            FileWriter writer = new FileWriter("exceptions.log", true);
            writer.write(LocalDateTime.now() + " - " + e.getMessage() + "\n");
            writer.close();
        } catch (IOException io) {
            System.out.println("Ошибка при логировании: " + io.getMessage());
        }
    }
}
