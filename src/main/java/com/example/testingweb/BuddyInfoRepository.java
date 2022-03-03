package com.example.testingweb;

import org.springframework.data.jpa.repository.JpaRepository;

interface BuddyInfoRepository extends JpaRepository<BuddyInfo, Long> {

}