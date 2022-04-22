import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) throws IOException {
    AddressBook addressBook = new AddressBook();
    addressBook.addPerson();
    addressBook.show();
    addressBook.delete();
    addressBook.update();
    }
}
