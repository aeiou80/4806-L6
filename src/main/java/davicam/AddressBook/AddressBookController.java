package davicam.AddressBook;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class AddressBookController {

    private final AddressBookRepository addressBookRepo;

    AddressBookController(AddressBookRepository repository) {
        this.addressBookRepo = repository;
    }

    @GetMapping("/")
    public String spa(Model model) {
        return "spa";
    }

    @GetMapping("/newaddressbook")
    public String addressBookform(Model model) {
        return "addressBookForm";
    }

    @GetMapping("/thisaddressbook/{id}")
    public String listBuddies(Model model, @PathVariable Long id) {
        model.addAttribute("buddy", new BuddyInfo());
        model.addAttribute("id", id);
        AddressBook book = addressBookRepo.findById(id).get();
        model.addAttribute("buddies", book.toString());
        return "buddyForm";
    }

    @PostMapping("/newaddressbook")
    public RedirectView addressBookFormSubmit(Model model) {
        AddressBook ab = new AddressBook();
        addressBookRepo.save(ab);
        Long id = ab.getId();
        model.addAttribute("buddy", new BuddyInfo());
        model.addAttribute("id", id);
        model.addAttribute("buddies", ab.toString());
        return new RedirectView("/thisaddressbook/" + id);
    }

    @PostMapping("/newbuddy/{id}")
    public RedirectView buddyformSubmit(@ModelAttribute BuddyInfo buddy, @PathVariable Long id, Model model) {
        AddressBook book = addressBookRepo.findById(id).get();
        book.addBuddyInfo(buddy);
        addressBookRepo.save(book);
        model.addAttribute("buddy", new BuddyInfo());
        model.addAttribute("id", id);
        model.addAttribute("buddies", book.toString());
        return new RedirectView("/thisaddressbook/"+id);
    }

}
