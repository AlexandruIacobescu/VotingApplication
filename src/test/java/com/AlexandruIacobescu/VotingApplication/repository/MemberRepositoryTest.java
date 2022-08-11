package com.AlexandruIacobescu.VotingApplication.repository;

import com.AlexandruIacobescu.VotingApplication.entity.Member;
import com.AlexandruIacobescu.VotingApplication.pojo.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sound.midi.MetaMessage;

import java.sql.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

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