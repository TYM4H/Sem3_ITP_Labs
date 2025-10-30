package lab_no4;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) {
        FileReader reader = null;
        FileWriter writer = null;

        try {
            reader = new FileReader("input.txt");
            writer = new FileWriter("output.txt");

            int c;
            while (true) {
                try {
                    c = reader.read();
                    if (c == -1) break;
                    writer.write(c);
                } catch (IOException e) {
                    System.out.println("Ошибка при чтении или записи: " + e.getMessage());
                    break;
                }
            }

            System.out.println("Файл успешно скопирован!");

        } catch (IOException e) {
            System.out.println("Ошибка при открытии файла: " + e.getMessage());
        } finally {
            try {
                if (reader != null) reader.close();
            } catch (IOException e) {
                System.out.println("Ошибка при закрытии файла-источника: " + e.getMessage());
            }
            try {
                if (writer != null) writer.close();
            } catch (IOException e) {
                System.out.println("Ошибка при закрытии файла-приёмника: " + e.getMessage());
            }
        }
    }
}
