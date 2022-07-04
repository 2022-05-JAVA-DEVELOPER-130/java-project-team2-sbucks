package com.team2.sbucks.유지훈.test;

import com.team2.sbucks.유지훈.dao.order.CartDao;
import com.team2.sbucks.유지훈.dao.product.ProductDao;
import com.team2.sbucks.유지훈.dto.order.Cart;

public class CartDaoTest {
	public static void main(String[] args) throws Exception{
		CartDao cartDao = new CartDao();
		ProductDao productDao = new ProductDao();
		

		// 2번 회원이 2번 상품을 1개 담았다.
		Cart newCart = new Cart(1, 2, productDao.selectByNo(1), 1);
		System.out.println("장바구니 입력: "+cartDao.insertCart(newCart));

	}
}
