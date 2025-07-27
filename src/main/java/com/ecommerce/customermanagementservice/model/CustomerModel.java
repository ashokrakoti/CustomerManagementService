package com.ecommerce.customermanagementservice.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Schema(description = "Represents a customer in the system")
public class CustomerModel  {

    @Schema(description = "First name of the customer", example = "John")
    private String firstName;
    
    @Schema(description = "Last name of the customer", example = "Doe")
    private String lastName;
    
    @Schema(description = "Gender of the customer", example = "MALE")
    private String gender;
    
    @Schema(description = "Age of the customer", example = "30")
    private Long age;
    
    @Schema(description = "List of contact information for the customer")
    private List<ContactModel> contactsList;

}