package dao;

import java.util.List;

import entity.Commodity;



/**
*/
public interface CommodityDao {
	
	
	public List<Commodity> getCommodityList(Commodity obj);
	public Commodity getCommodity(Commodity commodityPara);
	public Commodity saveCommodity(Commodity commodity);
	public boolean updateMaxPrice(int commodityId, float price , int winnerId );
	public boolean updateState(int commodityId, int state);
	public Commodity getCommodityByID(int commodityID);
	public boolean updateCommodity(Commodity commodity);
	
	
	
	
//	//模糊查询
//		public List fuzzySerchBookList(String keyword);
//		public List fuzzySerchWatchList(String keyword);
//		public List fuzzySerchStampList(String keyword);
//		public List fuzzySerchWineList(String keyword);
//		public List fuzzySerch(String keyWord);
		//查询所有
//		public List getAllList();
	
	
	
		
}
