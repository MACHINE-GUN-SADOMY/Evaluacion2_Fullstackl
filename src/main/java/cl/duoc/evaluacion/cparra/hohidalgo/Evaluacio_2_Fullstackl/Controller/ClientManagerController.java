package cl.duoc.evaluacion.cparra.hohidalgo.Evaluacio_2_Fullstackl.Controller;

import cl.duoc.evaluacion.cparra.hohidalgo.Evaluacio_2_Fullstackl.Controller.Request.AddClientManagerRequest;
import cl.duoc.evaluacion.cparra.hohidalgo.Evaluacio_2_Fullstackl.Service.Domain.ClientManager;
import cl.duoc.evaluacion.cparra.hohidalgo.Evaluacio_2_Fullstackl.Service.ClientManagerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// users es unicamente para usuarios propio del sistema.
// clients estara todos los usuarios del tipo cliente *exclusivamente*
@RequestMapping("/clients")
@RestController
public class ClientManagerController {
    @Autowired private ClientManagerService service;

    @GetMapping
    public List<ClientManager> getAllClients(){
        return service.getClients();
    }

    @GetMapping ("/{id}")
    public ResponseEntity<ClientManager> getClientById(@PathVariable int id){
        ClientManager foundClient = service.getClientId(id);
        if(foundClient != null){
            return ResponseEntity.ok(foundClient);
        }return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Void> addClient(@Valid @RequestBody AddClientManagerRequest requestClient){
        ClientManager client = new ClientManager(
                0, // el client id siempre sera 0, para poder hacer el calculo de ID.
                requestClient.getClientName()
                ,requestClient.getClientLastName()
                ,requestClient.getClientEmail()
                ,requestClient.getPassword()
                ,requestClient.getPhoneNumber()
                ,true); // el cliente por defecto siempre estara activo. (se puede desactivar con PUT)

        boolean saved = service.saveClient(client);
        if (saved){
            return ResponseEntity.status(HttpStatus.CREATED).build(); // Cuando lo guarde el status code sera : 201 CREATED
        }return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateClient(@PathVariable int id, @RequestBody ClientManager requestClient){
        boolean replacedClient = service.replaceClient(id, requestClient);
        if (replacedClient){
            return ResponseEntity.noContent().build();
        }return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable int id){
        boolean deletedClient = service.deleteClient(id);
        if (deletedClient){
            return ResponseEntity.noContent().build(); // codigo de ERROR " 204 NO CONTENT "
        }return ResponseEntity.notFound().build(); // codigo de ERROR "404 NOT FOUND"
    }
}
