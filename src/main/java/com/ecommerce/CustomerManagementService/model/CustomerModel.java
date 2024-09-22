package com.ecommerce.CustomerManagementService.model;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerModel  {

    private String firstName;
    private String lastName;
    private String gender;
    private Long age;
    private List<ContactModel> contactsList;

}