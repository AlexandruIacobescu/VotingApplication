package com.AlexandruIacobescu.VotingApplication.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "queries")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Query {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long queryId;
    private String text;
    private String accessLevel;

    @Column(columnDefinition = "integer default 0", nullable = false)
    @Builder.Default
    private Integer approves = 0;

    @Column(columnDefinition = "integer default 0", nullable = false)
    @Builder.Default
    private Integer disapproves = 0;
}
