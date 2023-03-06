package com.edu.project.entity;

import com.edu.project.request.KwdRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class Kwd {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long kwdId;
    private String kwdName;
    private String sellPossKwdYn;
    private String manualCnrKwdYn;

    @Builder
    public Kwd(String kwdName) {
        this.kwdName = kwdName;
        this.sellPossKwdYn = "Y";
        this.manualCnrKwdYn = "N";
    }

    public Kwd addKwd(KwdRequestDto kwdRequestDto) {
        return Kwd.builder()
                .kwdName(kwdRequestDto.getKwdName())
                .build();
    }

}
