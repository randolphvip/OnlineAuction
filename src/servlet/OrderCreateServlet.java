package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.OrderDao;

@WebServlet("/OrderCreateServlet")
public class OrderCreateServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html;charset=UTF-8");
	        request.setCharacterEncoding("utf-8");
	        response.setCharacterEncoding("UTF-8");
	      
	        
	        OrderDao orderDao = DaoFactory.getOrderDaoInstance();
//	        CommodityDao commodityDao =DaoFactory.getCommodityDaoInstance();
	        
	        String commodityID = request.getParameter("ID");       
	        
	        orderDao.createOrder(Integer.parseInt(commodityID) );
	        
//	        如果已经生成过订单，则退出。
	        
//	        if(commodityID!=null &&commodityID!="") {
//	        	Order order= orderDao.getOrderByCommodityId(Integer.parseInt(commodityID));
//	        	if (order==null) {//证明没有订单，需要生成
//	        		Commodity commodity =commodityDao.getCommodityByID(Integer.parseInt(commodityID));
//	        		order = new Order();
//	 	        	order.setCommodityId(commodity.getId());
//	 	        	order.setWinnerId(commodity.getWinnerId());
//	 	        	order.setPickUpState(util.Content.PICK_UP_STATE_NO);
//	 	        	orderDao.createOrder(order);//生成订单。
//	 	        	 System.out.println("订单生成完成。。。。。。");                                      //用于测试 ，判断是否成功获取到数据；
//	 		        out.println("订单生成完成。。。。。。");  
//	        	}else {
//	        		System.out.println("订单已经存在，商品编号为："+commodityID);
//	        		out.println("订单已经存在，商品编号为："+commodityID);  
//	        	}
//	        }else {
//	        	//将商品表中的商品，状态为selling的，到时间了，但还没成订单。
////	        	INSERT INTO  T_ORDER (COMMODITY_ID,WINNER_ID,DEAL_DATE,PICK_UP_STATE,PRICE)  SELECT ID, WINNER_ID, CLOSE_DATE,2,MAX_PRICE FROM T_COMMODITY WHERE STATE =2 AND CLOSE_DATE< SYSDATE();
////	        	 INSERT INTO  T_ORDER (COMMODITY_ID,WINNER_ID,DEAL_DATE,PICK_UP_STATE,PRICE)
////	        	 SELECT ID, WINNER_ID, CLOSE_DATE,2,MAX_PRICE FROM T_COMMODITY WHERE STATE =2 AND WINNER_ID IS NOT NULL AND CLOSE_DATE< SYSDATE()
//	        	 
//	        	 
////	        	 UPDATE T_COMMODITY SET STATE='1' WHERE STATE =2 AND CLOSE_DATE< SYSDATE();
//	        }
	        	
	        	
	        	
	        	
	        	
	        	
	     
	        
	         
	        
//	 		 
		
		


	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}
	public static void main(String[]age) {
		String a=new String("");
		System.out.println(a=="");
	}

}
