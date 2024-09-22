package com.ecommerce.CustomerManagementService.Repository;

import com.ecommerce.CustomerManagementService.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
