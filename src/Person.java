public class Person {
    private Name fullName;
    private Address address;

    public Person(Name fullName, Address address){
        this.fullName = fullName;
        this.address = address;
    }

    public Name getFullName() {
        return fullName;
    }

    public Address getAddress() {
        return address;
    }
}
