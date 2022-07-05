package com.team2.sbucks.test.order;

import com.team2.sbucks.dto.Cart;
import com.team2.sbucks.dto.Product;
import com.team2.sbucks.service.CartService;
import com.team2.sbucks.service.ProductService;

public class CartServiceTest {
	public static void main(String[] args) throws Exception {
		CartService cartService=new CartService();
		ProductService productService=new ProductService();
		int memberNo=2;
		Product product=productService.selectByNo(3);
		int cart_qty=10;
		int espresso=1;
		int syrup=3;
		//2번 회원이 3번 상품 
		Cart newCart= new Cart(0, productService.selectByNo(3),memberNo , cart_qty, espresso, syrup);
		
		cartService.insertCart(newCart);
		
		
		//카트 아이템 금액출력
		System.out.println(cartService.cartItemPrice(3));		
		
		//카트 
		System.out.println(cartService.printCart(memberNo));
		
		//로그인한 멤버의 카트전체삭제
		cartService.deleteCart(1);
		
	}

}
