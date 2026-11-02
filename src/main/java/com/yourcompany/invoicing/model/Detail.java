package com.yourcompany.invoicing.model;

import java.math.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.openxava.annotations.*;
import com.yourcompany.invoicing.calculators.*;
import lombok.*;

@Embeddable @Getter @Setter
public class Detail {

    @Min(value=1, message="La cantidad debe ser al menos 1")
    int quantity;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    Product product;

    @DefaultValueCalculator(
            value=PricePerUnitCalculator.class,
            properties=@PropertyValue(name="productNumber", from="product.number")
    )
    @Money
    BigDecimal pricePerUnit;

    @ReadOnly @Money
    @Calculation("quantity * pricePerUnit")
    BigDecimal amount;

}
