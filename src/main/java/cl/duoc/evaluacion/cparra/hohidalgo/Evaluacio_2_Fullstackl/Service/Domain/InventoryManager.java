package cl.duoc.evaluacion.cparra.hohidalgo.Evaluacio_2_Fullstackl.Service.Domain;

public class InventoryManager {
    private int productId;
    private String productName;
    private String productDescription;
    private String productCategory;
    private int productPrice;
    private int productQuantity;

    public InventoryManager(int productId, String productName,
                            String productDescription, String productCategory,
                            int productPrice, int productQuantity) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productCategory = productCategory;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    // GETTERS

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    // SETTERS
    public void setProductId(int productId) {
        this.productId = productId;
    }
}
