package com.team2.sbucks.유지훈.test;

import java.util.Date;

import com.team2.sbucks.유지훈.dao.order.OrderListDao;
import com.team2.sbucks.유지훈.dto.order.OrderList;

public class OrderListDaoTest {

	public static void main(String[] args) throws Exception {
		OrderListDao orderListDao = new OrderListDao();
		Date now = new Date();
		
		//1번 회원이 주문한다.
		//주문번호 1, 날짜 현재시각, 회원번호 1, 총 가격 6000
		OrderList orderList = new OrderList(1, now, 1, 6000);
		int insertCount = orderListDao.InsertOrder(orderList);
		System.out.println("1번 회원이 주문했습니다 : " + insertCount);
		
		//회원 주문 개수 COUNT
		int countOrder = orderListDao.CountOrder(1);
		System.out.println("1번 회원의 주문 개수 : " + countOrder);
		
	}

}
