package com.yourcompany.invoicing.model;

import jakarta.persistence.*;
import org.openxava.annotations.*;
import lombok.*;
import jakarta.validation.constraints.*;

@Entity @Getter @Setter
@View(extendsView="super.DEFAULT", members="delivered; invoice")
public class Order extends CommercialDocument {

    boolean delivered;

    @ManyToOne
    @DescriptionsList(descriptionProperties="year, number")
    Invoice invoice;

    @AssertTrue(message="El pedido debe estar entregado para asignarlo a una factura")
    private boolean isDeliveredToBeInInvoice() {
        return invoice == null || delivered;
    }

}
