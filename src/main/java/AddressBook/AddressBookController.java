package AddressBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressBookController {


    @Autowired
    private AddressBookRepository repository;
    @Autowired
    private BuddyInfoRepository buddyInfoRepository;

    public AddressBookController(AddressBookRepository repository, BuddyInfoRepository buddyInfoRepository){
        this.repository= repository;
        this.buddyInfoRepository = buddyInfoRepository;
    }



    @RequestMapping("/")
    public String sayHi(){
        return "Hello Mutaz, Welcome to AddressBoook";
    }

    @PostMapping("/addressbook")
    public AddressBook addressBookCreate(@ModelAttribute("ab") AddressBook addressBook, Model model){//, final RedirectAttributes rdAtt)
        model.addAttribute("addressBook", addressBook);
        return repository.save(addressBook);

    }

    @PostMapping("/buddyInfo/{addressBookId}")
    public BuddyInfo addBuddy(@RequestBody BuddyInfo buddy, @PathVariable Long addressBookId) {
        AddressBook addressBook = repository.findById(Math.toIntExact(addressBookId)).get();
        addressBook.addBuddy(buddy);
        repository.save(addressBook);
        return buddyInfoRepository.save(buddy);
//        return repository.save(addressBook);

    }







}





