package com.AlexandruIacobescu.VotingApplication.repository;

import com.AlexandruIacobescu.VotingApplication.entity.Account;
import com.AlexandruIacobescu.VotingApplication.entity.Member;
import com.AlexandruIacobescu.VotingApplication.pojo.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

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