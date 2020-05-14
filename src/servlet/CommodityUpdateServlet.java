package servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dao.CommodityDao;
import dao.DaoFactory;
import entity.Commodity;
import entity.User;
import util.Utils;


@WebServlet("/CommodityUpdateServlet")
public class CommodityUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
 
    
    protected void doPost2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		User user= (User)request.getSession().getAttribute("user");
		if(user==null) {
			response.sendRedirect("login.jsp?errorMsg=5");
			return;
		}
		
		String pictureFileName = null;
		
		String imgUrl=null;
				
		
		// 设置上传图片的保存路径
		String savePath = this.getServletContext().getRealPath("/imges");
 
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		// 2、创建一个文件上传解析器
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("UTF-8");
		
		
		List<FileItem> list = null;
		try {
			list = upload.parseRequest(request);
		} catch (FileUploadException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	 
		System.out.println(list.toString());// 文件的路径 以及保存的路径
		for (FileItem item : list) {
			String filename = item.getName();// 获得一个项的文件名称
			if (filename == null || filename.trim().equals("")) {// 如果為空則跳過
				continue;
			}

			
			 
			filename = filename.substring(filename.lastIndexOf("\\") + 1);
			System.out.println("filename----------"+filename);
			
			String  suffix =filename.substring(filename.lastIndexOf(".") + 1);
			if (suffix.equals("png")|| suffix.equals("jpg")|| suffix.equals("JPG")|| suffix.equals("PNG")|| suffix.equals("jpeg")) {
				InputStream in = item.getInputStream();// 獲得上傳的輸入流
				
				pictureFileName= UUID.randomUUID().toString()+"."+suffix;
				FileOutputStream out = new FileOutputStream(savePath + "\\" + pictureFileName);// 指定web-inf目錄下的images文件
				imgUrl = "imges/" + pictureFileName;

				int len = 0;
				byte buffer[] = new byte[1024];
				while ((len = in.read(buffer)) > 0)// 每次讀取
				{
					out.write(buffer, 0, len);
				}
				in.close();
				out.close();
				item.delete();
			} else {
				// 必须是图片才能上传否则失败
				System.out.println("上传的文件格式不正确。!");
				return;
			}
		}
		
		System.out.println("完整路劲:" + imgUrl);

		 
		 
		float price =  -1;
		String description = null;
		String title=null;
		String closeDate=null;
		int userId= user.getId();
		int category=0;
		int commodityId=0;
		// 获取表中的数据
		Iterator<FileItem> thisItem = list.iterator();
		while (thisItem.hasNext()) {
			FileItem thisItem2 = thisItem.next();
			String thisItemName = thisItem2.getFieldName();
			if (thisItem2.isFormField()) {
				if (thisItemName.equals("price")) {
					price = Float.parseFloat(thisItem2.getString("utf-8"));
					System.out.println("price:"+price);
				} else if (thisItemName.equals("description")) {
					description = thisItem2.getString("utf-8");
					System.out.println("desctip"+description);
				} else if (thisItemName.equals("title")) {
					title = thisItem2.getString("utf-8");
					System.out.println(title);
				}else if (thisItemName.equals("closeDate")) {
					closeDate = thisItem2.getString("utf-8");
					closeDate=closeDate.replace("T", " ");
					System.out.println("closeDate........."+closeDate);
				}
				else if (thisItemName.equals("category")) {
					category = Integer.parseInt(thisItem2.getString("utf-8"));
					System.out.println("category"+category);
				}else if (thisItemName.equals("commodityId")) {
					commodityId = Integer.parseInt(thisItem2.getString("utf-8"));
					System.out.println("commodityId"+commodityId);
				}
			}
		}
		Commodity commodity = new Commodity();
		commodity.setUserId(userId);
		commodity.setTitle(title);
		commodity.setPrice(price);
		commodity.setMaxPrice(price);
		commodity.setIntroduce(description);
		commodity.setCloseDate(Utils.strToSqlDate(closeDate, "yyyy-MM-dd HH:mm"));
		commodity.setPublishDate(Utils.dateToTime(new java.util.Date()));
		commodity.setCategory(category);
		commodity.setId(commodityId);
		
		System.out.println("新的圖片路徑："+imgUrl);
		commodity.setPicture(imgUrl);
		
		CommodityDao commodityDao=DaoFactory.getCommodityDaoInstance();
		commodityDao.updateCommodity(commodity);
		
		
		//存入数据库中
//		addCommodity(type, userId,price,introduce,imgUrl);
//		//增加用户的auction_number
//		addUserCommodity(userId);
	
		response.sendRedirect("CommoditySearchManageServlet");
		 
	}
	
	
	 
}

