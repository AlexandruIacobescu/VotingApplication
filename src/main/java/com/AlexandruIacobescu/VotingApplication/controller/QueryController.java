package com.AlexandruIacobescu.VotingApplication.controller;

import com.AlexandruIacobescu.VotingApplication.entity.Query;
import com.AlexandruIacobescu.VotingApplication.repository.QueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/queries")
public class QueryController {

    @Autowired
    private QueryRepository queryRepository;

    @GetMapping
    public List<Query> list(){
        return queryRepository.findAll();
    }

    @GetMapping
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Query get(@PathVariable Long id){
        return queryRepository.getReferenceById(id);
    }

    @GetMapping
    @RequestMapping(value = "/allowed_queries/{id}", method = RequestMethod.GET)
    public List<Query> get(@PathVariable String id){
        return queryRepository.getAllowedQueriesForMemberId(id);
    }
}
