package com.PrProcessFlow.PrProcessFlow.Services;

import com.PrProcessFlow.PrProcessFlow.Controller.RequestPrId;
import com.PrProcessFlow.PrProcessFlow.Entity.ImageData;
import com.PrProcessFlow.PrProcessFlow.Repository.PrRepo;
import com.PrProcessFlow.PrProcessFlow.Repository.StorageRepository;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class StorageService {

    @Autowired
    private StorageRepository repository;

    @Autowired
    private PrRepo prRepo;

    private final Cloudinary cloudinary;

    public StorageService() {
        this.cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dq4i7i2d9",
                "api_key", "473918562914612",
                "api_secret", "lndHYmO5KAZ6Ag555VqM0O8cELk"
        ));
    }

    // Upload file to Cloudinary and store metadata in DB
    public String uploadImage(MultipartFile file, String requestId) throws IOException {
        System.out.println(requestId + " in storage services");

        Map uploadResult = cloudinary.uploader().upload(file.getBytes(),
                ObjectUtils.asMap(
                        "resource_type", "raw",   // ✅ Important
                        "type", "upload",         // ✅ Ensures file is PUBLIC
                        "folder", "pr_files"      // (Optional)
                ));

        String url = uploadResult.get("secure_url").toString();

        // Save metadata in DB
        ImageData imageData = repository.save(ImageData.builder()
                .requestId(requestId)
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .url(url)
                .build());

        return url;
    }


    // File: com/PrProcessFlow/PrProcessFlow/Services/StorageService.java

    public ImageData getFileById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("File not found with id: " + id));
    }



    // Fetch all files by RequestId
    public List<ImageData> getImageData(String requestId) {
        return repository.findByRequestId(requestId);
    }
}
