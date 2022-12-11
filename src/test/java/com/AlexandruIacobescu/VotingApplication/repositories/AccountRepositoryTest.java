package com.AlexandruIacobescu.VotingApplication.repositories;

import com.AlexandruIacobescu.VotingApplication.entities.Account;
import com.AlexandruIacobescu.VotingApplication.entities.Member;
import com.AlexandruIacobescu.VotingApplication.enums.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;

@SpringBootTest
class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;
    @Test
    void createAccountTest(){
        Member member = Member.builder()
                .memberId("MoPyMa963258")
                .firstName("Monty")
                .lastName("Python")
                .joinDate(Date.valueOf("2015-08-09"))
                .ssn("951-18-5698")
                .category(Category.SHAREHOLDER.name())
                .email("montyPython@protonmail.com")
                .build();

        Account account = Account.builder()
                .member(member)
                .username("Montypython6601")
                .password("could_have")
                .build();

        accountRepository.save(account);
    }
}