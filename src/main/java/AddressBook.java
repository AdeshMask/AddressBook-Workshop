import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AddressBook {
    PersonsInfo persons = new PersonsInfo();
    Scanner scanner = new Scanner(System.in);
    ArrayList<PersonsInfo> list = new ArrayList<>();
    HashMap<Integer,String> map = new HashMap<>();
    static File file = new File("AddressBook.csv");
    public void addPerson() throws IOException {
        System.out.println("Enter the Contact details");

        System.out.println("Enter the First Name :");
        persons.setFirstName(scanner.next());

        System.out.println("Enter the Last Name :");
        persons.setLastName(scanner.next());

        System.out.println("Enter the Address :");
        persons.setAddress(scanner.next());

        System.out.println("Enter the City :");
        persons.setCity(scanner.next());

        System.out.println("Enter the State :");
        persons.setState(scanner.next());

        System.out.println("Enter the Zip Code :");
        persons.setZip(Integer.parseInt(scanner.next()));

        System.out.println("Enter the Phone Number :");
        persons.setNumber(Long.parseLong(scanner.next()));

        System.out.println("Enter the EMail ID :");
        persons.setEmail(scanner.next());
        list.add(persons);
        writeCSV(persons);
    }

    public void show(){
        System.out.println(list.size());
        if (list.size()==0){
            System.out.println("No Records Found...Empty Address Book");
        }
        else {
            for (int j = 0; j < list.size(); j++) {
                PersonsInfo p = (PersonsInfo) list.get(j);
                System.out.println(list.get(j));
                System.out.println("");
            }
        }
    }

    public void delete(){
        if (list.size()==0){
            System.out.println("No Record Found...Empty Address Book");
        }
        else {
            System.out.println("Enter First Name to delete contact:");
            String name = scanner.nextLine();
            for (int j = 0; j < list.size(); j++) {
                if (name.equals(persons.firstName)) {
                    list.remove(j);
                    System.out.println("Delete Successfully..");
                }
            }
        }
    }

    public void update(){
        System.out.println("Enter First and last name to update details");
        String name1 = scanner.nextLine();
        String name2 = scanner.nextLine();
        for(int j = 0; j < list.size(); j++) {
            if (name1.equals(persons.firstName) && name2.equals(persons.lastName)) {
                System.out.println("Enter Choice to Update\nEnter 1 for Update Address\n Enter 2 for Contact \n " +
                        "Enter 3 for Email address");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Enter Address: ");
                        String address = scanner.nextLine();
                        System.out.println("Enter City Name: ");
                        String city = scanner.nextLine();
                        System.out.println("Enter State: ");
                        String state = scanner.nextLine();
                        System.out.println("Enetr Zip Code:");
                        int zip = scanner.nextInt();
                        break;
                    case 2:
                        System.out.println("Enter contact Number:");
                        long number = scanner.nextLong();
                        break;
                    case 3:
                        System.out.println("Enter Email: ");
                        String email = scanner.nextLine();
                        break;
                }
            }
            else {
                System.out.println("No record found");
            }
        }
    }


    public void writeCSV(PersonsInfo persons) throws IOException {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(persons.getFirstName()+"\r\n" + persons.getLastName() + "\r\n" + persons.getAddress() + "\r\n" + persons.getCitye() +
                    "\r\n" + persons.getState() + "\r\n" + persons.getZip() + "\r\n" + persons.getNumber() + "\r\n" + persons.getEmail() + "\r\n\r\n");
        } catch(IOException e) {
            System.out.println(e);
        }
    }

    public boolean readCSV() {
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String name = null;
            while((name = reader.readLine()) != null) {
                PersonsInfo person = new PersonsInfo(name, reader.readLine(), reader.readLine(), reader.readLine(), reader.readLine(),reader.read(),reader.read(),reader.readLine());
                list.add(person);        //adds person to the list
                reader.readLine();
            }
            return true;
        }
        catch ( IOException e) {
            System.out.println(e);
        }
        return false;
    }
}
