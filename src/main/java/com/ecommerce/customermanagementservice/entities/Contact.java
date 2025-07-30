package com.ecommerce.customermanagementservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "contact")
public class Contact implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contact_id_generator")
    @SequenceGenerator(
            name = "contact_id_generator",
            sequenceName = "contact_id_seq",
            allocationSize = 1
    )
    @Column(name = "contact_id")
    private Long contactId;
    
    @Column(name = "email_address", nullable = false)
    private String emailAddress;
    
    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false)
    @JsonIgnore
    private Customer customer;
}