package com.team2.sbucks.service;

import java.util.ArrayList;
import java.util.List;

import com.team2.sbucks.dao.order.CartDao;
import com.team2.sbucks.dto.Cart;

public class CartService {
	public CartDao cartDao;

	public CartService() {
		cartDao = new CartDao();
	}

	// 카트 담기(수량체크후 담기)
	public int insertCart(Cart cart) throws Exception {
		int cart_no = cartDao.returnCartno(cart);
		
		if (cartDao.returnCartno(cart) == 0) {
			System.out.println("존재하지 않는 상품이므로 새롭게 추가");
			cartDao.addCart(cart);
		} else {
			cartDao.addProductCount(cart.getCart_qty(), cart_no);
			System.out.println("이미 존재하는 상품이므로 수량 추가");
		}
		return 0;
	}

	// 카트 전체 삭제
	public int deleteCart(int memberNo) throws Exception {
		cartDao.deleteCart(memberNo);
		return 0;
	}

	// 회원의 카트 전체 출력
	public List<Cart> printCart(int memberNo) throws Exception {
		List<Cart> memberCartList = new ArrayList<Cart>();
		memberCartList = cartDao.selectbyMemebrNo(memberNo);
		return memberCartList;

	}
	
	//카트 번호로 해당 카트 아이템 가격 출력
	public int cartItemPrice(int cartNo) throws Exception{
		return cartDao.CartItemPrice(cartNo);
	}

}
