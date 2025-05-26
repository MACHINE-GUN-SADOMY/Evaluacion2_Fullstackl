package cl.duoc.evaluacion.cparra.hohidalgo.Evaluacio_2_Fullstackl.Controller;

import cl.duoc.evaluacion.cparra.hohidalgo.Evaluacio_2_Fullstackl.Controller.Request.AddUserManagerRequest;
import cl.duoc.evaluacion.cparra.hohidalgo.Evaluacio_2_Fullstackl.Service.Domain.UserManager;
import cl.duoc.evaluacion.cparra.hohidalgo.Evaluacio_2_Fullstackl.Service.UserManagerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// se importan las listas.
import java.util.List;

@RestController // Clase tipo Controller.
@RequestMapping("/users") // Administrador de Usuarios = USERS (Usuarios)
public class UserManagerController {
    @Autowired
    private UserManagerService service;

    @GetMapping
    public List<UserManager> getUsers() {
        return service.getUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserManager> getUser(@PathVariable int id) {
        UserManager found = service.getUserId(id);
        if (found != null) {
            return ResponseEntity.ok(found);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Void> addUser(
            @Valid @RequestBody AddUserManagerRequest request) {
        UserManager user = new UserManager(0,
                request.getUserName()
                ,request.getPassword()
                ,request.getEmailUser()
                ,request.getRole()
                ,true);

        boolean saved = service.save(user);
        if (saved) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUser(
        @PathVariable int id,
        @RequestBody UserManager request){
        boolean replaced = service.replace(id, request);
        if (replaced) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        boolean deleted = service.delete(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();

    }
}
