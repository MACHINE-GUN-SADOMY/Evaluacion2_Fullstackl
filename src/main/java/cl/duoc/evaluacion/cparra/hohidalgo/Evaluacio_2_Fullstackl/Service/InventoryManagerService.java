package cl.duoc.evaluacion.cparra.hohidalgo.Evaluacio_2_Fullstackl.Service;

import cl.duoc.evaluacion.cparra.hohidalgo.Evaluacio_2_Fullstackl.Service.Domain.InventoryManager;
import cl.duoc.evaluacion.cparra.hohidalgo.Evaluacio_2_Fullstackl.Repository.InventoryManagerRepository;
import cl.duoc.evaluacion.cparra.hohidalgo.Evaluacio_2_Fullstackl.Repository.Entity.InventoryManagerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class InventoryManagerService {
    @Autowired private InventoryManagerRepository repository;

    public List<InventoryManager> getAll() {
        List<InventoryManagerEntity> inventories = repository.getInventories();
        List<InventoryManager> inventoryAux = new ArrayList<>();
        for (InventoryManagerEntity inventory : inventories) {
            inventoryAux.add(new InventoryManager(
                    inventory.getProductId()
                    ,inventory.getProductName()
                    ,inventory.getProductDescription()
                    ,inventory.getProductCategory()
                    ,inventory.getProductPrice()
                    ,inventory.getProductQuantity()));
        }return inventoryAux;
    }

    public boolean saveProduct(InventoryManager inventory) {
        InventoryManagerEntity productF = repository.getProductName(inventory.getProductName());
        if (productF != null) {
            return false;
        }

        repository.productSave(
                new InventoryManagerEntity(
                        inventory.getProductId()
                        ,inventory.getProductName()
                        ,inventory.getProductDescription()
                        ,inventory.getProductCategory()
                        ,inventory.getProductPrice()
                        ,inventory.getProductQuantity())
        );
        return true;
    }

    public boolean deleteProduct(int productId) {
        InventoryManagerEntity productF= null;
        List<InventoryManagerEntity> inventories = repository.getInventories();
        for (InventoryManagerEntity inventory : inventories) {
            if (inventory.getProductId() == productId) {
                productF = inventory;
            }
        }if (productF != null) {
            repository.removeProduct(productF);
            return true;
        }return false;
    }

    public boolean replaceProduct(int id, InventoryManager newProduct) {
        InventoryManagerEntity productF = null;
        List<InventoryManagerEntity> inventories = repository.getInventories();
        for (InventoryManagerEntity inventory : inventories) {
            if (inventory.getProductId() == id) {
                productF = inventory;
            }
        }if(productF != null) {
            repository.replaceProduct(
                    productF, new InventoryManagerEntity(
                            newProduct.getProductId()
                            ,newProduct.getProductName()
                            ,newProduct.getProductDescription()
                            ,newProduct.getProductCategory()
                            ,newProduct.getProductPrice()
                            ,newProduct.getProductQuantity()));
            return true;
        }return false;
    }

    public InventoryManager getProductId(int productId) {
        List<InventoryManager> inventories = getAll();
        for (InventoryManager inventory : inventories) {
            if (inventory.getProductId() == productId) {
                return inventory;
            }
        }
        return null;
    }
}