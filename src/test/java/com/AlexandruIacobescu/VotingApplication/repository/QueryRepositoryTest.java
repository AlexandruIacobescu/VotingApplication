package com.AlexandruIacobescu.VotingApplication.repository;

import com.AlexandruIacobescu.VotingApplication.entity.Query;
import com.AlexandruIacobescu.VotingApplication.pojo.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
}