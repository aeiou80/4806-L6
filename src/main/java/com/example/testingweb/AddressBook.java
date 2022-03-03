package com.example.testingweb;

import javax.persistence.*;
import java.util.*;

@Entity
public class AddressBook {

    @Id
    @GeneratedValue
    private Long id = null;

    @OneToMany(cascade = CascadeType.ALL)
    private Collection<BuddyInfo> buddyInfos;

    public AddressBook() {
        this.buddyInfos = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void addBuddyInfo(BuddyInfo bud) {
        this.buddyInfos.add(bud);
    }

    public void removeBuddyInfo(String name) {
        for (BuddyInfo b : buddyInfos) {
            if (b.getName().equals(name)) {
                buddyInfos.remove(b);
                break;
            }
        }
    }

    public BuddyInfo getBuddyInfo(String name) {
        for (BuddyInfo b : buddyInfos) {
            if (b.getName().equals(name))
                return b;
        }
        return null;
    }

    public Collection<BuddyInfo> getBuddyInfos() {
        return buddyInfos;
    }

    public int getSize() {
        return this.buddyInfos.size();
    }

    public String toString() {
        String s = "AddressBook{" + "buddies=";
        for (BuddyInfo buddy: buddyInfos) {
            s += buddy.toString() + "\n";
        }
        return s + '}';
    }

}
