package com.ssilvadev.urlshortener.controller;

import com.ssilvadev.urlshortener.dto.ShortenUrlRequest;
import com.ssilvadev.urlshortener.dto.ShortenUrlResponse;
import com.ssilvadev.urlshortener.service.ShortenUrlService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UrlController {

    private final ShortenUrlService shortenUrlService;

    @PostMapping(value = "/shorten-url")
    public ResponseEntity<ShortenUrlResponse> shortenUrl(@RequestBody ShortenUrlRequest request,
                                           HttpServletRequest servletRequest){

        String redirectUrl = shortenUrlService.shortenUrl(request, servletRequest);

        return ResponseEntity.ok(new ShortenUrlResponse(redirectUrl));
    }

    @GetMapping("{id}")
    public ResponseEntity<Void> redirect(@PathVariable String id){

        HttpHeaders headers = shortenUrlService.redirect(id);

        return ResponseEntity.status(HttpStatus.FOUND).headers(headers).build();
    }
}
