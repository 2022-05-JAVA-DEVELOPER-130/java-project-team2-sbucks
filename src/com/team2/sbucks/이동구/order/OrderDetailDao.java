package com.team2.sbucks.이동구.order;

import com.team2.sbucks.이동구.order.*;
import com.team2.sbucks.이동구.common.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class OrderDetailDao {
	private DataSource dataSource;
	public OrderDetailDao() {
		dataSource = new DataSource();
	}
	
	public int insertOrderDetail(OrderDetail orderDetail) throws Exception{
		Connection con = dataSource.getConncetion();
		PreparedStatement pstmt = con.prepareStatement(OrderDetailSQL.ORDERDETAIL_INSERT);
		pstmt.setInt(1, orderDetail.getOrderDetail_no());
		pstmt.setInt(2, orderDetail.getOrder_qty());
		pstmt.setInt(3, orderDetail.getOrder_stmt());
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		con.close();
		return rowCount;
	}
	
	public int updateOrderDetail(OrderDetail orderDetail) throws Exception{
		Connection con = dataSource.getConncetion();
		PreparedStatement pstmt = con.prepareStatement(OrderDetailSQL.ORDERDETAIL_UPDATE);
		pstmt.setInt(1, orderDetail.getOrderDetail_no()); 
		pstmt.setInt(2, orderDetail.getOrder_no());
		pstmt.setInt(3, orderDetail.getOrder_qty());
		pstmt.setInt(4, orderDetail.getOrder_stmt());
		pstmt.setInt(5, orderDetail.getProduct_no());
		int rowCount = pstmt.executeUpdate();
		return rowCount;
	}
	
	public int deleteOrderDetail(int orderDetail_no) throws Exception{
		Connection con = dataSource.getConncetion();
		PreparedStatement pstmt = con.prepareStatement(OrderDetailSQL.ORDERDETAIL_DELETE);
		pstmt.setInt(1, orderDetail_no);
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		con.close();
		return rowCount;
	}
	
	public OrderDetail selectByNo(int orderDetail_no) throws Exception{
		OrderDetail findOrderDetail = null;
		Connection con = dataSource.getConncetion();
		PreparedStatement pstmt = con.prepareStatement(OrderDetailSQL.ORDERDETAIL_SELECT_BY_NO);
		pstmt.setInt(1, orderDetail_no);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			findOrderDetail = new OrderDetail(rs.getInt("orderDetail_no"),
											  rs.getInt("order_no"),
											  rs.getInt("order_qty"),
											  rs.getInt("order_stmt"),
											  rs.getInt("product_no"));
		}
		rs.close();
		pstmt.close();
		con.close();
		return findOrderDetail;
	}
	
	public List<OrderDetail> selectAll() throws Exception{
		List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
		Connection con = dataSource.getConncetion();
		PreparedStatement pstmt = con.prepareStatement(OrderDetailSQL.ORDERDETAIL_SELECT_ALL);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			orderDetailList.add(new OrderDetail(rs.getInt("orderDetail_no"),
												rs.getInt("order_no"),
												rs.getInt("order_qty"),
												rs.getInt("order_stmt"),
												rs.getInt("product_no")));
		}
		rs.close();
		pstmt.close();
		con.close();
		return orderDetailList;
	}
}
