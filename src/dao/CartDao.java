package dao;

import java.util.List;

import entity.Cart;

/**
 */
public interface CartDao {
	 
	
	public boolean cartAdd(Cart cart );
	
	public Cart getCart(Cart cart);
	
	public List<Cart> getCartList(Cart cart);
	
	public boolean changeCartState(int cartId, int state);
	
}
