package com.example.lib_productManagement_entity.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Data
@Table(name = "product_catalog")
public class ProductCatalogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int product_id;

    @Column(name = "product_name")
    @NotNull(message = "Product Name should not be Null")
    private String product_name;

    @Column(name = "product_description")
    @NotNull(message = "Product Description should not be Null")
    private String product_description;

    @Column(name = "product_brand")
    @NotNull
    private String product_brand;

    @OneToOne(mappedBy = "productCatalogEntity", cascade = CascadeType.ALL)
    @JsonIgnore
    private ProductInventoryEntity productInventoryEntity;

    @OneToOne(mappedBy = "productCatalogEntity", cascade = CascadeType.ALL)
    @JsonIgnore
    private ProductPricingEntity productPricingEntity;

}
