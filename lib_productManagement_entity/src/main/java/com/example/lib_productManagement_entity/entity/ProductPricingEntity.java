package com.example.lib_productManagement_entity.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "product_pricing")
public class ProductPricingEntity {

    @Id
    @Column(name = "product_id")
    @NotNull
    private int product_id;

    @Column(name = "cost_per_product")
    @NotNull
    private int cost_per_product;

    @Column(name = "cost_unit")
    @NotNull
    private int cost_unit;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JsonIgnore
    private ProductCatalogEntity productCatalogEntity;

}

