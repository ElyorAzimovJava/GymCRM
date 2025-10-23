package com.gym.crm.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public  abstract class User {
    private UUID id;
    private String firstName;
    private String lastName;
    private String username;
    private Boolean active = true;
}
