package com.PrProcessFlow.PrProcessFlow.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@ToString
public class ProjectCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String projectCode;
}
