package com.PrProcessFlow.PrProcessFlow.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String userName;
    private String emailId;
    private String role;
    private String token; // JWT
}
