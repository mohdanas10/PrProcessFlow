package com.PrProcessFlow.PrProcessFlow.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StoreId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String storeId;
}
