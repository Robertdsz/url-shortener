package com.robertzica.url_shortener.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "urls")
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String urlOriginal;
    private String codigo;
    private LocalDateTime criadoEm;
    private Long acessos;
}
