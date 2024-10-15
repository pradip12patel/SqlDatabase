package com.example.SqlServer.ontroller;


import com.example.SqlServer.seriveImpl.QRCodeGeneratorService;
import com.google.zxing.WriterException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RequestMapping("/api")
@RestController
public class QRCodeController {

    
 @Autowired
private QRCodeGeneratorService qrCodeGeneratorService;

//@GetMapping(value = "/qrcode/{content}", produces = MediaType.IMAGE_PNG_VALUE)
//public byte[] generateQrCode(@PathVariable String content) throws IOException {
//    int width = 200; // Adjust the desired width of the QR code
//    int height = 200; // Adjust the desired height of the QR code
//    return qrCodeGeneratorService.generateQrCodeImage(content, width, height);
//}
}
