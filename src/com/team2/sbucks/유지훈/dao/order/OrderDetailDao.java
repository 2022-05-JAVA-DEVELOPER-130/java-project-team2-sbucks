package com.team2.sbucks.유지훈.dao.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.team2.sbucks.유지훈.common.DataSource;
import com.team2.sbucks.유지훈.dto.order.OrderDetail;
import com.team2.sbucks.유지훈.dto.order.OrderList;
import com.team2.sbucks.유지훈.dto.product.Product;
import com.team2.sbucks.유지훈.sql.order.OrderDetailSQL;

public class OrderDetailDao {
	private DataSource dataSource;
	
	// 주문이 들어온다.
	public int insertOrderDetail(OrderDetail orderDetail) throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(OrderDetailSQL.ORDERDETAIL_INSERT);
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
		
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(OrderDetailSQL.ORDERDETAIL_SELECTALL);
		pstmt.setInt(1, orderNo);
		
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			selectAllOrderDetail.add(new OrderDetail(rs.getInt("orderdetail_no"),
									 new OrderList(rs.getInt("order_no"),
											 	   rs.getDate("order_date"),
											 	   rs.getInt("member_no"),
											 	   rs.getInt("order_price")),
									 				 rs.getInt("order_qty"),
									 				 rs.getInt("order_stmt"),
									 new Product(rs.getInt("product_no"),
											 	 rs.getString("product_name"),
												 rs.getInt("product_price"),
												 rs.getString("product_allergy"),
												 rs.getString("product_content"),
												 rs.getInt("product_espresso"),
												 rs.getInt("product_syrup"),
												 rs.getInt("product_syrupprice"),
												 rs.getInt("product_espressoprice"))));
		}
		
		rs.close();
		pstmt.close();
		con.close();
		return selectAllOrderDetail;
	}
}
