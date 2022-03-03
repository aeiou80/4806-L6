package davicam.AddressBook;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BuddyInfo {

    @Id
    @GeneratedValue
    private Long id = null;

    private String name;
    private String address;
    private String phoneNumber;

    public BuddyInfo() {
        this.name = "John";
        this.address = "123 Main Street";
        this.phoneNumber = "555-555-5555";
    }

    public BuddyInfo(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "BuddyInfo {" +
                "id = '" + id + "\' " +
                "name = '" + name + "\' " +
                "address = '" + name + "\' " +
                ", phoneNumber = '" + phoneNumber + "\'" +
                '}';
    }


}