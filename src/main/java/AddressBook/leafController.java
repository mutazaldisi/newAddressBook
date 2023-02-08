package AddressBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class leafController {

    @Autowired
    private BuddyInfoRepository buddyInfoRepository;

    @GetMapping("/BuddiesList")
    public String getBuddies( Model model) {
        List<BuddyInfo> buddies = (List<BuddyInfo>) buddyInfoRepository.findAll();
        model.addAttribute("buddies", buddies);
        return "buddies";
    }
}
