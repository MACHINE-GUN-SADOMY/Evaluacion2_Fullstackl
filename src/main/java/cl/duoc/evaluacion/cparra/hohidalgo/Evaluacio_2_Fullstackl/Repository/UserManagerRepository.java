package cl.duoc.evaluacion.cparra.hohidalgo.Evaluacio_2_Fullstackl.Repository;

import cl.duoc.evaluacion.cparra.hohidalgo.Evaluacio_2_Fullstackl.Repository.Entity.UserManagerEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserManagerRepository {
    List<UserManagerEntity> users;

    public UserManagerRepository() { // estos seran como ejemplo, los tipos de usuarios / datos que contendran por ser unicamente del equipo.
        users = new ArrayList<>();
        users.add(new UserManagerEntity(10,"Admin1","admin2@xksa","null_email","Admin",true)); // ROL TIPO ADMINISTRADOR DE SISTEMA
        users.add(new UserManagerEntity(20,"Gerente_Tienda","gerente1@xksa","null_email","Store_Manager",true)); // ROL TIPO MANAGER (GERENTE DE TIENDA)
        users.add(new UserManagerEntity(30,"Empleado_Ventas","empleado-tienda@ll.x","null_email","Sales_Clerk",true)); // ROL TIPO EMPLEADO DE VENTAS (SALES CLERK)
        users.add(new UserManagerEntity(40,"Empleado_Logistica","emp_logistica@klail.com","null_email","Logistic",true)); // ROL TIPO LOGISTICO
        // Los usuarios de tipo cliente, tendran su propio Servicio, aqui solo estaran los usuarios del Sistema/Equipo.
    }

    public List<UserManagerEntity> getAllUsers() {
        return users;
    }

    public void save(UserManagerEntity user) {
        user.setUserId((users.size() + 1) * 10); // se define los id.
        users.add(user);
    }

    public void replace(UserManagerEntity found, UserManagerEntity newUser) {
        int p = users.indexOf(found);
        newUser.setUserId(found.getUserId());
        users.set(p, newUser);
    }

    public void remove(UserManagerEntity founded) {
        users.remove(founded);
    }
    // revisar el metodo a usar para llamar a esta funcion (solo se hara por nombre)
    public UserManagerEntity getUserByName(String userName) {
        for (UserManagerEntity user : users) {
            if (user.getUserName().equals(userName)) { // no pude usar equals con el id :'(
                return user;
            }
        }
        return null;
    }
}
