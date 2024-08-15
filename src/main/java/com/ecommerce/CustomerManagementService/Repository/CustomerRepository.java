package com.ecommerce.CustomerManagementService.Repository;

import com.ecommerce.CustomerManagementService.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
