package com.ssilvadev.urlshortener.service;

import com.ssilvadev.urlshortener.dto.ShortenUrlRequest;
import com.ssilvadev.urlshortener.entities.UrlEntity;
import com.ssilvadev.urlshortener.infra.NotFoundException;
import com.ssilvadev.urlshortener.repository.UrlRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShortenUrlService {

    private final UrlRepository urlRepository;


    public String shortenUrl(ShortenUrlRequest request, HttpServletRequest servletRequest){
        String id;

        do{
            id = RandomStringUtils.randomAlphanumeric(5, 10);
        } while (urlRepository.existsById(id));

        urlRepository.save(new UrlEntity(id, request.url(), LocalDateTime.now().plusMinutes(1)));

        return servletRequest.getRequestURL().toString().replace("shorten-url", id);
    }

    public HttpHeaders redirect(String id){
        Optional<UrlEntity> url = urlRepository.findById(id);

        if(url.isEmpty()){
            throw new NotFoundException("Url not found");
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(url.get().getFullUrl()));

        return headers;
    }
}
