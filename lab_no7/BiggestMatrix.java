package lab_no7;

public class BiggestMatrix {
    public static void main(String[] args) throws InterruptedException {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        MaxFinder[] tasks = new MaxFinder[matrix.length];
        Thread[] threads = new Thread[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            tasks[i] = new MaxFinder(matrix[i]);
            threads[i] = new Thread(tasks[i]);
            threads[i].start();
        }

        for (Thread t: threads) {
            t.join();
        }

        int globalMax = Integer.MIN_VALUE;
        for (MaxFinder task : tasks) {
            if (task.getMax() > globalMax) {
                globalMax = task.getMax();
            }
        }

        System.out.println("Максимальный элемент в матрице: " + globalMax);
    }
}

class MaxFinder implements Runnable {
    private int[] array;
    private int max = Integer.MIN_VALUE;

    public MaxFinder(int[] array) {
        this.array = array;
        this.max = Integer.MIN_VALUE;
    }

    @Override
    public void run() {
        for (int num : array) {
            if (num > max) {
                max = num;
            }
        }
    }

    public int getMax() {
        return max;
    }
}