package com.cruds.entity;

import java.util.Date;

public class Order {
	
	private int o_Id;
	private String orderId;
	private String userName;
	private Date orderDate;
	private Date dlvDate;
	private String status;
	private Double totalCost;
	
	//orderitems
	private int itemId;
	private String itemName;
	private String itemPrice;
	private String itemQuantity;
	
	public Order(int orderId) {
		super();
		this.o_Id = orderId;
	}
	
	public Order(String orderId, String userName, Date orderDate, Date dlvDate, String status, Double totalCost) {
		super();
		this.orderId = orderId;
		this.userName = userName;
		this.orderDate = orderDate;
		this.dlvDate = dlvDate;
		this.status = status;
		this.totalCost = totalCost;
	}

	public Order(int o_Id, String orderId, int itemId, String itemName, String itemPrice, String itemQuantity) {
		super();
		this.o_Id = o_Id;
		this.orderId = orderId;
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemQuantity = itemQuantity;
	}

	public Order(int o_Id, String orderId, Date orderDate, Date dlvDate, String status, int itemId,
			String itemName, String itemPrice, String itemQuantity) {
		super();
		this.o_Id = o_Id;
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.dlvDate = dlvDate;
		this.status = status;
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemQuantity = itemQuantity;
	}

	public Order(String userName, Date orderDate,Date dlvDate, String status, Double totalCost) {
		super();
		this.userName = userName;
		this.orderDate = orderDate;
		this.dlvDate = dlvDate;
		this.status = status;
		this.totalCost = totalCost;
	}

	public Order(int orderId, int itemId, String itemName, String itemPrice, String itemQuantity) {
		super();
		this.o_Id = orderId;
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemQuantity = itemQuantity;
	}

	public int getO_Id() {
		return o_Id;
	}

	public void setO_Id(int o_Id) {
		this.o_Id = o_Id;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getDlvDate() {
		return dlvDate;
	}

	public void setDlvDate(Date dlvDate) {
		this.dlvDate = dlvDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getTotalcost() {
		return totalCost;
	}

	public void setTotalcost(Double totalcost) {
		this.totalCost = totalcost;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(String itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + o_Id + ", userName=" + userName + ", orderDate=" + orderDate + ", dlvDate="
				+ dlvDate + ", status=" + status + ", totalCost=" + totalCost + "]";
	}

}
