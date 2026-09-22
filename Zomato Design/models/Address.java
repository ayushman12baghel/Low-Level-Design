package models;
public class Address {
    private int id;
    private String street;
    private String city;
    private String state;
    private String pincode;
    private AddressType type;

    public Address(int id, String street, String city, String state, String pincode, AddressType type) {
        this.id = id; this.street = street; this.city = city; this.state = state; this.pincode = pincode; this.type = type;
    }
    public String getStreet() { return street; }
}
