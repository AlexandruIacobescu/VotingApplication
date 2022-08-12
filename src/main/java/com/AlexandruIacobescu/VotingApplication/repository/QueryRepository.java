package com.AlexandruIacobescu.VotingApplication.repository;

import com.AlexandruIacobescu.VotingApplication.entity.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QueryRepository extends JpaRepository<Query,Long> {

    @org.springframework.data.jpa.repository.Query(
            "SELECT q FROM queries AS q WHERE q.accessLevel = (SELECT m.category FROM members AS m WHERE m.memberId = :memberId)"
    )
    List<Query> getAllowedQueriesForMemberId(String memberId);

}
