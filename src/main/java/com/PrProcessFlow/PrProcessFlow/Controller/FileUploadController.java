package com.PrProcessFlow.PrProcessFlow.Controller;


import com.PrProcessFlow.PrProcessFlow.Entity.FileResponse;
import com.PrProcessFlow.PrProcessFlow.Entity.ImageData;
import com.PrProcessFlow.PrProcessFlow.Services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(originPatterns = "*")
public class FileUploadController {

    @Autowired
    private StorageService storageService;

    @PostMapping("/upload-file")
    public ResponseEntity<?> uploadImages(@RequestParam("image") List<MultipartFile> files) throws IOException {
        List<String> uploadedPaths = new ArrayList<>();
        for (MultipartFile file : files) {
            uploadedPaths.add(storageService.uploadImage(file));
        }
        return ResponseEntity.ok(uploadedPaths);
    }

    @GetMapping("/get-single-file/{fileName}")
    public ResponseEntity<byte[]> downloadImage(@PathVariable String fileName){
        byte[] fileData=storageService.downloadImage(fileName);
//        return ResponseEntity.status(HttpStatus.OK)
//                .contentType(MediaType.valueOf("image/png"))
//                .body(imageData);
        String contentType = "application/octet-stream";
        Optional<ImageData> imageDataOpt = storageService.getFileByName(fileName);
        if (imageDataOpt.isPresent() && imageDataOpt.get().getType() != null) {
            contentType = imageDataOpt.get().getType();
        }
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header("Content-Disposition", "attachment; filename=\"" + fileName + "\"")
                .body(fileData);

    }

    @GetMapping("/get-files")
    public List<FileResponse> getImageData(@RequestParam String requestId){
        System.out.println(requestId);
        List<ImageData> images = storageService.getImageData(requestId);
        List<FileResponse> files = new ArrayList<>();
        for (ImageData image : images) {
            files.add(new FileResponse(
                    image.getName(),
                    "http://localhost:8080/get-single-file/" + image.getName()
            ));
        }
        return files;
    }
}
