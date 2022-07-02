package listdao.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.DataSource;
import listdtovo.order.Cart;
import listsql.order.CartSQL;

public class CartDao {
	private DataSource dataSource;
	public CartDao() {
		dataSource = new DataSource();
	}
	
	public int insertCart(Cart cart) throws Exception{
		Connection con = dataSource.getConncetion();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.CART_INSERT);
		pstmt.setInt(1, cart.getCart_no());
		pstmt.setInt(2, cart.getProduct_no());
		pstmt.setInt(3, cart.getMember_no());
		pstmt.setInt(4, cart.getCart_qty());
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		con.close();
		return rowCount;
	}
	
	public int updateCart(Cart cart) throws Exception{
		Connection con = dataSource.getConncetion();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.CART_UPDATE);
		pstmt.setInt(1, cart.getProduct_no());
		pstmt.setInt(2, cart.getMember_no());
		pstmt.setInt(3, cart.getCart_qty());
		pstmt.setInt(4, cart.getCart_no());
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		con.close();
		return rowCount;
	}
	
	public int deleteCast(int cart_no) throws Exception{
		Connection con = dataSource.getConncetion();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.CART_DELETE);
		pstmt.setInt(1, cart_no);
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		con.close();
		return rowCount;
	}
	
	public Cart selectByNo(int cart_no) throws Exception{
		Cart findCart = null;
		Connection con = dataSource.getConncetion();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.CART_SELECT_BY_NO);
		pstmt.setInt(1, cart_no);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			findCart = new Cart(rs.getInt("cart_no"),
								rs.getInt("product_no"),
								rs.getInt("member_no"),
								rs.getInt("cart_qty"));
		}
		rs.close();
		pstmt.close();
		con.close();
		return findCart;
	}
	
	public List<Cart> selectAll() throws Exception{
		List<Cart> cartList = new ArrayList<Cart>();
		Connection con = dataSource.getConncetion();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.CART_SELECT_ALL);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			cartList.add(new Cart(rs.getInt("cart_no"),
								  rs.getInt("product_no"),
								  rs.getInt("member_no"),
								  rs.getInt("cart_qty")));
}
		rs.close();
		pstmt.close();
		con.close();
		return cartList;
	}
	
	
	
}
