package com.cruds.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cruds.entity.Order;
import com.cruds.entity.Product;
import com.cruds.util.DateUtil;

public class OrderDAO {

	public List<Product> order(List<Product> list,Order o)
	{
		System.out.println(list);

		String sql="insert into orders(orderId,userName,orderDate,dlvDate,status,totalCost) values(?,?,?,?,?,?)";
		String sql2="insert into orderitems(o_Id,itemName,itemPrice,itemQuantity) values(?,?,?,?)";

		int rows=0,row2,o_Id = 0;

		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1,o.getOrderId());
			ps.setString(2,o.getUserName());
			ps.setDate(3, DateUtil.getCurrDateAsSQLDate(o.getOrderDate()));
			ps.setDate(4, DateUtil.getCurrDateAsSQLDate(o.getDlvDate()));
			ps.setString(5, o.getStatus());
			ps.setDouble(6, o.getTotalcost());
			rows = ps.executeUpdate();

			try(ResultSet rs=ps.getGeneratedKeys() )
			{
				if(rs.next()&& rs!=null)
				{
					o_Id=rs.getInt(1);
				}
			}

			for(Product p:list)
			{
				ps = conn.prepareStatement(sql2);
				ps.setInt(1, o_Id);
				ps.setString(2, p.getPname());
				ps.setDouble(3, p.getPrice());
				ps.setString(4, p.getQuantity());
				row2=ps.executeUpdate();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return  list;
	}

	public Order getOrderId(String userName)
	{
		String sql="select o_Id from orders where userName = ?";
		Order o=null;
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ResultSet rs=ps.executeQuery();

			while(rs!=null && rs.next())
			{
				o=new Order(rs.getInt(1));	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return o;
	}

	public List<Order> viewOrders(String userName)
	{
		Order o=null;

		List<Order> list=new ArrayList<Order>();
		
		String sql="select o.o_Id,o.orderId,o.orderDate,o.dlvDate,o.status,oi.itemId,oi.itemName,oi.itemPrice,oi.itemQuantity from orders o ,orderitems oi where o.o_Id = oi.o_Id and o.userName=?";

		try(Connection con=DBConnectionManager.getConnection())
		{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, userName);
			ResultSet rs=ps.executeQuery();

			while(rs !=null && rs.next())
			{
				o=new Order(rs.getInt(1),rs.getString(2), rs.getDate(3), rs.getDate(4), rs.getString(5), rs.getInt(6), rs.getString(7),rs.getString(8), rs.getString(9));
				list.add(o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Order> getOrderItemDetails(int o_Id)
	{
		Order o=null;

		List<Order> list=new ArrayList<Order>();
		String sql="select o_Id,orderId,itemId,itemName,itemPrice,itemQuantity from orderitems where o_Id=?";
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, o_Id);
			ResultSet rs=ps.executeQuery();

			while(rs.next())
			{
				o=new Order(rs.getInt(1),rs.getString(2),rs.getInt(3), rs.getString(4),rs.getString(5), rs.getString(6));
				list.add(o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Order> getOrderDetails(String orderId)
	{
		Order o=null;

		List<Order> list=new ArrayList<Order>();
		String sql="select orderId,orderDate,dlvDate,status,totalCost from orders where orderId=?";
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, orderId);
			ResultSet rs=ps.executeQuery();

			while(rs.next())
			{
				o=new Order(rs.getString(1),rs.getDate(2), rs.getDate(3),rs.getString(4), rs.getDouble(5));
				list.add(o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
