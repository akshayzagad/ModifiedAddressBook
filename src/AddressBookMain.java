public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome To Address-book");
        AddressBook familyBook = new AddressBook();
        System.out.println("Ability to create new contact");
        familyBook.addContact();
    }
}
