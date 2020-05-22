package dao;

import impl.AuctionDaoImpl;
import impl.CartDaoImpl;
import impl.CommodityDaoImpl;
import impl.OrderDaoImpl;
import impl.UserDaoImpl;

/**
 *
 * @description:
 * @author: Cong
 * @Date:2020-04-21
 */
public class DaoFactory {
	/**
	 * get the instance of the auctionDao object
	 * 
	 * @return auctionDao object
	 */

	public static AuctionDao getAuctionDaoInstance() {
		return new AuctionDaoImpl();
	}

	/**
	 * 
	 * @return commodityDao object
	 */
	public static CommodityDao getCommodityDaoInstance() {
		return new CommodityDaoImpl();
	}

	/**
	 * 
	 * @return userDao object
	 */
	public static UserDao getUserDaoInstance() {
		return new UserDaoImpl();
	}

	/**
	 * 
	 * @return orderDao object
	 */
	public static OrderDao getOrderDaoInstance() {
		return new OrderDaoImpl();
	}

	/**
	 * 
	 * @return cartDao object
	 */
	public static CartDao getCartDaoInstance() {
		return new CartDaoImpl();
	}

}
