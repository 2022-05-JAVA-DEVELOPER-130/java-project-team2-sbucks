package com.team2.sbucks.이동구.order1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.team2.sbucks.dto.Product;
import com.team2.sbucks.이동구.Cart;
import com.team2.sbucks.이동구.order1.common.DataSource;








public class CartDao {
	
	private DataSource dataSource;
	
	public CartDao() {
		// TODO Auto-generated constructor stub
		dataSource=new DataSource();
	}
	
	public int addCart(Cart cartitem) throws Exception {
		Connection con = dataSource.getConncetion();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.CART_INSERT);

		//pstmt.setInt(1, cartitem.getProduct().getProduct_no());
		pstmt.setInt(2, cartitem.getMember_no());
		pstmt.setInt(3, cartitem.getCart_qty());
		

		int rowCount = pstmt.executeUpdate();

		con.close();
		pstmt.close();

		return rowCount;
		
	}
	
	//회원의  카트에서 상품 전체 삭제  -- 선택 삭제/주문하려면 체크 칼럼 추가 
	public int deleteCart(int memberNo)throws Exception {
		Connection con = dataSource.getConncetion();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.CART_DELETE);

		pstmt.setInt(1, memberNo);
		int rowCount = pstmt.executeUpdate();

		con.close();
		pstmt.close();
		return rowCount;
	}
	
	
	//상품이 회원 장바구니에 이미 존재하는지 확인 
	public boolean checkProductCount(int memberNo,int productNo) throws Exception {
		boolean check =false;
		Connection con = dataSource.getConncetion();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.CART_CHECK);
		
		
		pstmt.setInt(1, memberNo);
		pstmt.setInt(2, productNo);
		
		ResultSet rs=pstmt.executeQuery();
		rs.next();
		int productCheck=rs.getInt(1);
		if(productCheck>=1) {
			check=true;
		}
		
		
		return check;
	}
	
	//장바구니 상품의 수량 업데이트 
	public int addProductCount(int memberNo,int productNo,int productQTY) throws Exception{
		Connection con = dataSource.getConncetion();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.CART_UPDATE);
		pstmt.setInt(1, productQTY);
		pstmt.setInt(2, memberNo);
		pstmt.setInt(3, productNo);
		int rowCount=pstmt.executeUpdate();
		return rowCount;
	}
	
	/*
	이름                    널?       유형            
			--------------------- -------- ------------- 
			PRODUCT_NO            NOT NULL NUMBER(10)    
			PRODUCT_NAME                   VARCHAR2(50)  
			PRODUCT_PRICE                  NUMBER(20)    
			PRODUCT_ALLERGY                VARCHAR2(500) 
			PRODUCT_CONTENT                VARCHAR2(500) 
			PRODUCT_ESPRESSO               NUMBER(10)    
			PRODUCT_SYRUP                  NUMBER(10)    
			PRODUCT_SYRUPPRICE             NUMBER(10)    
			PRODUCT_ESPRESSOPRICE          NUMBER(10)    
			*/
			
	//회원의 장바구니 전체 출력 
	public List<Cart> selectbyMemebrNo(int memberNo) throws Exception{
		List<Cart> findCartList=new ArrayList<Cart>();
		Connection con = dataSource.getConncetion();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.CART_SELECT);
		
		pstmt.setInt(1, memberNo);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			/*
			findCartList.add(new Cart(rs.getInt("cart_no"), rs.getInt("member_no"),
					new Product(rs.getInt("product_no"), rs.getString("product_name"), 
							rs.getInt("product_price"), rs.getString("product_allergy"), rs.getString("product_content"), 
							rs.getInt("product_espresso"), rs.getInt("product_syrup"), rs.getInt("product_syrupprice"), rs.getInt("product_espressoprice")),   
					rs.getInt("cart_qty")));
			*/
		}
		rs.close();
		pstmt.close();
		con.close();
		
		
		return findCartList;
	}
	
	

}