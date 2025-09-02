package com.PrProcessFlow.PrProcessFlow.Entity;

import jakarta.persistence.Entity;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileResponse {
    private String name;
    private String url;
}
