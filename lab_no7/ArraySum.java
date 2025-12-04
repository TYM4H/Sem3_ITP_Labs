package lab_no7;

public class ArraySum {
    public static void main(String[] args) throws InterruptedException{
        int[] arr = new int[1000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        SumThread thread1 = new SumThread(arr, 0, arr.length / 2);
        SumThread thread2 = new SumThread(arr, arr.length / 2, arr.length);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        int totalSum = thread1.getSum() + thread2.getSum();
        System.out.println("Сумма элементов массива: " + totalSum);
    }
}

class SumThread extends Thread {
    private int[] arr;
    private int start;
    private int end;
    private int sum;

    public SumThread(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
        this.sum = 0;
    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            sum += arr[i];
        }
    }

    public int getSum() {
        return sum;
    }
}
