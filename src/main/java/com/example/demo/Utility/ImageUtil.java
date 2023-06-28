package com.example.demo.Utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ImageUtil {
    @Value("${image.upload.directory}")
    private String imageUploadDirectory;

    public String saveImage(String imageData) throws IOException {
        String fileName = UUID.randomUUID().toString() + ".jpg";
        Path imagePath = Paths.get(imageUploadDirectory, fileName);
        byte[] decodedImageData = Base64.getDecoder().decode(imageData);
        Files.write(imagePath, decodedImageData);
        return fileName;
    }

    public String encodeImageAsBase64String(String fileName) throws IOException {
        byte[] imageBytes = Files.readAllBytes(Path.of(imageUploadDirectory, fileName));
        return Base64.getEncoder().encodeToString(imageBytes);
    }

    public String getFileNameFromPath(String imagePath) {
        if (imagePath == null || imagePath.isEmpty()) {
            return "";
        }
        return Paths.get(imagePath).getFileName().toString();
    }
}