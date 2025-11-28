package lab_no6;

import java.util.HashMap;
import java.util.Map;

public class Store {

    private Map<String, Integer> sales;

    public Store() {
        sales = new HashMap<>();
    }

    public void sell(String product) {
        sales.put(product, sales.getOrDefault(product, 0) + 1);
    }

    public void printSales() {
        if (sales.isEmpty()) {
            System.out.println("Продаж пока нет.");
            return;
        }

        System.out.println("Список проданных товаров:");
        for (Map.Entry<String, Integer> entry : sales.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public String mostPopular() {
        if (sales.isEmpty()) {
            System.out.println("Продаж пока нет.");
            return null;
        }

        String bestProduct = null;
        int maxCount = -1;

        for (Map.Entry<String, Integer> entry : sales.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                bestProduct = entry.getKey();
            }
        }

        return bestProduct;
    }

    public int totalSoldItems() {
        int sum = 0;
        for (int count : sales.values()) {
            sum += count;
        }
        return sum;
    }
}