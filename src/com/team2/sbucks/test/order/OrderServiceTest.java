package com.team2.sbucks.test.order;

import com.team2.sbucks.dao.order.CartDao;
import com.team2.sbucks.dto.Product;
import com.team2.sbucks.service.CartService;
import com.team2.sbucks.service.OrderService;
import com.team2.sbucks.service.ProductService;

public class OrderServiceTest {
	public static void main(String[] args) throws Exception {
		OrderService orderService = new OrderService();
		ProductService productService = new ProductService();
		CartService cartService = new CartService();

		CartDao cartDao = new CartDao();

		int memberNo = 10;
		int espresso = 5;
		int syrup = 8;
		Product product = productService.selectByNo(4);
		product.setProduct_espresso(espresso);
		product.setProduct_syrup(syrup);
		int qty = 80;
		// 주문 입력 1 단품 입력
		orderService.createOneOrder(memberNo, product, qty);

		memberNo = 3;
		// 주문 입력 2 카트 그대로 입력
		orderService.createCartToOrder(memberNo);

		System.out.println(cartDao.selectbyMemberNo(memberNo));
		// 주문상태 변경
		int order_detailno=25;
		orderService.changeOrderStmt(25);
		// 특정 주문내역 1개 출력
		System.out.println("특정 주문내역");
		System.out.println(orderService.printOrder(memberNo, 24));

		// 회원의 모든 주문내역 (상세 포함 x) 출력
		System.out.println("모든 주문내역");
		System.out.println(orderService.printAllOrderList(memberNo));
		
		//주문삭제
		int order_no=24;
		orderService.deleteOrder(order_no);
	}

}
