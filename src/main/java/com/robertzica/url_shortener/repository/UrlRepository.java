package com.robertzica.url_shortener.repository;

import com.robertzica.url_shortener.model.Url;
import lombok.Data;
import lombok.Getter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepository extends JpaRepository<Url, Long> {
    Url findByCodigo(String codigo);
}
