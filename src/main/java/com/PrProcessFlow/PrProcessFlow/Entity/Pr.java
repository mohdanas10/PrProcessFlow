package com.PrProcessFlow.PrProcessFlow.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Pr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String requestId;
    private String requestedBy;
    private String requestedDate;
    private String requestedEmail;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate = new Date();
    private Date prCreationReportDate;
    private String state;
    private String cityName;
    private String storeType;
    private String projectStoreId;
    private String storeName;
    @Transient
    private List<WorkCategory> workCategory;
    private String isPrRejected;
    private String rejectedReason;
    private String isPrWithdraw;
    private String withdrawReason;
    private String remarks1;
    private String remarks2;
    private String oldPrNo;
    private String attachment;
    private String prNo;
    private String prCreator;
    private String prStatus;
    private String prCreationDate;
    private String vendorName;
    private String prWorkCategory;
}
