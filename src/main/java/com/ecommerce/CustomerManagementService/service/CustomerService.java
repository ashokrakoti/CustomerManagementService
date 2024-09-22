package com.ecommerce.CustomerManagementService.service;

import com.ecommerce.CustomerManagementService.Repository.CustomerRepository;
import com.ecommerce.CustomerManagementService.entities.Contact;
import com.ecommerce.CustomerManagementService.entities.Customer;
import com.ecommerce.CustomerManagementService.model.ContactModel;
import com.ecommerce.CustomerManagementService.model.CustomerModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // Create
    public CustomerModel createCustomer(CustomerModel customerModel) {

        Customer customer = new Customer();
        List<Contact> contacts = new ArrayList<Contact>();
        BeanUtils.copyProperties(customerModel, customer);
        contacts = customerModel.getContactsList().stream().map(contactModel -> {
            Contact contact = new Contact();
            BeanUtils.copyProperties(contactModel, contact);
            contact.setCustomer(customer);
            return contact;
        }).toList();
        customer.setContactsList(contacts);

        var response = customerRepository.save(customer);
        return buildCustomerResponse(response);
    }

    private CustomerModel buildCustomerResponse(Customer response) {
        var customerModel = new CustomerModel();
        List contactsListResponse = new ArrayList<ContactModel>();

        //copy parent level props
        BeanUtils.copyProperties(response, customerModel);

        //copy child level props
        contactsListResponse = response.getContactsList().stream().map(contact -> {
            var contactModel = new ContactModel();
            BeanUtils.copyProperties(contact, contactModel);
            contactModel.setCustomer(customerModel);
            return contactModel;
        }).toList();
        customerModel.setContactsList(contactsListResponse);
        return customerModel;
    }

    // Read
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public CustomerModel getCustomerById(Long id) throws Exception {
        var customer = customerRepository.findById(id);
        var customerResponse = new CustomerModel();
        if (customer.isPresent()) {
            customerResponse = buildCustomerResponse(customer.get());
        } else {
            throw new Exception("Customer with given id not found in DB.");
        }
        return customerResponse;
    }

    // Update
    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // Delete
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}

