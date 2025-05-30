package cl.duoc.evaluacion.cparra.hohidalgo.Evaluacio_2_Fullstackl.Service;

import cl.duoc.evaluacion.cparra.hohidalgo.Evaluacio_2_Fullstackl.Repository.CartManagerRepository;
import cl.duoc.evaluacion.cparra.hohidalgo.Evaluacio_2_Fullstackl.Repository.Entity.CartManagerEntity;
import cl.duoc.evaluacion.cparra.hohidalgo.Evaluacio_2_Fullstackl.Service.Domain.CartManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartManagerService {
    @Autowired
    private CartManagerRepository repository;

    public List<CartManager> getCarts() {
        List<CartManagerEntity> carts = repository.getCarts();
        List<CartManager> cartManagerAux = new ArrayList<>();
        for (CartManagerEntity cart : carts) {
            cartManagerAux.add(new CartManager(
                    cart.getCartId()
                    ,cart.getClientId()
                    ,cart.getCartName()
                    ,cart.getCartDescription()
            ));
        }return cartManagerAux;
    }

    public boolean updateCart(int id, CartManager newCart) {
        CartManagerEntity foundCart = null;
        List<CartManagerEntity> carts = repository.getCarts();
        for (CartManagerEntity cart : carts){
            if(cart.getCartId() == id){
                foundCart = cart;
            }
        }if (foundCart != null) {
            repository.replaceCart(foundCart,new CartManagerEntity(
                    newCart.getCartId()
                    ,newCart.getClientId()
                    ,newCart.getCartName()
                    ,newCart.getCartDescription()));
            return true;
        }return false;
    }

    public boolean saveCart(CartManager cart) {
        CartManagerEntity foundCart = repository.getCartByName(cart.getCartName());
        if (foundCart != null) {
            return false;
        }

        repository.cartSave(
                new CartManagerEntity(
                    cart.getCartId()
                    ,cart.getClientId()
                    ,cart.getCartName()
                    ,cart.getCartDescription()));
        return true;
    }

    public CartManager getCartId(int id) {
        List<CartManager> carts = getCarts();
        for (CartManager cart : carts) {
            if (cart.getCartId() == id) {
                return cart;
            }
        }
        return null;
    }

    public boolean deleteCart(int cartId) {
        CartManagerEntity foundCart = null;
        List<CartManagerEntity> carts = repository.getCarts();
        for (CartManagerEntity cart : carts) {
            if (cart.getCartId() == cartId) {
                foundCart = cart;
            }
        }
        if (foundCart != null) {
            repository.removeCart(foundCart);
            return true;
        }
        return false;
    }
}
