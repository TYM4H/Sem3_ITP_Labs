package lab_no3;

public class Main {
    public static void main(String[] args) {
        //пример дял HashTable.java
        HashTable<String, Integer> table = new HashTable<>(5);

        table.put("banana", 3);
        table.put("pear", 2);
        table.put("orange", 7);

        System.out.println(("Значение orange: ") + table.get("orange"));
        table.remove("banana");
        System.out.println("Размер таблицы: " + table.size());

        //пример для PhoneBook.java
        PhoneBook book = new PhoneBook();

        book.addContact("89161234567", new Contact("Владимир", "vova@mail.ru", "Одногруппник"));
        book.addContact("89005553535", new Contact("Мама", "mom@gmail.com", "Родственник"));
        book.addContact("89261112233", new Contact("Андрей", "andrew@mail.ru", "Коллега"));

        System.out.println(book.findContact("89005553535"));

        book.removeContact("89161234567");

    }
}
