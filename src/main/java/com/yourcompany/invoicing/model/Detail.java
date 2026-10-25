package com.yourcompany.invoicing.model;

import java.math.*;
import jakarta.persistence.*;
import org.openxava.annotations.*;
import lombok.*;

@Embeddable @Getter @Setter
public class Detail {

    int quantity;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    Product product;

    @Money
    BigDecimal pricePerUnit;

    @ReadOnly @Money
    @Calculation("quantity * pricePerUnit")
    BigDecimal amount;

}