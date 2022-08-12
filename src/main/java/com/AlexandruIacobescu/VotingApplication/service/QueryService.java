package com.AlexandruIacobescu.VotingApplication.service;

import com.AlexandruIacobescu.VotingApplication.entity.Query;
import com.AlexandruIacobescu.VotingApplication.repository.QueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class QueryService {

    @Autowired
    private QueryRepository queryRepository;

    public List<Query> getAllowedQueries(final String id){
        return queryRepository.getAllowedQueriesForMemberId(id);
    }
}
