package com.team2.sbucks.이주희.Order;


public class CartDaoTest {
	public static void main(String[] args) throws Exception{
		CartDao cartDao=new CartDao();
		ProductDao productDao=new ProductDao();
		//1번 회원이 3번상품을 4개 담
		Cart newCartItem=new Cart(0, 1 ,productDao.selectByNo(3),4);
		
		System.out.println("카트에 입력:"+cartDao.addCart(newCartItem));
		
		int memberNo=3;
		System.out.println(memberNo+"번 회원 카트 삭제:"+cartDao.deleteCart(memberNo));
		
		System.out.println(cartDao.selectbyMemebrNo(1));
		
		boolean check=cartDao.checkProductCount(1, 3);
		
		if(check==true) {
			System.out.println("장바구니에 상품 존재");
		}else {
		System.out.println("장바구니에 상품 없음 ");
		}
		
		memberNo=3;
		int productNo=1;
		int productQTY=3;
		
		if(cartDao.checkProductCount(memberNo, productNo)==true){
			cartDao.addProductCount(memberNo, productNo, productQTY);
			System.out.println("이미 장바구니에 존재하는 상품 수량 추가");
		}else {
			cartDao.addCart(new Cart(0, memberNo, productDao.selectByNo(productNo), productQTY));
			System.out.println("장바구니에 새로운 상품 추가");
		}
		
	}

}
