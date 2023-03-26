package mk.ukim.finki.emt.eshop.service;

import mk.ukim.finki.emt.eshop.model.Product;
import mk.ukim.finki.emt.eshop.model.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {

    List<Product> listAllProductsInShoppingCart(Long cartId);

    ShoppingCart getActiveShoppingCart(String username);

    ShoppingCart addProductToShoppingCart(String username, Long productId);
}
