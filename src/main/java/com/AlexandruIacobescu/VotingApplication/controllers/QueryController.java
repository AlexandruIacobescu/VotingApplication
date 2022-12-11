package com.AlexandruIacobescu.VotingApplication.controllers;

import com.AlexandruIacobescu.VotingApplication.entities.Query;
import com.AlexandruIacobescu.VotingApplication.repositories.QueryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping
    public Query create(@RequestBody final Query query){
        return queryRepository.saveAndFlush(query);
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

    @RequestMapping(value = "{id}/{query}", method = RequestMethod.PUT)
    public Query update(@PathVariable Long id, @PathVariable Query query){
        //TODO: Add validation that all attributes are passed in, otherwise return a 404 bad payload
        Query existingQuery = queryRepository.getReferenceById(id);
        BeanUtils.copyProperties(query, existingQuery, "voteId");
        return queryRepository.saveAndFlush(existingQuery);
    }
}
