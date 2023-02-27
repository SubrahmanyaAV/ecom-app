package com.cruds.entity;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	
	private Product product;
	private List<Product> list;
//	private double total;
	
	public Cart(Product product) {
		super();
		this.product = product;
	}

	public List<Product> add(List<Product> list,Product p)
	{
		if(list == null)
		{
			list = new ArrayList<>();
		}
		list.add(p);
//		total = total + p.getPrice();
		return list;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Product> getList() {
		return list;
	}

	public void setList(List<Product> list) {
		this.list = list;
	}

}
