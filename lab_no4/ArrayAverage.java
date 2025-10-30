package lab_no4;

public class ArrayAverage {
    public static void main(String[] args) {
        String[] arr = {"1", "2", "3", "A", "4", "5", "6"};
        int sum = 0;
        int c = 0;
        try {
            for (int i = 0; i <= arr.length; i++) {
                try {
                    sum += Integer.parseInt(arr[i]);
                    c++;
                } catch (NumberFormatException e) {
                    System.out.println("Некорректное число в элементе " + i + ": " + arr[i]);
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка - выход за границы массива");
        } catch (Exception e) {
            System.out.println("Неизвестная ошибка " + e.getMessage());
        }
        double avg = (double) sum / c;
        System.out.println("Среднее: " + avg);
    }
}
