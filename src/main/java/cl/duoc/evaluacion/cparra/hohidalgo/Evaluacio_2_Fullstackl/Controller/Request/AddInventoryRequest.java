package cl.duoc.evaluacion.cparra.hohidalgo.Evaluacio_2_Fullstackl.Controller.Request;

import lombok.Getter;

import jakarta.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;

import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddInventoryRequest {
    @NotBlank
    private String productName;
    @NotBlank
    private String productDescription;
    @NotBlank
    private String productCategory;

    private int productPrice;
    private int productQuantity; // not blank no puede ir con variables INT
}
