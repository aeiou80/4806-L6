package com.example.testingweb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressBookRestController {

    private final AddressBookRepository addressBookRepo;

    AddressBookRestController(AddressBookRepository repository) {
        this.addressBookRepo = repository;
    }

    @PostMapping("/addressbook")
    AddressBook newAddressbook(/*@RequestBody BuddyInfo buddy*/) {
        AddressBook addressBook = new AddressBook();
        return addressBookRepo.save(addressBook);
    }

    @GetMapping("/addressbook/{id}")
    AddressBook getAddressBookById(@PathVariable Long id) {
        return addressBookRepo.findById(id).get();
    }

    @PostMapping("/addressbook/{id}")
    AddressBook addBuddyInfo(@RequestBody BuddyInfo newBuddy, @PathVariable Long id) {
        AddressBook addressBook = addressBookRepo.findById(id).get();
        addressBook.addBuddyInfo(newBuddy);
        return addressBookRepo.save(addressBook);
    }

}