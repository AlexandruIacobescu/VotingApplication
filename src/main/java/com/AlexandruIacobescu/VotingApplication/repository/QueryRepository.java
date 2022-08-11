package com.AlexandruIacobescu.VotingApplication.repository;

import com.AlexandruIacobescu.VotingApplication.entity.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueryRepository extends JpaRepository<Query,Long> {
}
