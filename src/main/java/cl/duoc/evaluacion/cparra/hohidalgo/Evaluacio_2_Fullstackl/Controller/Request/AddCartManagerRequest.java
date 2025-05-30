package cl.duoc.evaluacion.cparra.hohidalgo.Evaluacio_2_Fullstackl.Controller.Request;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddCartManagerRequest {
    private int clientId;
    // el carrito name funcionara como una cotizacion de productos
    @NotBlank
    private String cartName;
    // la descripcion no es obligatoria
    private String description;
}
