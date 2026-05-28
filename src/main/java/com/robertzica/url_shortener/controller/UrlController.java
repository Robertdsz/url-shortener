package com.robertzica.url_shortener.controller;


import com.robertzica.url_shortener.model.Url;
import com.robertzica.url_shortener.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/url")
public class UrlController {

    @Autowired
    private UrlService service;

    @PostMapping("/encurtar")
    public Url encurtar(@RequestBody String urlOriginal) {
        return service.encurtarUrl(urlOriginal);
    }
}
