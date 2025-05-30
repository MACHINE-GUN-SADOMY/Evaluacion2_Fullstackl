package cl.duoc.evaluacion.cparra.hohidalgo.Evaluacio_2_Fullstackl.Controller;


import cl.duoc.evaluacion.cparra.hohidalgo.Evaluacio_2_Fullstackl.Controller.Request.AddCartManagerRequest;
import cl.duoc.evaluacion.cparra.hohidalgo.Evaluacio_2_Fullstackl.Service.CartManagerService;
import cl.duoc.evaluacion.cparra.hohidalgo.Evaluacio_2_Fullstackl.Service.Domain.CartManager;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping ("/carts")
@RestController
public class CartManagerController {
    @Autowired private CartManagerService service;

    @GetMapping
    public List<CartManager> getCarts(){
        return service.getCarts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartManager> getCart(@PathVariable int id){
        CartManager foundCart = service.getCartId(id);
        if(foundCart != null){
            return ResponseEntity.ok(foundCart);
        }return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Void> addCart(@Valid @RequestBody AddCartManagerRequest requestCart){
        CartManager cart = new CartManager(
                0,
                requestCart.getClientId(),// el ID del cliente es inpuneable, el cliente no requiere estar registrado
                requestCart.getCartName(),
                requestCart.getDescription());
        boolean savedCart = service.saveCart(cart);
        if(savedCart){
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> putCart(@PathVariable int id, @RequestBody CartManager requestCart){
        boolean putCart = service.updateCart(id,requestCart);
        if(putCart){
            return ResponseEntity.noContent().build();
        }return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCart(@PathVariable int id){
        boolean deleteCart = service.deleteCart(id);
        if(deleteCart){
            return ResponseEntity.noContent().build();
        }return ResponseEntity.notFound().build();
    }
}
// Terminado CartManager Controller.