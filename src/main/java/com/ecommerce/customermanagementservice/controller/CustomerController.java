package com.ecommerce.customermanagementservice.controller;

import com.ecommerce.customermanagementservice.entities.Customer;
import com.ecommerce.customermanagementservice.model.CustomerModel;
import com.ecommerce.customermanagementservice.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@Tag(name = "Customer Management", description = "APIs for managing customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Operation(summary = "Create a new customer", description = "Creates a new customer with the provided details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Customer created successfully", 
                    content = @Content(schema = @Schema(implementation = CustomerModel.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping
    public ResponseEntity<CustomerModel> createCustomer(@io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Customer object that needs to be added", 
            required = true,
            content = @Content(schema = @Schema(implementation = CustomerModel.class)))
            @RequestBody CustomerModel customer) {
        return new ResponseEntity<>(customerService.createCustomer(customer), HttpStatus.CREATED);
    }

    @Operation(summary = "Get all customers", description = "Retrieves a list of all customers")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved list of customers")
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @Operation(summary = "Get customer by ID", description = "Retrieves a specific customer by their ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved customer", 
                    content = @Content(schema = @Schema(implementation = CustomerModel.class))),
            @ApiResponse(responseCode = "404", description = "Customer not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<CustomerModel> getCustomerById(
            @Parameter(description = "ID of the customer to be retrieved", required = true)
            @PathVariable Long id) throws Exception {
        var response = customerService.getCustomerById(id);
        return ResponseEntity.ok(response);
    }



//    // Update
//    @PutMapping("/{id}")
//    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customerDetails) {
//        Optional<Customer> customer = customerService.getCustomerById(id);
//        if (customer.isPresent()) {
//            Customer updatedCustomer = customer.get();
//            updatedCustomer.setFirstName(customerDetails.getFirstName());
//            updatedCustomer.setLastName(customerDetails.getLastName());
//            return ResponseEntity.ok(customerService.updateCustomer(updatedCustomer));
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

//    // Delete
//    @DeleteMapping("/{id}")
//    public ResponseEntity deleteCustomer(@PathVariable Long id) {
//        Optional<Customer> customer = customerService.getCustomerById(id);
//        if (customer.isPresent()) {
//            customerService.deleteCustomer(id);
//            return ResponseEntity.noContent().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
}

