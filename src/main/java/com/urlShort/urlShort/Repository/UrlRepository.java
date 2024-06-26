package com.urlShort.urlShort.Repository;

import com.urlShort.urlShort.Entity.Url;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepository extends JpaRepository<Url, Long> {
    Url findByShortUrl(String shortUrl);
}
