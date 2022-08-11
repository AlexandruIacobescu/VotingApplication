package com.AlexandruIacobescu.VotingApplication.controller;

import com.AlexandruIacobescu.VotingApplication.entity.Query;
import com.AlexandruIacobescu.VotingApplication.repository.QueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @RequestMapping({"id"})
    public Query get(@PathVariable Long id){
        return queryRepository.getReferenceById(id);
    }
}
