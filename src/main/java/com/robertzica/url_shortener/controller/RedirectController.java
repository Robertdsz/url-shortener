package com.robertzica.url_shortener.controller;

import com.robertzica.url_shortener.model.Url;
import com.robertzica.url_shortener.service.UrlService;
import org.hibernate.usertype.UserVersionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class RedirectController {

    @Autowired
    private UrlService service;

    @GetMapping("/{codigo}")
    public ResponseEntity<Void> redirecionar(@PathVariable String codigo){
        Url urlRedirect = service.procurarUrl(codigo);
        return ResponseEntity.status(302)
                .location(URI.create(urlRedirect.getUrlOriginal()))
                .build();
    }
}
