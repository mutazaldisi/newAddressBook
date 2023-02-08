package AddressBook;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
public class BuddyInfo {
    @Id
    private long Id;
    private  String firstName;
    private String lastName;

    private  String phoneNumber;

    @ManyToOne
    private AddressBook addressBook;

    public BuddyInfo() {

    }

    public  String getFirstname() {
        return firstName;
    }
    public  void setFirstName(String name) {this.firstName = firstName;}
    public  String getFirstName() {
        return firstName;
    }

    public  String getLastName() {
        return lastName;
    }
    public  void setLastName(String lastName) {this.lastName = lastName;}

    public long getId(){
        return Id;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }


    public AddressBook getAddressBook() {
        return addressBook;
    }

    public void setAddressBook(AddressBook addressBook) {
        this.addressBook = addressBook;
    }

    public BuddyInfo(String firstName,String lastName, String phoneNumber, int Id ){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.Id = Id;

    }

    @Override
    public String toString() {
        return "BuddyInfo{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", Id=" + Id +
                '}';
    }
}