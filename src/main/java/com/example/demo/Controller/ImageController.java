package com.example.demo.Controller;

import java.io.IOException;
import java.util.List;
import org.springframework.http.HttpHeaders;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Service.ImageService;
import com.example.demo.model.Image;

@RestController
@RequestMapping("/images")
@CrossOrigin(origins = "http://localhost:5174")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/save")
    public String uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        return imageService.saveImage(file);
    }

    @GetMapping("/image/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable("id") String id) {

        Image image = imageService.getImage(id);

        if (image != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType(image.getContentType()));
            headers.setContentLength(image.getSize());
            headers.setContentDispositionFormData("attachment", image.getName());
            return new ResponseEntity<byte[]>(image.getData(), headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAll")
    public List<Image> getAllImages() {
        return imageService.getAllImages();
    }
}
