package com.ecommerce.customermanagementservice.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "customer")
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_id_generator")
    @SequenceGenerator(
            name = "customer_id_generator",
            sequenceName = "customer_id_seq",
            allocationSize = 1
    )
    @Column(name = "customer_id")
    private Long customerId;
    
    private String firstName;
    private String lastName;
    private String gender;
    private Long age;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Contact> contactsList = new ArrayList<>();
}
