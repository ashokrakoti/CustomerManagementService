package com.ecommerce.customermanagementservice.Repository;

import com.ecommerce.customermanagementservice.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
