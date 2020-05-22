package dao;

import java.util.List;

import entity.Cart;

/**
 *
 * @description:
 * @author: Cong
 * @Date:2020-04-21
 */

public interface CartDao {

	/**
	 * save the commodity information to the cart.
	 * 
	 * @param cart
	 * @return
	 */
	public boolean cartAdd(Cart cart);

	/**
	 * get one of cart information
	 * 
	 * @param cart
	 * @return
	 */
	public Cart getCart(Cart cart);

	/**
	 * search the list
	 * 
	 * @param cart
	 * @return
	 */
	public List<Cart> getCartList(Cart cart);

	/**
	 * change the state
	 * 
	 * @param cartId
	 * @param state
	 * @return
	 */
	public boolean changeCartState(int cartId, int state);

}
