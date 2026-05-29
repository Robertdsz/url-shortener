package com.robertzica.url_shortener.controller;


import com.robertzica.url_shortener.model.Url;
import com.robertzica.url_shortener.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/url")
public class UrlController {

    @Autowired
    private UrlService service;

    @PostMapping("/encurtar")
    public Url encurtar(@RequestBody String urlOriginal) {
        return service.encurtarUrl(urlOriginal);
    }

    @GetMapping("/{codigo}")
    public Url procurar(@PathVariable String codigo) {
        return service.procurarUrl(codigo);
    }
}
