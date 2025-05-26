package cl.duoc.evaluacion.cparra.hohidalgo.Evaluacio_2_Fullstackl.Repository.Entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserManagerEntity {
    private int userId;
    private String userName;
    private String password;
    private String emailUser;
    private String Role;
    private boolean isActive;
}
