package listdtovo.order;

public class Cart {
	private int cart_no;
	private int product_no;
	private int member_no;
	private int cart_qty;
	
	public Cart() {
		
	}

	public Cart(int cart_no, int product_no, int member_no, int cart_qty) {
		super();
		this.cart_no = cart_no;
		this.product_no = product_no;
		this.member_no = member_no;
		this.cart_qty = cart_qty;
	}

	


	public int getCart_no() {
		return cart_no;
	}

	public void setCart_no(int cart_no) {
		this.cart_no = cart_no;
	}

	public int getProduct_no() {
		return product_no;
	}

	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	public int getCart_qty() {
		return cart_qty;
	}

	public void setCart_qty(int cart_qty) {
		this.cart_qty = cart_qty;
	}
	
	
	@Override
	public String toString() {
		return "Cart [cart_no=" + cart_no + ", product_no=" + product_no + ", member_no=" + member_no + ", cart_qty="
				+ cart_qty + "]";
	}
}
