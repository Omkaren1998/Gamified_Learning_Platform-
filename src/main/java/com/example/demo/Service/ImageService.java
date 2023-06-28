package com.example.demo.Service;
import com.example.demo.Repository.ImageRepository;
import com.example.demo.model.Image;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public String saveImage(MultipartFile file) throws IOException {

        Image image = new Image();
        image.setName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setData(file.getBytes());

        Image savedImage = imageRepository.save(image);
        return savedImage.getId();
    }

    public Image getImage(String id) {
        return imageRepository.findById(id).orElse(null);
    }

    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }
}
