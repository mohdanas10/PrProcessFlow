package com.PrProcessFlow.PrProcessFlow.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ImageData")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ImageData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String requestId;   // Unique PR request ID
    private String name;        // Original file name
    private String type;        // MIME type
    private String url;         // Cloudinary URL (instead of blob)
}
