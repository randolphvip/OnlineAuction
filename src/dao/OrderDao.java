package dao;

import java.util.List;

import entity.Order;

/**
 */
public interface OrderDao {

	public Order getOrderByCommodityId(int commodityID);

	public Order getOrderById(int orderID);

	public int createOrder(Order order);

	public List<Order> getOrderList(Order order);

	public boolean makeAppointment(Order order);

	public int createOrder(int commodityID);

	public int createOrder();

	public int changeOrderState(int orderId, int pickUpState);

}
