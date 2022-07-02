package listsql.order;

public class OrderListSQL {
	public static final String ORDERLIST_INSERT
	="insert into OrderList values(order_order_NO_SEQ.nextval,?,?,?)";
	public static final String ORDERLIST_UPDATE
	="update OrderList set ORDER_date=?,member_no=?,ORDER_price=? where order_no =?";
	public static final String ORDERLIST_DELETE
	="delete from OrderList where ORDER_NO=?";
	public static final String ORDERLIST_SELECT_BY_NO
	="select * from OrderList where ORDER_NO=?";
	public static final String ORDERLIST_SELECT_ALL
	="select * from OrderList";
}
