package com.ecommerce.CustomerManagementService.controller;

import com.ecommerce.CustomerManagementService.entities.Customer;
import com.ecommerce.CustomerManagementService.model.CustomerModel;
import com.ecommerce.CustomerManagementService.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // Create
    @PostMapping
    public ResponseEntity<CustomerModel> createCustomer(@RequestBody CustomerModel customer) {
        return new ResponseEntity<>(customerService.createCustomer(customer), HttpStatus.CREATED);
    }

    // Read all
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerModel> getCustomerById(@PathVariable Long id) throws Exception {
         var response= customerService.getCustomerById(id);
         return new ResponseEntity<>(response, HttpStatus.OK);
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

