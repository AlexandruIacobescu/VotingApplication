package com.AlexandruIacobescu.VotingApplication.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity(name = "members")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "account")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Member {

    @Id
    @Column(length = 12)
    private String memberId;
    private String firstName;
    private String lastName;
    private String ssn;
    private Date joinDate;
    private String email;
    private String category;

    @OneToOne(
            mappedBy = "member",
            cascade = CascadeType.ALL
    )
    @PrimaryKeyJoinColumn
    private Account account;
}
