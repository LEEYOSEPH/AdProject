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
    private String itemNo;
    private String itemName;
    private Integer adultYn;
    private String itemOrgCost;
    private Integer itemActYn;

}
