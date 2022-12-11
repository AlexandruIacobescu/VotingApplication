package com.AlexandruIacobescu.VotingApplication.services;

import com.AlexandruIacobescu.VotingApplication.entities.Query;
import com.AlexandruIacobescu.VotingApplication.repositories.QueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueryService {

    @Autowired
    private QueryRepository queryRepository;

    public List<Query> getAllowedQueries(final String id){
        return queryRepository.getAllowedQueriesForMemberId(id);
    }
}
