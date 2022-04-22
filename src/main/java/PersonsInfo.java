public class PersonsInfo {

    public String firstName;
    public String lastName;
    String address;
    String city;
    String state;
    int zip;
    long number;
    String email;

    public PersonsInfo(String name, String readLine, String readLine1, String readLine2, String readLine3, int read, int read1, String readLine4) {
    }

    public PersonsInfo() {

    }

    String getFirstName(){
        return firstName;
    }
    String getLastName(){
        return lastName;
    }
    String getAddress(){

        return address;
    }
    String getCitye(){
        return city;
    }
    String getState(){

        return state;
    }
    int getZip(){
        return zip;
    }
    long getNumber(){

        return number;
    }
    String getEmail(){

        return email;
    }

    public void setFirstName(String next) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
