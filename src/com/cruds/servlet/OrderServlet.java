package com.cruds.servlet;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cruds.db.OrderDAO;
import com.cruds.entity.Order;
import com.cruds.entity.Product;
import com.cruds.service.OrderService;
import com.cruds.util.DateUtil;

/**
 * Servlet implementation class OrderServlet
 */
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();

//		int orderId = Integer.parseInt(request.getParameter("orderId"));
		String userName = (String) session.getAttribute("USERNAME");
		Double total=(Double) session.getAttribute("TOTAL");
		String status = "confirmed";

		List<Product> cart = (List<Product>) session.getAttribute("CART");

		Calendar c = Calendar.getInstance();//adding 7 days
//		Date orderDate = c.getTime();
		c.add(Calendar.DATE, 7);
		Date dlvDate = c.getTime();
		
		String uniqueID = UUID.randomUUID().toString();
		String orderId = uniqueID.substring(0, 10); 
		System.out.println(orderId);

		OrderDAO dao = new OrderDAO();
		Order o = new Order(orderId,userName, DateUtil.getCurrentDate(),dlvDate, status, total);
		System.out.println(o);
		
		List<Order> list = OrderService.getOrderDetails(orderId);
		session.setAttribute("ORDERS", list);
		
		if(OrderService.order(cart,o) != null)
		{
			Order Id=dao.getOrderId(userName);
			session.setAttribute("MESSAGE","Thank you for shopping ");
			session.removeAttribute("CART");
			RequestDispatcher rs=request.getRequestDispatcher("WEB-INF/views/order.jsp");
			rs.forward(request, response);
		}

	}

}
