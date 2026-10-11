package com.yourcompany.invoicing.model;

import jakarta.persistence.*;
import org.openxava.annotations.*;
import lombok.*;

@Entity @Getter @Setter
public class Category {

    @Id
    @Hidden
    @GeneratedValue(strategy=GenerationType.UUID)
    @Column(length=36)
    String oid;

    @Column(length=50)
    String description;

}