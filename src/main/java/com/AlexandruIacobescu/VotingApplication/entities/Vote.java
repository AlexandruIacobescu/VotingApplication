package com.AlexandruIacobescu.VotingApplication.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "votes")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Vote {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long voteId;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "member_id",
            referencedColumnName = "memberId"
    )
    private Member member;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "query_id",
            referencedColumnName = "QueryId"
    )
    private Query query;
}
