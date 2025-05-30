package cl.duoc.evaluacion.cparra.hohidalgo.Evaluacio_2_Fullstackl.Repository;

import cl.duoc.evaluacion.cparra.hohidalgo.Evaluacio_2_Fullstackl.Repository.Entity.InventoryManagerEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InventoryManagerRepository {
    List<InventoryManagerEntity> inventories;

    public List<InventoryManagerEntity> getInventories() {
        return inventories;
    }

    /* Dentro el negocio existen varios tipos de categorias, en este caso como ejemplo se agregaron
      un producto de cuidado personal y otro para mascotas */

    public InventoryManagerRepository() {
        inventories = new ArrayList<>();
        inventories.add(new InventoryManagerEntity
        (100, "Pasta Dental de Menta", "Pasta dental vegana de menta: ecológica, " +
        "natural, con flúor, en envase retornable y fabricación local.", "Cuidado Personal", 4200, 120));

        inventories.add
       (new InventoryManagerEntity(110, "Shampoo Sólido para Mascotas",
       "Shampoo sólido vegano para perros y gatos, con avena y manzanilla, " +
       "que hidrata el pelo de forma natural", "Cuidado para Mascotas",5000, 100));
    }

    public void replaceProduct (InventoryManagerEntity productF, InventoryManagerEntity newProduct) {
        int o = inventories.indexOf(productF);
        newProduct.setProductId((productF.getProductId()));
        inventories.set(o,newProduct);
    }

    public void removeProduct (InventoryManagerEntity productF) {
        inventories.remove(productF);
    }

    public InventoryManagerEntity getProductName (String productName) {
        for (InventoryManagerEntity inventory: inventories) {
            if (inventory.getProductName().equals(productName)) {
                return inventory;
            }
        }return null;
    }

    /* para diferenciar los ID's de cada CRUD, en este caso, los productos tendran ID con
        centenas 100, 110, 120 .. .
    */
    public void productSave(InventoryManagerEntity saveProduct) {
        saveProduct.setProductId((inventories.size() + 1) * 10 + 100);
        inventories.add(saveProduct);
    }
}
