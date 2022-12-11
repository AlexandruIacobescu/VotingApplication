package com.AlexandruIacobescu.VotingApplication.controllers;

import com.AlexandruIacobescu.VotingApplication.entities.Vote;
import com.AlexandruIacobescu.VotingApplication.repositories.MemberRepository;
import com.AlexandruIacobescu.VotingApplication.repositories.VoteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/v1/votes"})
public class VoteController {

    @Autowired
    private VoteRepository voteRepository;
    @Autowired
    private MemberRepository memberRepository;

    @GetMapping
    public List<Vote> get(){
        return voteRepository.findAll();
    }

    @GetMapping
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Vote get(@PathVariable Long id){
        return voteRepository.getOne(id);
    }

    @PostMapping
    public Vote create(@RequestBody final Vote vote){
        return voteRepository.saveAndFlush(vote);
    }

    /*@PostMapping(value = "/add_vote/{memberId}/{queryId}")
    public Optional<Vote> addVote(@PathVariable String memberId, @PathVariable Long queryId){
        Optional<Member> member = memberRepository.findById(memberId);
        voteRepository.save(Vote.builder().member(member).query().build());
        return voteRepository.findById(queryId);
    }*/

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        voteRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Vote update(@PathVariable Long id, @PathVariable Vote vote){
        //TODO: Add validation that all attributes are passed in, otherwise return a 404 bad payload
        Vote existingVote = voteRepository.getReferenceById(id);
        BeanUtils.copyProperties(vote, existingVote, "voteId");
        return voteRepository.saveAndFlush(existingVote);
    }
}
