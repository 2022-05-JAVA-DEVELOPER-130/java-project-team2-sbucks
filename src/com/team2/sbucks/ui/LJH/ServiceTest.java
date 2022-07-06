package com.team2.sbucks.ui.LJH;

import java.util.ArrayList;
import java.util.List;

import com.team2.sbucks.dto.OrderDetail;
import com.team2.sbucks.dto.OrderList;
import com.team2.sbucks.service.OrderService;

public class ServiceTest {
public static void main(String[] args) throws Exception{
	int memberNo=1;
	OrderService orderService=new OrderService();
	List<OrderList> orderlist=new ArrayList<OrderList>();
	OrderList orderList = orderService.printOrder(2,45);
	System.out.println(orderList);
	List<OrderDetail> orderDetail = orderList.getOrderDetail();
	System.out.println(orderDetail.size());

}
	
}
