import com.opencsv.CSVWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import org.json.simple.JSONObject;


public class AddressBook {
    PersonsInfo persons = new PersonsInfo();
    Scanner scanner = new Scanner(System.in);
    ArrayList<PersonsInfo> list = new ArrayList<>();
    HashMap<Integer,String> map = new HashMap<>();
    private static final String FILE_HEADER = "first_Name,last_Name,Addess,City,State,Zip,Number,Email_ID";
    static File file = new File("AddressBook.csv");
    static File file1 = new File("AddressBook.json");
    private static final String COMMA_DELIMITER = ",";
    FileWriter fileWriter = null;
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
        writeCSV(list);
        readAndWriteJsonFile(persons);
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


    public void writeCSV(ArrayList<PersonsInfo> list) throws IOException {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("AddressBook.csv");
            CSVWriter writer = new CSVWriter(fileWriter);
            fileWriter.append(FILE_HEADER.toString());
            //writer.writeNext(list);
        }catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        }
        fileWriter.close();
    }

    public void readCSV() throws IOException {

        BufferedReader fileReader = null;
        String line = "";
        fileReader = new BufferedReader(new FileReader("AddressBook.csv"));
        fileReader.readLine();
        while ((line = fileReader.readLine()) != null) {
            String[] tokens = line.split(COMMA_DELIMITER);
            if (tokens.length > 0) {
                PersonsInfo person = new PersonsInfo(fileReader.readLine(), fileReader.readLine(), fileReader.readLine(), fileReader.readLine(), fileReader.read(), fileReader.read(), fileReader.readLine());
                list.add(person);
            }
        }
    }

    public void readAndWriteJsonFile(PersonsInfo p) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("FisrtName", p.getFirstName());
        jsonObject.put("LastName", p.getLastName());
        jsonObject.put("Adress", p.getAddress());
        jsonObject.put("City", p.getCitye());
        jsonObject.put("State", p.getState());
        jsonObject.put("ContactNumber", p.getNumber());
        jsonObject.put("Zip", p.getZip());
        jsonObject.put("Email", p.getEmail());
        try {
            FileWriter file = new FileWriter(file1);
            file.write(jsonObject.toJSONString());
            file.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("JSON file created: " + jsonObject);

    }

}
