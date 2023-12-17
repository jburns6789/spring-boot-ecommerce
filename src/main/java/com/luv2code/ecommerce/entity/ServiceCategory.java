package com.luv2code.ecommerce.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@Entity
@Table(name="service_category")
// Data -- known bug
@Getter
@Setter

public class ServiceCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "service_name")
    private String serviceName;

    //Advanced JPA Relationship mapping
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private Set<Service> services;
}