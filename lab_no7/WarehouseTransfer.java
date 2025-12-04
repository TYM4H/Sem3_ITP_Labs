package lab_no7;

import java.util.*;
import java.util.Arrays;
import java.util.concurrent.*;

public class WarehouseTransfer {
    private static final int MAX_WEIGHT = 150;
    private static final int LOADERS = 3;

    public static void main(String[] args) {
        List<Integer> goods = Arrays.asList(50, 70, 30, 90, 20, 60, 80, 40, 10, 100);

        ExecutorService executor = Executors.newFixedThreadPool(LOADERS);
        List<List<Integer>> batches = createBatches(goods);

        System.out.println("Сформировано партий для переноса: " + batches.size());

        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (List<Integer> batch: batches) {
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                int sum = batch.stream().mapToInt(Integer::intValue).sum();
                System.out.println("Перенос партии " + batch + " с общим весом " + sum);
                simulateTransferDelay();
                System.out.println("Партия " + batch + " успешно перенесена.");
            }, executor);

            futures.add(future);
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        executor.shutdown();
        System.out.println("Все партии успешно перенесены.");
    }

    private static List<List<Integer>> createBatches(List<Integer> goods) {
        List<List<Integer>> batches = new ArrayList<>();
        List<Integer> currentBatch = new ArrayList<>();
        int currentWeight = 0;

        for (int weight : goods) {
            if (currentWeight + weight <= MAX_WEIGHT) {
                currentBatch.add(weight);
                currentWeight += weight;
            } else {
                batches.add(new ArrayList<>(currentBatch));
                currentBatch.clear();
                currentBatch.add(weight);
                currentWeight = weight;
            }
        }

        if (!currentBatch.isEmpty()) {
            batches.add(currentBatch);
        }

        return batches;
    }
    private static void simulateTransferDelay() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
