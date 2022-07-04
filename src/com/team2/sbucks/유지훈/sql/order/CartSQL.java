package com.team2.sbucks.유지훈.sql.order;

public class CartSQL {
	//카트(장바구니)에 상품을 추가한다.
	public static final String CART_INSERT
	="insert into cart(cart_no, member_no, product_no, cart_qty) values(cart_cart_no_seq.nextval, ?, ?, ?)";
	
	//카트(장바구니)에 상품의 수량을 변경(업데이트) 한다.
	public static final String CART_UPDATE
	="update cart set cart_qty = cart_qty+? where member_no = ? and product_no = ?";
	
	//회원의 카트(장바구니)에서 상품을 전체 삭제한다.
	public static final String CART_DELETE
	="delete cart where member_no = ?";

	//회원의 카트(장바구니)에 제품이 존재하는지 확인. > 숫자로 나타낸다.
	//카트에 제품이 존재하면 수량 추가시 update, 존재하지 않으면 insert
	public static final String CART_SELECT_BY_NO
	="select count(*) from cart where member_no = ? and product_no = ?";
	
	//회원의 카트(장바구니) 전체 출력 (필요한 정보만 출력하려면 * 수정)
	public static final String CART_SELECT_ALL
	="select * from cart c join product p on c.product_no = p.product_no where member_no = ?";
}
