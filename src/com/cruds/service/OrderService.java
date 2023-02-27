package com.cruds.service;

import java.util.List;

import com.cruds.db.OrderDAO;
import com.cruds.entity.Order;
import com.cruds.entity.Product;

public class OrderService {
	
	public static List<Product> order(List<Product> list,Order o)
	{
		OrderDAO dao = new OrderDAO();
		return dao.order(list,o);
	}
	
	public static Order getOrderId(String userName)
	{
		OrderDAO dao = new OrderDAO();
		return dao.getOrderId(userName);
	}
	
	public static List<Order> viewOrders(String userName)
	{
		OrderDAO dao = new OrderDAO();
		return dao.viewOrders(userName);
	}
	
	public static List<Order> getOrderItemDetails(int orderId)
	{
		OrderDAO dao = new OrderDAO();
		return dao.getOrderItemDetails(orderId);
	}

	public static List<Order> getOrderDetails(String orderId)
	{
		OrderDAO dao = new OrderDAO();
		return dao.getOrderDetails(orderId);
	}

}
