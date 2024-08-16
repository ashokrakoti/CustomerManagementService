package com.ecommerce.CustomerManagementService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ContactModel {

    private String emailAddress;
    private String phoneNumber;
    @JsonIgnore
    private CustomerModel customer;
}