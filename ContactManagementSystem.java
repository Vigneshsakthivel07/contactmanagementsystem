import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    String name;
    String phone_number;
    String email;

    Contact(String name, String phone_number, String email) {
        this.name = name;
        this.phone_number = phone_number;
        this.email = email;
    }

    public String toString() {
        return "Name: " + name + " | Phone Number: " + phone_number + " | Email: " + email;
    }
}

class ContactManagementSystem {
    private static ArrayList<Contact> contacts = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {
        int choice;
        do {
            System.out.println("\n-----------Contact Management System------------");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contact");
            System.out.println("3. Search Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    viewContact();
                    break;
                case 3:
                    searchContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    System.out.println("-----Exiting-----");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        } while (choice != 5);
    }

    private static void addContact() {
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter phone number: ");
        String phone_number = sc.nextLine();
        System.out.print("Enter email: ");
        String email = sc.nextLine();

        contacts.add(new Contact(name, phone_number, email));
        System.out.println("Contact was added successfully.");
    }

    private static void viewContact() {
        if (contacts.isEmpty()) {
            System.out.println("No Contacts Found!");
        } else {
            System.out.println("-----Contact List-----");
            for (int i = 0; i < contacts.size(); i++) {
                System.out.println((i + 1) + ". " + contacts.get(i));
            }
        }
    }

    private static void searchContact() {
        System.out.print("Enter name to search: ");
        String searchName = sc.nextLine();
        boolean found = false;
        for (Contact c : contacts) {
            if (c.name.equalsIgnoreCase(searchName)) {
                System.out.println("Contact Found: " + c);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Contact Not Found!");
        }
    }

    private static void deleteContact() {
        System.out.print("Enter name to delete: ");
        String deleteName = sc.nextLine();
        boolean removed = contacts.removeIf(c -> c.name.equalsIgnoreCase(deleteName));
        if (removed) {
            System.out.println("Contact was deleted successfully.");
        } else {
            System.out.println("Contact Not Found!");
        }
    }
}