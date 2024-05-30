package com.redweber.mvc;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;

@RestController
@RequestMapping
public class TestController {
    @GetMapping("/welcome")
    public ResponseEntity<byte[]> welcome() {
        try {
            ClassPathResource resource = new ClassPathResource("static/index.html");
            byte[] content = Files.readAllBytes(resource.getFile().toPath());
            return ResponseEntity.ok(content);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
