package AddressBook;

//import javax.persistence.*;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {

    @Id
    @GeneratedValue
    private long id;
    private String addressBookName;

    @OneToMany(mappedBy = "addressBook", cascade = CascadeType.ALL)
    public static List<BuddyInfo> addressBook;

    public AddressBook(){
        addressBook = new ArrayList<>();
    }
    public AddressBook(String addressBookName, List<BuddyInfo> addressBook){
        this.addressBookName = addressBookName;
        this.addressBook = addressBook;
    }

    public String getAddressBookName(){
        return addressBookName;
    }
    public void setId(){
        this.id = id;
    }
    public long getId(){
        return id;
    }

    public void addBuddy(BuddyInfo buddyInfo){
        addressBook.add(buddyInfo);
        buddyInfo.setAddressBook(this);
    }

    public void removeBuddy(BuddyInfo buddyInfo){
        addressBook.remove(buddyInfo);
    }

    public String getAllBuddies(){
        String buddies = new String();
        for(int i = 0 ; i < addressBook.size(); i++){
            buddies += addressBook.get(i);
        }
        return buddies;
    }



    @Override
    public String toString() {
        return "Address Book " + this.id + "Buddies: "+ getAllBuddies();
        }


}

