package cl.duoc.evaluacion.cparra.hohidalgo.Evaluacio_2_Fullstackl.Repository;

import org.springframework.stereotype.Repository;
import cl.duoc.evaluacion.cparra.hohidalgo.Evaluacio_2_Fullstackl.Repository.Entity.CartManagerEntity;
import java.util.List;
import java.util.ArrayList;

@Repository
public class CartManagerRepository {
    List<CartManagerEntity> carts;

    public List<CartManagerEntity> getCarts() {
        return carts;
    }

    public CartManagerRepository() {
        carts = new ArrayList<>();
        carts.add(new CartManagerEntity(30, 15, "test_cart", "test_desc"));
    }

    public void removeCart(CartManagerEntity foundCart) {
        carts.remove(foundCart);
    }

    public void replaceCart(CartManagerEntity foundCart, CartManagerEntity newCart) {
        int t = carts.indexOf(foundCart);
        newCart.setCartId(foundCart.getCartId());
        carts.set(t, newCart);
    }

    public CartManagerEntity getCartByName(String cartName) {
        for (CartManagerEntity cart : carts) {
            if (cart.getCartName().equals(cartName)){
                return cart;
            }
        }return null;
    }

     // calculo id de cartmanager
    public void cartSave(CartManagerEntity saveCart) {
        saveCart.setCartId((carts.size() + 1 ) + 5 * 5);
        carts.add(saveCart);
    }
}
