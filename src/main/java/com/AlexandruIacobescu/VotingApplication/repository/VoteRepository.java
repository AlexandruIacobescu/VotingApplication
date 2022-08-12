package com.AlexandruIacobescu.VotingApplication.repository;

import com.AlexandruIacobescu.VotingApplication.entity.Vote;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends JpaRepository<Vote,Long> {

}
