package com.example.testingweb;

import org.springframework.data.jpa.repository.JpaRepository;

interface AddressBookRepository extends JpaRepository<AddressBook, Long> {

}