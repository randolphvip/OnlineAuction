package dao;

import impl.AuctionDaoImpl;

/**
*/
public class AuctionDaoFactory {
	public static AuctionDao getDaoInstance(){  
        return new AuctionDaoImpl() ;  
    }  
}
