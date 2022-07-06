package com.team2.sbucks.ui.LJH;

import java.util.ArrayList;
import java.util.List;

import com.team2.sbucks.dto.OrderList;
import com.team2.sbucks.service.OrderService;

public class ServiceTest {
public static void main(String[] args) throws Exception{
	int memberNo=1;
	OrderService orderService=new OrderService();
	List<OrderList> orderlist=new ArrayList<OrderList>();
	orderlist=orderService.printAllOrderList(1);
	for (int i = 0; i < orderlist.size(); i++) {
		OrderList order=orderlist.get(i);
		System.out.println(order);
		System.out.println(order.getOrderDetail());
		//System.out.println(orderlist.get(i).getOrderDetail().get(0).getProduct().getProduct_name());
		
	}
}
	
}
