package com.edu.project.service;

import com.edu.project.entity.AD;
import com.edu.project.entity.DadDet;
import com.edu.project.entity.DadDetBid;
import com.edu.project.entity.Kwd;
import com.edu.project.repository.AdRepository;
import com.edu.project.repository.DadDetBidRepository;
import com.edu.project.repository.DadDetRepository;
import com.edu.project.repository.KwdRepository;
import com.edu.project.request.AdRequestDto;
import com.edu.project.request.KwdRequestDto;
import com.edu.project.response.ItemIdResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdService {

    private final AdRepository adRepository;
    private final KwdRepository kwdRepository;
    private final DadDetRepository dadDetRepository;
    private final DadDetBidRepository dadDetBidRepository;


    /*
     *  등록된 광고 상품인지 조회
     * */
    public ItemIdResponseDto getItemId(Long itemId) {
        return adRepository.findByItemId(itemId);
    }

    /*
    *  광고 등록
    * */
    public void postAd(AdRequestDto requestDto) {
        Long adId = adRepository.save(new AD().addAd(requestDto)).getAdId();
        // 키워드 등록
        addKwd(adId,requestDto);
    }

    /*
    *  키워드 등록
    * */
    public void addKwd(Long adId, AdRequestDto requestDto) {
        
        // 클라이언트에서 넘어온 키워드 명이 있는지 확인하고 있으면, 디비에서 조회 후 신규 등록 하거나, 기존 키워드 아이디를 넘겨주기
        List<KwdRequestDto> list = requestDto.getKWds().stream().map(KwdRequestDto::new).collect(Collectors.toList());
        if(!list.isEmpty()) {
            list.forEach(kwdRequestDto ->  {
                // 키워드명 테이블에 존재 하는지 개별조회
                Optional<Kwd> optionalKwd = kwdRepository.findByKwdName(kwdRequestDto.getKwdName());
                int bidCost = kwdRequestDto.getBidCost();
                if(optionalKwd.isEmpty()) {
                    // 키워드명 존재하지 않으면 신규 등록
                    Long kwdId = kwdRepository.save(new Kwd().addKwd(kwdRequestDto)).getKwdId();
                    // 직접광고 상세등록 키워드 포함
                    addDadDetKwd(adId,kwdId,bidCost);
                }else {
                    // 키워드명 존재하면 기존 키워드를 등록
                    addDadDetKwd(adId,optionalKwd.get().getKwdId(), bidCost);
                }
            });
        }else {
            // 직접광고 상세등록
            addDadDet(adId);
        }
    }

    /*
    *  직접 광고 상세 등록 - 키워드 제외
    * */
    public void addDadDet(Long adId) {
        dadDetRepository.save(new DadDet().addDadDet(adId));
    }

    /*
    *  직접 광고 상세 등록 - 키워드 포함
    * */
    public void addDadDetKwd(Long adId, Long kwdID,int bidCost){
        Long dadDetId = dadDetRepository.save(new DadDet().addDadDetKwd(adId, kwdID)).getDadDetId();
        //직접 광고 상세 등록 입찰 금액 등록
        addDadDetBid(dadDetId,bidCost);
    }
    
    /*
    *  직접 광고 상세 등록 입찰 금액 등록
    * */
    public void addDadDetBid(Long dadDetId, int bidCost){
        dadDetBidRepository.save(new DadDetBid().addDadDetBid(dadDetId, bidCost));
    }
}
