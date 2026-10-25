package com.yourcompany.invoicing.model;

import java.math.*;
import java.time.*;
import java.util.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.openxava.annotations.*;
import org.openxava.calculators.*;
import com.yourcompany.invoicing.calculators.*;
import lombok.*;

@Entity @Getter @Setter
@View(members=
        "year, number, date;" +
                "customer;" +
                "details;" +
                "vatPercentage, vat, totalAmount;" +
                "remarks"
)
abstract public class CommercialDocument extends Identifiable {

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
    @ReferenceView("Simple")
    Customer customer;

    @ElementCollection
    @ListProperties("product.number, product.description, quantity, pricePerUnit, amount+")
    Collection<Detail> details;

    @Digits(integer=2, fraction=0)
    BigDecimal vatPercentage;

    @ReadOnly @Money
    @Calculation("sum(details.amount) * vatPercentage / 100")
    BigDecimal vat;

    @ReadOnly @Money
    @Calculation("sum(details.amount) + vat")
    BigDecimal totalAmount;

    @TextArea
    String remarks;

}