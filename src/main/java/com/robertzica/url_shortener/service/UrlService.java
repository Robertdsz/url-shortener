package com.robertzica.url_shortener.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.encoder.QRCode;
import com.robertzica.url_shortener.model.Url;
import com.robertzica.url_shortener.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
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

    public byte[] gerarQrCode(String codigo) throws Exception {
        Url url = repository.findByCodigo(codigo);
        String urlCurta = "http://localhost:8080/" + codigo;

        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(urlCurta, BarcodeFormat.QR_CODE, 300, 300);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);

        return outputStream.toByteArray();
    }
}
