package com.yourcompany.invoicing.model;

import java.util.*;
import jakarta.persistence.*;
import org.openxava.annotations.*;
import lombok.*;

@Entity @Getter @Setter
public class Author {

    @Id @GeneratedValue(strategy=GenerationType.UUID)
    @Hidden
    @Column(length=36)
    String oid;

    @Column(length=50) @Required
    String name;

    @OneToMany(mappedBy="author")
    @ListProperties("number, description, price")
    Collection<Product> products;

}
