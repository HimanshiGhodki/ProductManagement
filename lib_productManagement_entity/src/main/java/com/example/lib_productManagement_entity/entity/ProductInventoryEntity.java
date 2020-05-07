package com.example.lib_productManagement_entity.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@Table(name = "product_inventory")
public class ProductInventoryEntity {

    @Id
    @Column(name = "product_id")
    private int product_id;

    @NotNull
    @Column(name = "product_quantity_available")
    private int product_quantity_available;

    @NotNull
    @Column(name = "product_purchase_date")
    private Date product_purchase_date;

    @NotNull
    @Column(name = "product_quantity_purchased")
    private int product_quantity_purchased;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JsonIgnore
    private ProductCatalogEntity productCatalogEntity;

}
