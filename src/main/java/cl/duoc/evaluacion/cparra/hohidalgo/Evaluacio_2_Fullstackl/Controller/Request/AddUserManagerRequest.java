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
public class AddUserManagerRequest {
    @NotBlank
    private String userName;

    @NotBlank
    private String password;

    @NotBlank
    private String emailUser;

    @NotBlank
    private String Role;

    // Perfil de Usuario corresponde a Cliente
}
