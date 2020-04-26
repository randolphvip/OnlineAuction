package dao;

import impl.AuctionDaoImpl;
import impl.CommodityDaoImpl;
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

}
