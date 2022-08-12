package com.AlexandruIacobescu.VotingApplication.repository;

import com.AlexandruIacobescu.VotingApplication.entity.Query;
import com.AlexandruIacobescu.VotingApplication.pojo.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class QueryRepositoryTest {

    @Autowired
    private QueryRepository queryRepository;

    @Test
    public void createQueryTest(){
        Query query = Query.builder()
                .text("Fusce erat leo, dapibus at dapibus eget, commodo a enim. Aenean eu rhoncus ipsum, gravida finibus elit?")
                .accessLevel(Category.MANAGER.name())
                .build();

        queryRepository.save(query);
    }

    @Test
    public void getQueriesAllowedForMemberId(){
        List<Query> queries = queryRepository.getAllowedQueriesForMemberId("SaCoDi874521");
        System.out.println(queries);
    }
}