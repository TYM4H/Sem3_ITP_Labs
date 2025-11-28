package lab_no6;

public class Stack<T> {
    private T[] data;
    private int size;

    public Stack(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public void push(T element) {
        if (size == data.length) {
            throw new RuntimeException("Стек переполнен");
        }
        data[size] = element;
        size++;
    }

    public T pop() {
        if (size == 0) {
            throw new RuntimeException("Стек пуст");
        }
        size--;
        T value = data[size];
        data[size] = null;
        return value;
    }

    public T peek() {
        if (size == 0) {
            throw new RuntimeException("Смотреть не на что");
        }
        return data[size - 1];
    }
}