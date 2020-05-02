package dao;

import java.util.List;

import entity.Order;

/**
 */
public interface OrderDao {
	// 添加竞拍
	public boolean addOrder(int commodityId,float price,int winnerId, int userId,String type);
	// 根据类型和商品id寻找订单id
	public int selectId(int id,String type);
	//删除订单
	public boolean deleteById(int id);
	
	public Order getOrderByCommodityId(int commodityID);
	
	public Order getOrderById(int orderID);
	
	public int createOrder(Order order);
	
	public List<Order> getOrderList(Order order);
	
	
}
