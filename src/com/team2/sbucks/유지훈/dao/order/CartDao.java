package com.team2.sbucks.유지훈.dao.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.team2.sbucks.유지훈.common.DataSource;
import com.team2.sbucks.유지훈.dto.order.Cart;
import com.team2.sbucks.유지훈.dto.product.Product;
import com.team2.sbucks.유지훈.sql.order.CartSQL;


public class CartDao {
	private DataSource dataSource;
	
	public CartDao() {
		dataSource = new DataSource();
	}
	
	//카트(장바구니)에 상품을 추가한다.
	public int insertCart(Cart cart) throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.CART_INSERT);
		pstmt.setInt(1, cart.getMember_no());
		pstmt.setInt(2, cart.getProduct_no().getProduct_no()); // product 객체 안의 product no로 진입
		pstmt.setInt(3, cart.getCart_qty());
		
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		con.close();
		return rowCount;
	}
	
	//카트(장바구니)에 상품의 수량을 변경(업데이트) 한다.
	public int updateCart(int cartQTY, int memberNo, int productNo) throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.CART_UPDATE);
		pstmt.setInt(1, cartQTY);
		pstmt.setInt(2, memberNo);
		pstmt.setInt(3, productNo);
		
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		con.close();
		return rowCount;
	}
	
	//회원의 카트(장바구니)에서 상품을 전체 삭제한다.
	public int deleteCart(int memberNo) throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.CART_DELETE);
		pstmt.setInt(1, memberNo);
		
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		con.close();
		return rowCount;
	}
	
	//회원의 카트(장바구니)에 제품이 존재하는지 확인. > 숫자로 나타낸다.
	//카트에 제품이 존재하면 수량 추가시 update, 존재하지 않으면 insert
	public int selectCart(int memberNo, int productNo) throws Exception{
		int count = 0;
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.CART_SELECT_BY_NO);
		pstmt.setInt(1, memberNo);
		pstmt.setInt(2, productNo);
		
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			count = rs.getInt(1);
		}
		rs.close();
		pstmt.close();
		con.close();
		return count;
	}
	
	//회원의 카트(장바구니) 전체 출력 (필요한 정보만 출력하려면 * 수정)
	public List<Cart> selectAllCart(int memberNo) throws Exception{
		List<Cart> findCartList = new ArrayList<Cart>();
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.CART_SELECT_ALL);
		pstmt.setInt(1, memberNo);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			findCartList.add(new Cart(rs.getInt("cart_no"),
									  rs.getInt("member_no"),
							 new Product(rs.getInt("product_no"),
									 	 rs.getString("product_name"),
									 	 rs.getInt("product_price"),
									 	 rs.getString("product_allergy"),
									 	 rs.getString("product_content"),
									 	 rs.getInt("product_espresso"),
									 	 rs.getInt("product_syrup"),
									 	 rs.getInt("product_syrupprice"),
									 	 rs.getInt("product_espressoprice")),
							 		  rs.getInt("cart_qty")));
		}
		rs.close();
		pstmt.close();
		con.close();
		return findCartList;
	}
	
	
}
