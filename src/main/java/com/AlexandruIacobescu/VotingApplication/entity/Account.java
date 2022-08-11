package com.AlexandruIacobescu.VotingApplication.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "accounts")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Account {

    @Id
    @Column(length = 12)
    private String accountId;
    private String username;
    private String password;

    @OneToOne
    @MapsId
    @JoinColumn(
            name = "member_id"
    )
    private Member member;
}
