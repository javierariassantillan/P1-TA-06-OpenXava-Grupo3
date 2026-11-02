package com.yourcompany.invoicing.calculators;

import org.openxava.calculators.*;
import com.yourcompany.invoicing.model.*;
import static org.openxava.jpa.XPersistence.*;
import lombok.*;

public class PricePerUnitCalculator implements ICalculator {

    @Getter @Setter
    int productNumber;

    public Object calculate() throws Exception {
        Product product = getManager().find(Product.class, productNumber);
        return product == null ? null : product.getPrice();
    }

}
