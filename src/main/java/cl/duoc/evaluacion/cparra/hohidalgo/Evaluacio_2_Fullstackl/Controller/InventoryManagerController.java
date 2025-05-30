package cl.duoc.evaluacion.cparra.hohidalgo.Evaluacio_2_Fullstackl.Controller;

import cl.duoc.evaluacion.cparra.hohidalgo.Evaluacio_2_Fullstackl.Controller.Request.AddInventoryRequest;
import cl.duoc.evaluacion.cparra.hohidalgo.Evaluacio_2_Fullstackl.Service.Domain.InventoryManager;
import cl.duoc.evaluacion.cparra.hohidalgo.Evaluacio_2_Fullstackl.Service.InventoryManagerService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventories")
public class InventoryManagerController {
    @Autowired private InventoryManagerService service;
    @GetMapping
    public List<InventoryManager> getAllInventoryManagers() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventoryManager> getProduct(@PathVariable int id) {
        InventoryManager productF = service.getProductId(id);
        if (productF != null) {
            return ResponseEntity.ok(productF);
        }return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<InventoryManager> updateProduct(@PathVariable int id,
                                                          @RequestBody InventoryManager product) {
        boolean replaced = service.replaceProduct(id, product);
        if (replaced) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
        boolean deleted = service.deleteProduct(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Void> createProduct(@Valid @RequestBody AddInventoryRequest product) {
        InventoryManager inventory = new InventoryManager(
                0,
                product.getProductName()
                ,product.getProductDescription()
                ,product.getProductCategory()
                ,product.getProductPrice()
                ,product.getProductQuantity());

        boolean saved  = service.saveProduct(inventory);
        if (saved) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
