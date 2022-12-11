package com.AlexandruIacobescu.VotingApplication.repositories;

import com.AlexandruIacobescu.VotingApplication.entities.Member;
import com.AlexandruIacobescu.VotingApplication.enums.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.Optional;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void createMemberTest(){
        Member member = Member.builder()
                .memberId("MaLeMa125478")
                .firstName("Madison")
                .lastName("Leigh")
                .ssn("125-85-9632")
                .joinDate(new Date(100000))
                .email("madisonleigh@yahoo.com")
                .category(Category.MANAGER.name())
                .build();
        memberRepository.save(member);
    }

    @Test
    public void fetchMemberByIdTest(){
        Optional<Member> member = memberRepository.findById("MaLeMa125478");
        if(member.isPresent()){
            System.out.println(member);
        }
        else {
            System.out.println("NO MEMBER WITH ID `" + "AeVnAf901963` FOUND.");
        }
    }
}