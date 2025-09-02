package com.PrProcessFlow.PrProcessFlow.Services;


import com.PrProcessFlow.PrProcessFlow.Entity.ImageData;
import com.PrProcessFlow.PrProcessFlow.Repository.PrRepo;
import com.PrProcessFlow.PrProcessFlow.Repository.StorageRepository;
import com.PrProcessFlow.PrProcessFlow.util.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StorageService {

    @Autowired
    private StorageRepository repository;

    @Autowired
    private PrRepo prRepo;

    public String uploadImage(MultipartFile file) throws IOException {
        String requestId = generateRequestId();
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());
        System.out.println(file.getContentType());
        ImageData imageData = repository.save(ImageData.builder()
                .requestId(requestId)
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtils.compressImage(file.getBytes())).build());




        if (imageData != null) {
            return "file uploaded successfully : " + file.getOriginalFilename();
        }
        return "file not uploaded ";
    }



    private String generateRequestId() {
        Date now = new Date();
        String month = new SimpleDateFormat("MMM").format(now).toUpperCase(); // AUG
        String year = new SimpleDateFormat("yy").format(now); // 25

        long count = prRepo.countCurrentMonthEntries() + 1;
        String sequence = String.format("%03d", count);
        return String.format("REQ/%s%s/%s", month, year, sequence);
    }

    public byte[] downloadImage(String fileName){
        Optional<ImageData> dbImageData = repository.findByName(fileName);
        byte[] images=ImageUtils.decompressImage(dbImageData.get().getImageData());
        return images;
    }

    public List<ImageData> getImageData (String requestId){
        System.out.println(requestId);
        List<ImageData> images = repository.findByRequestId(requestId);
        images.forEach(image -> {
            image.setImageData(ImageUtils.compressImage(image.getImageData()));
        });

        return images;
    }
    public Optional<ImageData> getFileByName(String fileName) {
        return repository.findByName(fileName);
    }
}
