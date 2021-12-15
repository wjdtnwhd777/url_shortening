package com.example.shortening.urls.payload.request;

import lombok.Data;

import javax.validation.constraints.Pattern;

@Data
public class ShortUrlRequest {

    @Pattern(regexp = "^(https?)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]", message = "올바르지 않은 URL 입니다.")
    private String orgUrl;

    private String hashUrl;

}
