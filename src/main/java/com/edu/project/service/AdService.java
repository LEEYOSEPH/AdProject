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
    *  광고 등록
    * */
    public void postAd(AdRequestDto requestDto) {
        AD save = adRepository.save( new AD().addAd(requestDto));
        Long adId = save.getAdId();

        List<KwdRequestDto> list = requestDto.getKWds().stream().map(KwdRequestDto::new).collect(Collectors.toList());
        if(list.size() > 0) {
            list.forEach(kwdRequestDto ->  {
                // 키워드명 테이블에 존재 하는지 조회
                Optional<Kwd> optionalKwd = kwdRepository.findByKwdName(kwdRequestDto.getKwdName());
                if(optionalKwd.isEmpty()) {
                    // 키워드명 존재하지 않으면 신규 등록
                    Kwd kwd = kwdRepository.save(new Kwd().addKwd(kwdRequestDto));
                    Long kwdId = kwd.getKwdId();
                    // 직접광고 상세등록 키워드 포함
                    addDadDetKwd(adId,kwdId, kwdRequestDto.getBidCost());
                }else {
                    // 키워드명 존재하면 기존 키워드를 등록
                    addDadDetKwd(adId,optionalKwd.get().getKwdId(), kwdRequestDto.getBidCost());
                }
            });
        }else {
            // 직접광고 상세등록
            addDadDet(adId);
        }
    }

    /*
    *  광고가 등록된 상품인지 조회
    * */
    public ItemIdResponseDto getItemId(Long itemId) {
        return adRepository.findByItemId(itemId);
    }

    /*
    *  직접 광고 상세 등록 키워드 제외
    * */
    public void addDadDet(Long adId) {
        dadDetRepository.save(new DadDet().addDadDet(adId));
    }

    /*
    *  직접 광고 상세 등록 키워드 포함
    * */
    public void addDadDetKwd(Long adId, Long kwdID,int bidCost){
        DadDet dadDet = dadDetRepository.save(new DadDet().addDadDetKwd(adId, kwdID));
        Long dadDetId = dadDet.getDadDetId();
        addDadDetBid(dadDetId,bidCost);
    }
    
    /*
    *  직접 광고 상세 등록 입찰 금액 등록
    * */
    public void addDadDetBid(Long dadDetId, int bidCost){
        dadDetBidRepository.save(new DadDetBid().addDadDetBid(dadDetId, bidCost));
    }
}
