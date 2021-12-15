package com.example.shortening.urls.controller;

import com.example.shortening.urls.payload.request.ShortUrlRequest;
import com.example.shortening.urls.service.ShortUrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shortUrl")
public class ShortUrlController {

    private final ShortUrlService service;

    /**
     * Shortening 처리 및 저장
     * @param request
     * @return 생성된 hashUrl
     */
    @PostMapping("/conversion")
    public ResponseEntity<?> makeShotUrl(@RequestBody @Valid ShortUrlRequest request){
        return ResponseEntity.ok(service.conversionShotUrl(request.getOrgUrl()));
    }

    /**
     * 동일한 URL 호출 정보 조회
     * @param request
     * @return ShotUrls
     */
    @PostMapping("/info")
    public ResponseEntity<?> retrieveInfoShotUrl(@RequestBody @Valid ShortUrlRequest request){
        return ResponseEntity.ok(service.retrieveInfoShotUrl(request.getHashUrl()));
    }


}
