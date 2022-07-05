package com.team2.sbucks.service;

import java.util.ArrayList;
import java.util.List;

import com.team2.sbucks.dao.order.OrderDao;
import com.team2.sbucks.dto.OrderList;

public class OrderService {

	private OrderDao orderDao;

	public OrderService() {
		orderDao = new OrderDao();
	}

	// 주문입력
	public int createOrder(OrderList order) throws Exception {
		return orderDao.create(order);
	}

	// 주문삭제
	public int deleteOrderAll() throws Exception {
		return 0;
	}

	// 주문 상태 변경
	public int changeOrderStmt(int orderdetail_no) throws Exception {
		return orderDao.updateOrder(orderdetail_no);
	}

	// 회원의 특정 주문내역1개 - 주문상세까지 출력

	public OrderList printOrder(int memberNo, int orderNo) throws Exception {
		OrderList selectOrder = orderDao.selectOrder(memberNo, orderNo);
		return selectOrder;
	}

	// 회원의 전체 주문내역 출력
	public List<OrderList> printAllOrderList(int memberNo) throws Exception {
		List<OrderList> memberOrderList = new ArrayList<OrderList>();
		memberOrderList = orderDao.selectAll(memberNo);
		return memberOrderList;
	}
}
