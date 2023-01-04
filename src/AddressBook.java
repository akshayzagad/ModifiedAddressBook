import java.util.*;

public class AddressBook {
    ArrayList<Contact> contactList = new ArrayList<>();
    public void addContact() {
        Contact contactPerson = new Contact();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the details of contact person");
        System.out.print("Enter first name:");
        String name=sc.next();
       if (isDuplicate(name)==true){
           System.out.println("This Name Already Existing");
       }else {
           contactPerson.setName(name);
           System.out.print("Enter Last name:");
           contactPerson.setLastName(sc.next());
           System.out.println("Enter the Address : ");
           contactPerson.setAddress(sc.next());
           System.out.println("Enter the City : ");
           contactPerson.setCity(sc.next());
           System.out.println("Enter the State : ");
           contactPerson.setState(sc.next());
           System.out.println("Enter the ZipCode : ");
           contactPerson.setZipCode(sc.next());
           System.out.println("Enter the Mobile no : ");
           contactPerson.setPhoneNo(sc.next());
           contactList.add(contactPerson);
       }
    }
    @Override
    public String toString() {
        return "AddressBook{" +
                "contactList=" + contactList +
                '}';
    }

    public void editContact() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first name:");
        String name = sc.next();
        for (Contact contactPerson : contactList) {
            if (name.equals(contactPerson.getName())) {
                System.out.println("What you want to edit for the contact");
                System.out.println("1.First Name\n2.Last Name\n3.Address\n4.City\n5.State\n6.Zip Code\n7.Mobile Number\n8.Email id");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Enter the First Name :");
                        contactPerson.setName(sc.next());
                        break;
                    case 2:
                        System.out.println("Enter the Last Name :");
                        contactPerson.setLastName(sc.next());
                        break;
                    case 3:
                        System.out.println("Enter the Address :");
                        contactPerson.setAddress(sc.next());
                        break;
                    case 4:
                        System.out.println("Enter the City :");
                        contactPerson.setCity(sc.next());
                        break;
                    case 5:
                        System.out.println("Enter the State :");
                        contactPerson.setState(sc.next());
                        break;
                    case 6:
                        System.out.println("Enter the Zip code :");
                        contactPerson.setZipCode(sc.next());
                        break;
                    case 7:
                        System.out.println("Enter the Mobile Number :");
                        contactPerson.setPhoneNo(sc.next());
                        break;
                }
            }
        }
    }
    public void deleteContact() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first name:");
        String name = sc.next();
        for (Contact contactPerson : contactList) {
            if (name.equals(contactPerson.getName())) {
                contactList.remove(contactPerson);
                break;
            }
        }
    }
    public void choice() {

        Scanner scanner = new Scanner(System.in);
        int opration;
        do {
            System.out.println("1. ADD CONTACT \n2. DISPLAY CONTACT \n3 EDIT \n4 Delete \n5. EXIT ");
            System.out.println("Enter the Operation Number");
            opration = scanner.nextInt();
            switch (opration) {
                case 1:
                    addContact();
                    break;
                case 2:
                    System.out.println(this);
                    break;
                case 3:
                    editContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("Enter The Wrong Opration Number");
            }
        } while (opration != 5);
    }
    /*
     * This method is used to check the duplicate entry
     * if first and last name already exists in addressbook then it will not return true i.e. duplicate entry
     * if duplicate return true else return false
     * */
    public boolean isDuplicate(String name){
        return contactList.stream().anyMatch(contact ->contact.getName().equals(name) );
    }
    public static void sortByName(HashMap<String, AddressBook> addressBookHashMap) {
        List<Contact> list = new ArrayList<>();
        for (Map.Entry<String, AddressBook> entries : addressBookHashMap.entrySet()) {
            list =entries.getValue().contactList;
            list.stream().sorted((p1, p2) -> ((String)p1.getName()).compareTo(p2.getName()))
                    .forEach(contact -> System.out.println(contact));
        }
    }
}
