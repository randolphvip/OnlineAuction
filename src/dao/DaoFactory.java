package dao;

import impl.AuctionDaoImpl;
import impl.CartDaoImpl;
import impl.CommodityDaoImpl;
import impl.OrderDaoImpl;
import impl.UserDaoImpl;

public class DaoFactory {
	public static AuctionDao getAuctionDaoInstance(){  
        return new AuctionDaoImpl() ;  
    }  
	public static CommodityDao getCommodityDaoInstance(){  
        return new CommodityDaoImpl() ;  
    }  
	public static UserDao getUserDaoInstance(){  
        return new UserDaoImpl() ;  
    } 
	public static OrderDao getOrderDaoInstance(){  
        return new OrderDaoImpl() ;  
    } 
	public static CartDao getCartDaoInstance() {
		return new CartDaoImpl() ;  
	}

}
