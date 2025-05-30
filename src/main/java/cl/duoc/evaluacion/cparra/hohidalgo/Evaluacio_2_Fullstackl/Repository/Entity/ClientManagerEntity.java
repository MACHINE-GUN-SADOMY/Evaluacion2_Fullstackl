package cl.duoc.evaluacion.cparra.hohidalgo.Evaluacio_2_Fullstackl.Repository.Entity;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ClientManagerEntity {
    private int clientId;
    private String clientName;
    private String clientLastName;
    private String clientEmail;
    private String password;
    private int phoneNumber;
    private boolean clientActive; // Cliente activo? El user podra desactivar ese usuario.
}
