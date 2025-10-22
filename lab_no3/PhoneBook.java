package lab_no3;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private Map<String, Contact> contacts;

    public PhoneBook() {
        contacts = new HashMap<>();
    }

    public void addContact(String phoneNumber, Contact contact) {
        contacts.put(phoneNumber, contact);
    }

    public Contact findContact(String phoneNumber) {
        return contacts.get(phoneNumber);
    }

    public void removeContact(String phoneNumber) {
        contacts.remove(phoneNumber);
    }


}

class Contact {
    private String name;
    private String email;
    private String additionalInfo;

    public Contact(String name, String email, String additionalInfo) {
        this.name = name;
        this.email = email;
        this.additionalInfo = additionalInfo;
    }

    public Contact() {
        this.name = "Unknown";
        this.email = "Unknown";
        this.additionalInfo = "Unknown";
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    @Override 
    public String toString() {
        return "Имя: " + name + ", Email: " + email + ", Дополнительно: " + additionalInfo;
    }
}