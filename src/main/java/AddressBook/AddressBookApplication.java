package AddressBook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
@SpringBootApplication
public class AddressBookApplication {

    @Autowired
    private static AddressBookRepository addressBookRepository;
    @Autowired
    private static BuddyInfoRepository buddyInfoRepository;

    private static final Logger log = LoggerFactory.getLogger(AddressBookApplication.class);



    public static void main(String[] args) {

        SpringApplication.run(AddressBookApplication.class, args);
    }
    @Bean
    public CommandLineRunner AddressBookdemo(BuddyInfoRepository repository, AddressBookRepository repository1){
        return (args) -> {
            AddressBook addressBook = new AddressBook();
            BuddyInfo buddy = new BuddyInfo("Mutaz","Aldisi" ,"123-22-5", 1);
            BuddyInfo buddy2 = new BuddyInfo("Mo","dc" ,"123-22-5", 2);
            addressBook.addBuddy(buddy);
            addressBook.addBuddy(buddy2);
            repository1.save(addressBook);
            repository.save(buddy);
            repository.save(buddy2);






            // fetch all customers
            log.info("Addressbooks found with findAll():");
            log.info("-------------------------------");
            for (BuddyInfo buddyInfo : repository.findAll()) {
                log.info(buddyInfo.toString());
            }
            log.info("");



            // fetch customers by last name
            log.info("Buddy found with findByLastName('Aldisi'):");
            log.info("--------------------------------------------");
            repository.findByLastName("Aldisi").forEach(Aldisi -> {
                log.info(Aldisi.toString());
            });
            log.info("");
        };


    }






}




