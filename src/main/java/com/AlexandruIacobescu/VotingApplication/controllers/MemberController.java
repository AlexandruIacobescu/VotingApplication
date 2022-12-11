package com.AlexandruIacobescu.VotingApplication.controllers;

import com.AlexandruIacobescu.VotingApplication.entities.Member;
import com.AlexandruIacobescu.VotingApplication.repositories.MemberRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/v1/members"})
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping
    public List<Member> get(){
        return memberRepository.findAll();
    }

    @GetMapping
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Member get(@PathVariable String id){
        return memberRepository.getOne(id);
    }

    @PostMapping
    public Member create(@RequestBody final Member member){
        return memberRepository.saveAndFlush(member);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id){
        // Watch out for cascading entries
        memberRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Member update(@PathVariable String id, @PathVariable Member member){
        //TODO: Add validation that all attributes are passed in, otherwise return a 404 bad payload
        Member existingMember = memberRepository.getOne(id);
        BeanUtils.copyProperties(member, existingMember, "memberId");
        return memberRepository.saveAndFlush(existingMember);
    }
}
