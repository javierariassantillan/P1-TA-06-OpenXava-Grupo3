package com.yourcompany.invoicing.model;

import jakarta.persistence.*;
import org.openxava.annotations.*;
import lombok.*;
import com.yourcompany.invoicing.annotations.*;

@Entity
@Getter @Setter

@View(name="Simple", members="number, name")

public class Customer {

    @Id @Column(length=6)
    int number;

    @Column(length=50) @Required
    String name;

    @Embedded @NoFrame
    Address address;

    @Column(length=10) @Cedula
    String idNumber;

}