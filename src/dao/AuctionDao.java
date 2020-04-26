package dao;

import java.util.List;

import entity.Bid;
import entity.Commodity;



/**
*/
public interface AuctionDao {
	  
	
	public int saveBid(Bid bid);
	
	public List getBids(Bid bid);
	
	
		
}
