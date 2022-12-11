package com.AlexandruIacobescu.VotingApplication.repositories;

import com.AlexandruIacobescu.VotingApplication.entities.Query;
import com.AlexandruIacobescu.VotingApplication.enums.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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