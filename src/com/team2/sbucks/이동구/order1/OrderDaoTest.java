package com.team2.sbucks.이동구.order1;

import java.util.ArrayList;
import java.util.List;



public class OrderDaoTest {
	public static void main(String[] args) throws Exception {
		OrderDao orderdao = new OrderDao();
		ProductDao productDao = new ProductDao();
		
		// 1번 회원이 3번 상품 4개 (에스프레소 1, 시럽0) 2번 상품 5개 (에스프레소 3, 시럽 3) 주문

		Product product3 = productDao.selectByNo(3);
		product3.setProduct_espresso(1);
		product3.setProduct_syrup(0);

		Product product2 = productDao.selectByNo(2);
		product2.setProduct_espresso(3);
		product2.setProduct_syrup(3);

		List<OrderDetail> orderdetailList = new ArrayList<OrderDetail>();
		orderdetailList.add(
				new OrderDetail(0, 0, 5, 0, product2, product2.getProduct_espresso(), product2.getProduct_syrup()));
		orderdetailList.add(
				new OrderDetail(0, 0, 4, 0, product3, product3.getProduct_espresso(), product3.getProduct_syrup()));

		orderdao.insert(1, orderdetailList);
		/*orderdao.insertOrderList(1);
		orderdao.InsertOrder(1, orderdetailList);*/

		orderdao.insert(2, product3, 4);
		
		orderdao.cartToOrder(3);

	}

}
