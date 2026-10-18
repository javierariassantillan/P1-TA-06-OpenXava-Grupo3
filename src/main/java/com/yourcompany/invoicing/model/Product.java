package com.yourcompany.invoicing.model;

import java.math.*;
import jakarta.persistence.*;
import org.openxava.annotations.*;
import lombok.*;

@Entity @Getter @Setter
public class Product {

    @Id @Column(length=9)
    int number;

    @Column(length=50) @Required
    String description;

    @ManyToOne(fetch=FetchType.LAZY, optional=true)
    @DescriptionsList
    Category category;
    @ManyToOne(fetch=FetchType.LAZY)
    @DescriptionsList
    Author author;

    @Money
    BigDecimal price;

    @Files
    @Column(length=32)
    String photos;

    @TextArea
    String remarks;

}