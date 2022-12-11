package com.AlexandruIacobescu.VotingApplication.repositories;

import com.AlexandruIacobescu.VotingApplication.entities.Member;
import com.AlexandruIacobescu.VotingApplication.entities.Query;
import com.AlexandruIacobescu.VotingApplication.entities.Vote;
import com.AlexandruIacobescu.VotingApplication.enums.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;

@SpringBootTest
class VoteRepositoryTest {

    @Autowired
    VoteRepository voteRepository;

    @Test
    public void createVoteTest(){
        Member member = Member.builder()
                .memberId("SaCoDi874521")
                .firstName("Cohen")
                .lastName("Sander")
                .ssn("965-08-7412")
                .joinDate(Date.valueOf("2012-08-07"))
                .email("sandercohen@yahoo.com")
                .category(Category.DIRECTOR.name())
                .build();
        Query query = Query.builder()
                .text("Fusce erat leet, commodo a enim. Aenean eu rhoncus ipsum, gravida finibus elit?")
                .accessLevel(Category.DIRECTOR.name())
                .build();

        Vote vote = Vote.builder()
                .member(member)
                .query(query)
                .build();
        voteRepository.save(vote);
    }
}