package com.AlexandruIacobescu.VotingApplication.repositories;

import com.AlexandruIacobescu.VotingApplication.entities.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends JpaRepository<Vote,Long> {

    @Query(
            value = "INSERT INTO votes(member_id, query_id) VALUES(?1,?2)",
            nativeQuery = true
    )
    void voteIfAllowed(String memberId, Long queryId);
}
