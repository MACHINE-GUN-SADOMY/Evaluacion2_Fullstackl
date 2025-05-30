package cl.duoc.evaluacion.cparra.hohidalgo.Evaluacio_2_Fullstackl.Repository.Entity;

import lombok.NoArgsConstructor;

import lombok.Setter;

import lombok.AllArgsConstructor;

import lombok.Getter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InventoryManagerEntity {
    private int productId;
    private String productName;
    private String productDescription;
    private String productCategory;
    private int productPrice;
    private int productQuantity;
}

