package dao;

import java.util.List;

import entity.Commodity;

public interface CommodityDao {
	/**
	 * get the list of commodities
	 * 
	 * @param obj
	 * @return
	 */
	public List<Commodity> getCommodityList(Commodity obj);

	/**
	 * get only one commodity
	 * 
	 * @param commodityPara
	 * @return
	 */
	public Commodity getCommodity(Commodity commodityPara);

	/**
	 * save the product information to the database;
	 * 
	 * @param commodity
	 * @return
	 */
	public Commodity saveCommodity(Commodity commodity);

	/**
	 * then the user bid, the max price will be changed.
	 * 
	 * @param commodityId
	 * @param price
	 * @param winnerId
	 * @return
	 */
	public boolean updateMaxPrice(int commodityId, float price, int winnerId);

	/**
	 * admin user update the state of the commodity
	 * 
	 * @param commodityId
	 * @param state
	 * @return
	 */
	public boolean updateState(int commodityId, int state);

	/**
	 * get only one commodity by id
	 * 
	 * @param commodityID
	 * @return
	 */
	public Commodity getCommodityByID(int commodityID);

	/**
	 * update the commodity information.
	 * 
	 * @param commodity
	 * @return
	 */
	public boolean updateCommodity(Commodity commodity);

}
