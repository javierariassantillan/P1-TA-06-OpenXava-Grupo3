package com.yourcompany.invoicing.model;

import java.util.*;
import jakarta.persistence.*;
import org.openxava.annotations.*;
import lombok.*;

@Entity @Getter @Setter
@View(extendsView="super.DEFAULT", members="orders")
public class Invoice extends CommercialDocument {

    @OneToMany(mappedBy="invoice")
    @ListProperties("year, number, date, delivered")
    Collection<Order> orders;

}
