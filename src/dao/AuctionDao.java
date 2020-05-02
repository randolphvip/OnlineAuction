package dao;

import java.util.List;

import entity.Bid;



/**
*/
public interface AuctionDao {
	  
	
	public int saveBid(Bid bid);
	
	public List<Bid> getBids(Bid bid);
	
	
		
}
