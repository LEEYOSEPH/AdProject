package com.edu.project.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Item {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;
    private Long itemNo;
    private String itemName;
    private String AdultYn;
    private String itemOrgCost;
    private String itemActYn;

}
