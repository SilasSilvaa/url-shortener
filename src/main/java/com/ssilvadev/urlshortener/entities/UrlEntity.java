package com.ssilvadev.urlshortener.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "urls")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UrlEntity {

    @Id
    private String id;

    private String fullUrl;

    @Indexed(expireAfter = "60s")
    private LocalDateTime expireAt;
}
