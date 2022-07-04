package com.team2.sbucks.유지훈.dao.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.team2.sbucks.유지훈.common.DataSource;
import com.team2.sbucks.유지훈.dto.order.OrderList;
import com.team2.sbucks.유지훈.sql.order.OrderListSQL;

public class OrderListDao {
	
	private DataSource dataSource;
	
	public OrderListDao() {
		dataSource = new DataSource();
	}
	
	// 회원이 상품을 주문한다.
	public int InsertOrder(OrderList orderList) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(OrderListSQL.ORDERLIST_INSERT);
		pstmt.setInt(1, orderList.getMember_no());
		
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		con.close();
		return rowCount;
	}
	
	// 회원이 상품이 마음에 안든대요. (안쓰는 기능)
	public int deleteOrder(OrderList orderList) throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(OrderListSQL.ORDERLIST_DELETE);
		pstmt.setInt(1, orderList.getOrder_no());
		
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
	
	// 회원의 주문 출력.
	public List<OrderList> selectByNo(int memberNo) throws Exception{
		List<OrderList> findOrderList = new ArrayList<OrderList>();
		
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(OrderListSQL.ORDERLIST_SELECTALL_FINDORDERLIST);
		pstmt.setInt(1, memberNo);
		
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			findOrderList.add(new OrderList(rs.getInt("order_no"),
											rs.getDate("order_date"),
											rs.getInt("member_no"),
											rs.getInt("order_price")));
		}
		rs.close();
		pstmt.close();
		con.close();
		return findOrderList;
	}
}
