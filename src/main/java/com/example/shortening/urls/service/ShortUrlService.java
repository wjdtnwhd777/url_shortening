package com.example.shortening.urls.service;

import com.example.shortening.common.Base62;
import com.example.shortening.urls.entity.ShortUrls;
import com.example.shortening.urls.repository.ShortUrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicReference;

@Service
@RequiredArgsConstructor
public class ShortUrlService {

    private final ShortUrlRepository shortUrlRepository;

    public ShortUrls retrieveInfoShotUrl(String hashUrl) {
        return shortUrlRepository.findById(Base62.decoding(hashUrl)).orElseThrow();
    }

    public String conversionShotUrl(String orgUrl) {

        AtomicReference<String> result = new AtomicReference<>();

        shortUrlRepository.findByOrgUrl(orgUrl).ifPresentOrElse(
                shortUrls -> {
                    if(shortUrlRepository.incrementCallCount(shortUrls.getUid()) > 0){
                        result.set(Base62.encoding(Math.toIntExact(shortUrls.getUid())));
                    }
                    else {
                        new Exception("조회수 증가 실패");
                    }
                },
                () -> { //else
                    ShortUrls shortUrls = shortUrlRepository.saveAndFlush(
                            ShortUrls.builder()
                                    .orgUrl(orgUrl)
                                    .callCount(1)
                                    .build()
                    );

                    result.set(Base62.encoding(Math.toIntExact(shortUrls.getUid())));
                }
        );

        return result.get();
    }

    /**
     * 입력받은 HashUrl을 decoding 후 OriginUrl Return
     * @param hashUrl
     * @return orgUrl
     */
    public String retrieveHashUrl(String hashUrl) {

        //검색 실패시 error 페이지 보여줌
        AtomicReference<String> orgUrl = new AtomicReference<>("/error");

        shortUrlRepository.findById(Base62.decoding(hashUrl)).ifPresent(
                shortUrls -> {
                    orgUrl.set(shortUrls.getOrgUrl());
                }
        );

        return orgUrl.get();
    }
}
