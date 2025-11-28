package lab_no6;

public class Main {
    public static void main(String[] args) {

        // Пример из учебника

        Stack<Integer> stack = new Stack<>(10);

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());
        System.out.println(stack.peek()); 

        stack.push(4);

        System.out.println(stack.pop());

        // Мой пример для ошибок 

        Stack<String> stack2 = new Stack<>(1);

        try {
            System.out.println(stack2.pop());
        } catch (RuntimeException e) {
            System.out.println("Ошибка " + e.getMessage());
        }

        stack2.push("A");

        try {
            stack2.push("B");
        } catch (RuntimeException e) {
            System.out.println("Ошибка " + e.getMessage());
        }

        stack2.pop();

        try {
            System.out.println(stack2.peek());
        } catch (RuntimeException e) {
            System.out.println("Ошибка " + e.getMessage());
        }

        System.out.println("\n\n");
        
        // Пример магазина

        Store store = new Store();

        store.sell("Хлеб");
        store.sell("Хлеб");
        store.sell("Молоко");
        store.sell("Колбаса");
        store.sell("Хлеб");
        store.sell("Молоко");

        store.printSales();

        System.out.println("\nВсего продано товаров: " + store.totalSoldItems());

        String popular = store.mostPopular();
        System.out.println("Самый популярный товар: " + popular);
    }
}