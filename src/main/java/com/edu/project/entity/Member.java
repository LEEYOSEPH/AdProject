package com.edu.project.entity;

import com.edu.project.enums.Authority;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id
    @Column(name = "member_id")
    private String memberId;
    private String pwd;
    @Enumerated(EnumType.STRING)
    private Authority roleGroup;

    @PrimaryKeyJoinColumn
    @OneToOne(mappedBy = "member")
    @JsonManagedReference
    private Adv adv;


    @Builder
    public Member( String memberId, String pwd,Authority roleGroup) {
        this.memberId = memberId;
        this.pwd = pwd;
        this.roleGroup = roleGroup;
    }
}
