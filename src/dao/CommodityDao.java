package dao;

import java.util.List;

import entity.Commodity;



/**
* @author rhythm
* @date 2019年5月19日 下午5:59:46
*  相关说明 
*/
public interface CommodityDao {
	
	
	public List<Commodity> getCommodityList(Commodity obj);
	public Commodity getCommodity(Commodity commodityPara);
	public boolean updateMaxPrice(int commodityId, float price , int winnerId );
	
	
	
	
	//模糊查询
		public List fuzzySerchBookList(String keyword);
		public List fuzzySerchWatchList(String keyword);
		public List fuzzySerchStampList(String keyword);
		public List fuzzySerchWineList(String keyword);
		public List fuzzySerch(String keyWord);
		//查询所有
		public List getAllList();
	
	
	
		
}
