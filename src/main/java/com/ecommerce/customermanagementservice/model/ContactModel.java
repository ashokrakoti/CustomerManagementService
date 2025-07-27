package com.ecommerce.customermanagementservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Schema(description = "Represents contact information for a customer")
public class ContactModel {

    @Schema(description = "Email address of the contact", example = "john.doe@example.com")
    private String emailAddress;
    
    @Schema(description = "Phone number of the contact", example = "+1234567890")
    private String phoneNumber;
    
    @Schema(description = "Customer associated with this contact (ignored in JSON serialization)", accessMode = Schema.AccessMode.READ_ONLY)
    @JsonIgnore
    private CustomerModel customer;
}