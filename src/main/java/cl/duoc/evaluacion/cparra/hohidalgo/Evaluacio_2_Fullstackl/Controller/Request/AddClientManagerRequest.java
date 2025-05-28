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

public class AddClientManagerRequest {
   // @NotBlank
    //private int clientId;

    @NotBlank
    private String clientName;

    @NotBlank
    private String clientLastName;

    @NotBlank
    private String clientEmail;

    @NotBlank
    private String password;


    private int phoneNumber;

    // ActiveUser: falta ...
}
