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

    private String name;
    private String type;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] imageData;
    private String requestId;
}
