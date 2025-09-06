package com.PrProcessFlow.PrProcessFlow.Controller;

import com.PrProcessFlow.PrProcessFlow.Entity.FileResponse;
import com.PrProcessFlow.PrProcessFlow.Entity.ImageData;
import com.PrProcessFlow.PrProcessFlow.Services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(originPatterns = "*")
public class FileUploadController {

    @Autowired
    private StorageService storageService;

    // Upload multiple files
    @PostMapping("/upload-files")
    public ResponseEntity<?> uploadImages(
            @RequestParam("requestId") String requestId,
            @RequestParam("image") List<MultipartFile> files) throws IOException {

        List<String> uploadedUrls = new ArrayList<>();
        for (MultipartFile file : files) {
            uploadedUrls.add(storageService.uploadImage(file, requestId));
        }
        return ResponseEntity.ok(uploadedUrls);
    }

    // Get files by requestId
    @GetMapping("/get-files")
    public List<FileResponse> getImageData(@RequestParam String requestId) {
        List<ImageData> images = storageService.getImageData(requestId);
        List<FileResponse> files = new ArrayList<>();
        for (ImageData image : images) {
            files.add(new FileResponse(
                    image.getId(),
                    image.getName(),
                    image.getUrl() // Cloudinary direct URL
            ));
        }
        return files;
    }

    // ✅ FIXED: Redirect to Cloudinary instead of fetching manually
    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable Long id) throws IOException {
        ImageData imageData = storageService.getFileById(id);

        // Download actual file from Cloudinary
        java.net.URL url = new java.net.URL(imageData.getUrl());
        byte[] fileBytes;
        try (java.io.InputStream in = url.openStream()) {
            fileBytes = in.readAllBytes();
        }

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + imageData.getName() + "\"")
                .header(HttpHeaders.CONTENT_TYPE, imageData.getType()) // e.g., image/png, application/pdf
                .body(fileBytes);
    }

}
