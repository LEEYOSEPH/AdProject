package com.edu.project.entity;

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
    private String roleGroup;
}
