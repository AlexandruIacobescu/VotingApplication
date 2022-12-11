package com.AlexandruIacobescu.VotingApplication.repositories;

import com.AlexandruIacobescu.VotingApplication.entities.Query;
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
