package dao;

import java.util.List;

import entity.Bid;
import entity.Commodity;



/**
* @author rhythm
* @date 2019年5月19日 下午5:59:46
*  相关说明 
*/
public interface AuctionDao {
	  
	
	public int saveBid(Bid bid);
	
	public List getBids(Bid bid);
	
	
		
}
