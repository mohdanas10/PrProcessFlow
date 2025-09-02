package com.PrProcessFlow.PrProcessFlow.Entity;

import com.PrProcessFlow.PrProcessFlow.Services.CityServices;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fullName;
    private String requestDate ;
    private String email;
    private String state ;
    private String pinCode;
    private String address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "city-id", referencedColumnName = "id")
    private City city;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "projce-code-id", referencedColumnName = "id")
    private ProjectCode projectCode;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "store-type-id", referencedColumnName = "id")
    private StoreType storeType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lounch-code-id" , referencedColumnName = "id")
    private LounchCode lounchCode;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "store-name" , referencedColumnName = "id")
    private StoreName storeName;


}
