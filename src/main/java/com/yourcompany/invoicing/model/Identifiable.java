package com.yourcompany.invoicing.model;

import jakarta.persistence.*;
import org.openxava.annotations.*;
import lombok.*;

@MappedSuperclass @Getter @Setter
public class Identifiable {

    @Id @GeneratedValue(strategy=GenerationType.UUID)
    @Hidden
    @Column(length=36)
    String oid;

}
