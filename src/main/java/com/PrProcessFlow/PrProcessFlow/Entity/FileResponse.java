package com.PrProcessFlow.PrProcessFlow.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FileResponse {
    private long id ;
    private String fileName;
    private String fileUrl;
}