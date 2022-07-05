package com.team2.sbucks.이동구.order1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import com.team2.sbucks.common.DataSource;



public class OrderDao {
	DataSource dataSource;
	List<OrderDetail> orderDetail;

	public OrderDao() {
		dataSource = new DataSource();
		orderDetail = new ArrayList<OrderDetail>();
	}
	
	//한번에 여러 개 추가 (근데 사용 안할듯?)
	public int insert(int member_no, List<OrderDetail> orderDetail) throws Exception {
		String insertOrder = "insert into orderlist(order_no,order_date,member_no) values (orderList_order_no_SEQ.nextval,sysdate,?)";
		String insertOrderDetail = "insert into orderdetail(orderdetail_no, order_no, order_stmt, product_no,order_qty,product_espresso,product_syrup) values (ORDERDETAIL_ORDERDETAIL_NO_SEQ.nextval,orderList_order_no_SEQ.currval,1,?,?,?,?)";
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt1 = con.prepareStatement(insertOrder);
		PreparedStatement pstmt2 = con.prepareStatement(insertOrderDetail);
		pstmt1.setInt(1, member_no);

		int rowcount1 = pstmt1.executeUpdate();
		for (Iterator<OrderDetail> iterator = orderDetail.iterator(); iterator.hasNext();) {
			OrderDetail orderdetail = (OrderDetail) iterator.next();
			// insertOrderDetail(member_no, orderdetail.getProduct(),
			// orderdetail.getOrder_qty());
			pstmt2.setInt(1, orderdetail.getProduct().getProduct_no());
			pstmt2.setInt(2, orderdetail.getOrder_qty());
			pstmt2.setInt(3, orderdetail.getProduct_espresso());
			pstmt2.setInt(4, orderdetail.getProduct_syrup());
			pstmt2.executeUpdate();
		}

		pstmt1.close();
		pstmt2.close();
		con.close();

		return rowcount1;
	}
	
	//단품 추가
	public int insert(int member_no, Product product, int qty) throws Exception {
		String insertOrder = "insert into orderlist(order_no,order_date,member_no) values (orderList_order_no_SEQ.nextval,sysdate,?)";
		String insertOrderDetail = "insert into orderdetail(orderdetail_no, order_no, order_stmt, product_no,order_qty,product_espresso,product_syrup) values (ORDERDETAIL_ORDERDETAIL_NO_SEQ.nextval,orderList_order_no_SEQ.currval,1,?,?,?,?)";
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt1 = con.prepareStatement(insertOrder);
		PreparedStatement pstmt2 = con.prepareStatement(insertOrderDetail);
		pstmt1.setInt(1, member_no);

		int rowcount1 = pstmt1.executeUpdate();

		pstmt2.setInt(1, product.getProduct_no());
		pstmt2.setInt(2, qty);
		pstmt2.setInt(3, product.getProduct_espresso());
		pstmt2.setInt(4, product.getProduct_syrup());
		pstmt2.executeUpdate();

		pstmt1.close();
		pstmt2.close();
		con.close();

		return rowcount1;
	}
	
	//장바구니에 있는 상품 모두 주문 
	public int cartToOrder(int member_no) throws Exception {
		String insertOrder = "insert into orderlist(order_no,order_date,member_no) values (orderList_order_no_SEQ.nextval,sysdate,?)";
		String cartToOrder = "insert into orderdetail (orderdetail_no, order_no, order_stmt, product_no,order_qty,product_espresso,product_syrup) select ORDERDETAIL_ORDERDETAIL_NO_SEQ.nextval,orderList_order_no_SEQ.currval, 1,c.product_no,c.cart_qty,c.product_espresso,c.product_syrup from cart c where member_no=?";

		Connection con = dataSource.getConnection();
		PreparedStatement pstmt1 = con.prepareStatement(insertOrder);
		PreparedStatement pstmt2 = con.prepareStatement(cartToOrder);
		pstmt1.setInt(1, member_no);
		pstmt2.setInt(1, member_no);

		pstmt1.executeUpdate();
		pstmt2.executeUpdate();
		pstmt1.close();
		pstmt2.close();
		con.close();
		return 0;
	}
	
	
	public int insertOrderList(int member_no) throws Exception {
		String insertOrder = "insert into orderlist(order_no,order_date,member_no) values (orderList_order_no_SEQ.nextval,sysdate,?)";
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt1 = con.prepareStatement(insertOrder);
		pstmt1.setInt(1, member_no);
		int rowcount = pstmt1.executeUpdate();
		pstmt1.close();
		con.close();
		return rowcount;

	}

	public int insertOrderDetail(int member_no, Product product, int qty) throws Exception {
		// String insertOrder = "insert into orderlist(order_no,order_date,member_no)
		// values (orderList_order_no_SEQ.nextval,sysdate,?)";

		String insertOrderDetail = "insert into orderdetail(orderdetail_no, order_no, order_stmt, product_no,order_qty,product_espresso,product_syrup) values (ORDERDETAIL_ORDERDETAIL_NO_SEQ.nextval,orderList_order_no_SEQ.currval,1,?,?,?,?)";

		Connection con = dataSource.getConnection();
		// PreparedStatement pstmt1 = con.prepareStatement(insertOrder);
		PreparedStatement pstmt2 = con.prepareStatement(insertOrderDetail);
		// pstmt1.setInt(1, member_no);

		pstmt2.setInt(1, product.getProduct_no());
		pstmt2.setInt(2, qty);
		pstmt2.setInt(3, product.getProduct_espresso());
		pstmt2.setInt(4, product.getProduct_syrup());
		int rowcount = pstmt2.executeUpdate();

		return rowcount;
	}

	/*public boolean InsertOrder(int member_no,List<OrderDetail> orderDetail) throws Exception{
		boolean check=false;
		if(insertOrderList(member_no)==1) {
			for (Iterator<OrderDetail> iterator = orderDetail.iterator(); iterator.hasNext();) {
				OrderDetail orderdetail = (OrderDetail) iterator.next();
				insertOrderDetail(member_no,orderdetail.getProduct(),orderdetail.getOrder_qty());
				check=true;
			}
			
		}
		
		return check;
	}*/

	public boolean InsertOrder(int member_no, List<OrderDetail> orderDetail) throws Exception {
		boolean check = false;

		for (Iterator<OrderDetail> iterator = orderDetail.iterator(); iterator.hasNext();) {
			OrderDetail orderdetail = (OrderDetail) iterator.next();
			insertOrderDetail(member_no, orderdetail.getProduct(), orderdetail.getOrder_qty());
			check = true;

		}

		return check;
	}
	
	
	
	
	
	
	// 주문번호 총금액(옵션까지넣고 고려하기) 출력



	// 선택된 상품총 금액출력

	public int deleteOrder() {
		return 0;
	}

	// 주문상태(1,2,3,4) 변경
	
	
	public int updateOrder(OrderDetail orderdetail) throws Exception{
		String updateorderstmt = "update orderdetail set order_stmt= ? where order_no =?";
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(updateorderstmt);
		pstmt.setInt(1, orderdetail.getOrder_stmt());
		pstmt.setInt(2, orderdetail.getOrder_no());
		
		int rowCount=pstmt.executeUpdate();
		return rowCount;
	}
	/*public OrderDetail selectorderstmt(int order_stmt) throws Exception{
		OrderDetail  findorder=null;
		String selectorderstmt ="select order_stmt from orderdetail where order_no=?";
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(selectorderstmt);
		pstmt.setInt(1, order_stmt);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			findorder=
					new OrderDetail(rs.getInt("ORDERDETAIL_NO"),
							rs.getInt("ORDER_NO"),
							rs.getInt("ORDER_QTY"),
							rs.getInt("ORDER_STMT");
							
		}
		//rs.close();
		//pstmt.close();
		//con.close();
		//return findorder;
	}
	 */				
	


	// 회원의 주문내역-주문상세 출력
	public Order selectOrderByMemberNo() {
		Order memberOrder = null;
		return memberOrder;
	}

	public List<Order> selectAll() {
		List<Order> orderList = new ArrayList<Order>();

		return orderList;
	}

}
