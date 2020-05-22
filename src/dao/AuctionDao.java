package dao;

import java.util.List;

import entity.Bid;

/**
 *
 * @description:
 * @author: Cong
 * @Date:2020-04-21
 */
public interface AuctionDao {

	/**
	 * Save the bid information to the database;
	 * 
	 * @param bid
	 * @return
	 */
	public int saveBid(Bid bid);

	/**
	 * get the list of bid history
	 * 
	 * @param bid
	 * @return bid list
	 */
	public List<Bid> getBids(Bid bid);

}
