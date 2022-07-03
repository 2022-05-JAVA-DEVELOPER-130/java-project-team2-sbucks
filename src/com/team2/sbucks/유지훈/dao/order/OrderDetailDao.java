package com.team2.sbucks.유지훈.dao.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.team2.sbucks.유지훈.common.DataSource;
import com.team2.sbucks.유지훈.dto.order.OrderDetail;

public class OrderDetailDao {
	private DataSource dataSource;
	
	public OrderDetailDao() {
		dataSource = new DataSource();
	}
	
	public int insertOrderDetail(OrderDetail orderDetail) throws Exception{
		String orderDetailSQL =
				"insert into orderdetail(orderdetail_no, order_no, order_stmt, product_no, order_qty) values(orderdetail_orderdetail_no_seq.nextval, orderlist_order_no_seq.currval, ?, ?, ?)";
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(orderDetailSQL);
		pstmt.setInt(1, orderDetail.getOrder_stmt());
		pstmt.setInt(2, orderDetail.getProduct_no().getProduct_no());
		pstmt.setInt(3, orderDetail.getOrder_qty());

		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		con.close();
		return rowCount;
	}
	
	public List<OrderDetail> selectAllOrderDetail(int orderNo) throws Exception{
		List<OrderDetail> selectAllOrderDetail = new ArrayList<OrderDetail>();
		String orderDetailSQL = 
				"select o.order_no, o.order_date, p.product_name, d.order_qty from orderlist o join orderdetail d on o.order_no = d.order_no join product p on d.product_no = p.product_no where o.order_no = ?";
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(orderDetailSQL);
		pstmt.setInt(1, orderNo);
		
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			selectAllOrderDetail.add(new OrderDetail(rs.getInt("orderdetail_no"),
									 new OrderList(rs.)));
		}
		
		
		rs.close();
		pstmt.close();
		con.close();
		return null;
	}
}
