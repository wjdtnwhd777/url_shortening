package com.example.shortening.urls.controller;

import com.example.shortening.urls.service.ShortUrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class RedirectController {

    private final ShortUrlService shortUrlService;

    @RequestMapping("/{hashUrl}")
    public String redirect(@PathVariable String hashUrl) {
        return "redirect:" + shortUrlService.retrieveHashUrl(hashUrl);
    }

}
