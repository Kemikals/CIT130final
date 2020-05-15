package final2point0;

public class Adopters {

    private String firstName;
    private String lastName;
    private String address;
    private int age;

    public Adopters() {
    }

    public Adopters(String firstName, String lastName, int age, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
        
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public int age() {
        return age;
    }

    // End getters

    // Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // End setters


    @Override
    public String toString() {
        return "Name: " + firstName + "\nLast Name: " + lastName
                + "\nAddress: " + address + "\nAge: " + age;
    }

}
