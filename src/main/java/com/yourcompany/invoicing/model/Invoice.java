package com.yourcompany.invoicing.model;

import java.time.*;
import java.util.*;
import jakarta.persistence.*;
import org.openxava.annotations.*;
import org.openxava.calculators.*;
import com.yourcompany.invoicing.calculators.*;
import lombok.*;

@Entity @Getter @Setter
public class Invoice {

    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    @Hidden
    @Column(length=36)
    String oid;

    @Column(length=4)
    @DefaultValueCalculator(CurrentYearCalculator.class)
    int year;

    @Column(length=6)
    @DefaultValueCalculator(value=NextNumberForYearCalculator.class,
            properties=@PropertyValue(name="year"))
    int number;

    @Required
    @DefaultValueCalculator(CurrentLocalDateCalculator.class)
    LocalDate date;

    @ManyToOne(fetch=FetchType.LAZY, optional=false)
    Customer customer;

    @ElementCollection
    @ListProperties("product.number, product.description, quantity")
    Collection<Detail> details;

    @TextArea
    String remarks;

}