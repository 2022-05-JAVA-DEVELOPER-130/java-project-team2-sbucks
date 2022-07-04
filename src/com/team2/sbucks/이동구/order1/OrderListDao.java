package com.team2.sbucks.이동구.order1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.team2.sbucks.이동구.common.DataSource;







public class OrderListDao {
	
	private DataSource dataSource;
	
	public OrderListDao() {
		// TODO Auto-generated constructor stub
		dataSource=new DataSource();
	}
	
	
	public int addOrderList(OrderList orderlist) throws Exception {
		Connection con = dataSource.getConncetion();
		PreparedStatement pstmt = con.prepareStatement(OrderListSQL.ORDER_INSERT);

		pstmt.setInt(1, orderlist.getOrder_no());
		pstmt.setDate(2, orderlist.getOrder_date());
		pstmt.setInt(3, orderlist.getOrder_price());
		

		int rowCount = pstmt.executeUpdate();

		con.close();
		pstmt.close();

		return rowCount;
		
	}
	
	
	
	
	//장바구니 상품의 수량 업데이트 
	public int selectByNo(int order_price) throws Exception{
		int findPrice=0;
		Connection con = dataSource.getConncetion();
		PreparedStatement pstmt = con.prepareStatement(OrderListSQL.ORDER_PRICE);
		ResultSet rs = pstmt.executeQuery();
		pstmt.setInt(1, order_price);
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			//findPrice = new OrderList( rs.getInt("order_price"));
		}
		rs.close();
		con.close();
		pstmt.close();
		return findPrice;
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
	
	
	

}