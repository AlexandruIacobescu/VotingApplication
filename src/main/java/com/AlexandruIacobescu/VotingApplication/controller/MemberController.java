package com.AlexandruIacobescu.VotingApplication.controller;

import com.AlexandruIacobescu.VotingApplication.entity.Member;
import com.AlexandruIacobescu.VotingApplication.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @RequestMapping({"id"})
    public Member get(@PathVariable String id){
        return memberRepository.getReferenceById(id);
    }
}
