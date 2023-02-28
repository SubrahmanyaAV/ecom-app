package com.cruds.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cruds.entity.Cart;
import com.cruds.entity.Product;
import com.cruds.entity.User;

/**
 * Servlet implementation class CartServlet
 */
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String action = request.getParameter("ACTION");
		User user = (User) session.getAttribute("USER");
		RequestDispatcher rd = null;
			if ("VIEW".equalsIgnoreCase(action))
			{
				rd = request.getRequestDispatcher("WEB-INF/views/cart.jsp");
			}
			else 
			{
				int pid = Integer.parseInt(request.getParameter("pid"));
				String pname= request.getParameter("pname");
				double price = Double.parseDouble(request.getParameter("price"));
				String quantity= request.getParameter("quantity");

				HttpSession session1 = request.getSession(true);
				List<Product> cart = (List<Product>) session1.getAttribute("CART");

				if(cart == null )
				{	
					cart = new ArrayList<>();
				}

				Product p = new Product(pid, pname, price,quantity);
				Cart c = new Cart(p);
				cart = c.add(cart, p);

				System.out.println(cart);
				session1.setAttribute("CART", cart);
				/*			session.setAttribute("PID", pid);
					session.setAttribute("PNAME", pname);
					session.setAttribute("PRICE", price);
					session.setAttribute("QUANTITY", quantity);
				 */			
				double total = 0;
				for(Product prod : cart)
				{
					total = total + prod.getPrice();
					session.setAttribute("TOTAL", total);
				}

				request.setAttribute("MSG","Item added Successfully") ;
				rd = request.getRequestDispatcher("index.jsp");

			}
			
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
