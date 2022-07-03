package com.team2.sbucks.유지훈.dao.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.team2.sbucks.유지훈.common.DataSource;

public class OrderListDao {
	
	private DataSource dataSource;
	
	public OrderListDao() {
		dataSource = new DataSource();
	}
	
	// 회원이 상품을 주문한다.
	public int InsertOrder(int memberNo) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(OrderListSQL.ORDERLIST_INSERT);
		pstmt.setInt(1, memberNo);
		
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		con.close();
		return rowCount;
	}
	
	// 회원이 상품이 마음에 안든대요.
	public int deleteOrder(int orderNo) throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(OrderListSQL.ORDERLIST_DELETE);
		pstmt.setInt(1, orderNo);
		
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		con.close();
		return rowCount;
	}
	
	//회원 주문 개수 COUNT
	public int CountOrder(int memberNo) throws Exception{
		int count = 0;
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(OrderListSQL.ORDERLIST_SELECT_BY_COUNT);
		pstmt.setInt(1, memberNo);
		
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			count = rs.getInt(1);
		}
		rs.close();
		pstmt.close();
		con.close();
		return count;
	}
	
}
