package com.edu.project.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Getter
@NoArgsConstructor
public class CnrReq {

    private Long cnrReqId; // 검수요청 아이디
    private String cnrIngStatus; // 검수진행 상태
    private String cnrInputDiv; // 검수입력 구분
    private Date cnrReqTime; // 검수 요청시간
    private Date cnrProcTime; // 검수 처리시간
    private Integer cnrCompleteYn; // 검수 완료 여부
    private String cnrFailCause; // 검수 실패사유
    private String cnrFailComt; // 검수 실패 코멘트
}
