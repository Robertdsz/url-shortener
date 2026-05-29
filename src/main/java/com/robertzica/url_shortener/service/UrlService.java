package com.robertzica.url_shortener.service;

import com.robertzica.url_shortener.model.Url;
import com.robertzica.url_shortener.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UrlService {

    @Autowired
    private UrlRepository repository;

    public Url encurtarUrl(String urlOriginal) {
        Url url = new Url();
        url.setUrlOriginal(urlOriginal);
        url.setCodigo(UUID.randomUUID().toString().substring(0, 6));
        url.setCriadoEm(LocalDateTime.now());
        url.setAcessos(0L);
        return repository.save(url);
    }

    public Url procurarUrl(String codigo) {
        Url url = repository.findByCodigo(codigo);
        url.setAcessos(url.getAcessos() + 1);
        return repository.save(url);
    }
}
