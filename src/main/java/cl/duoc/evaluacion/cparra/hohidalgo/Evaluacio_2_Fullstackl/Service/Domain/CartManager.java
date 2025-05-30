package cl.duoc.evaluacion.cparra.hohidalgo.Evaluacio_2_Fullstackl.Service.Domain;

public class CartManager {
    private int cartId;
    private int clientId;
    private String cartName;
    private String cartDescription;


    public CartManager(int cartId, int clientId, String cartName, String cartDescription) {
        this.cartId = cartId;
        this.clientId = clientId;
        this.cartName = cartName;
        this.cartDescription = cartDescription;
    }

    public int getCartId() {
        return cartId;
    }

    public int getClientId() {
        return clientId;
    }

    public String getCartName() {
        return cartName;
    }

    public String getCartDescription() {
        return cartDescription;
    }

    // SETTERS
    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
}
