package dao;

import impl.AuctionDaoImpl;

/**
* @author rhythm
* @date 2019年5月19日 下午6:02:59
*  相关说明 
*/
public class AuctionDaoFactory {
	public static AuctionDao getDaoInstance(){  
        return new AuctionDaoImpl() ;  
    }  
}
