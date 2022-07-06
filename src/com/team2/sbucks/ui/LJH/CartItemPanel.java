package com.team2.sbucks.ui.LJH;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;

import com.team2.sbucks.dto.Cart;
import com.team2.sbucks.service.CartService;
import com.team2.sbucks.service.OrderService;

import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ItemEvent;

public class CartItemPanel extends JPanel {
	private CartService cartService;
	private OrderService orderService;

	int memberNo = 2;
	int cartNo = 0;
	private JPanel cartItemBasicPanel;
	private JPanel cartItem_panel;
	private List<Cart> cartLastList;
	
	private List<JPanel> panelList;
	private List<Integer> cartNoList;

	private CartTestFrame mainFrame;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JPanel panel_1;
	private JButton selectOrderBtn;
	private JButton allOrderBtn;
	private JLabel c_imgLB_1;
	private JLabel c_itemNameLB_1;
	private JCheckBox cartCHB_1;
	private JComboBox comboBox_1;
	private JLabel c_espressoLB;
	private JLabel c_syrupLB;
	private JLabel c_priceLB;
	private JLabel c_addshotLB;
	private JLabel c_addsyrupLB;
	private JScrollPane scrollPane;
	private JPanel panel_2;
	private JLabel cartCountLB;
	private JButton deleteAllBtn;
	private JButton deleteSelectBtn;

	/**
	 * Create the panel.
	 */
	public CartItemPanel() {
		cartService = new CartService();
		orderService = new OrderService();
		cartLastList = new ArrayList<Cart>();

		setLayout(new BorderLayout(0, 0));

		panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));

		lblNewLabel = new JLabel("장바구니");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 31));
		panel.add(lblNewLabel);

		panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));

		deleteAllBtn = new JButton("전체 비우기");
		deleteAllBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cartService.deleteCart(memberNo);
					System.out.println("다시 부르기");
					cartListDisplay(memberNo);

				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		panel_1.add(deleteAllBtn, BorderLayout.EAST);

		deleteSelectBtn = new JButton("선택 삭제");
		deleteSelectBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					for (int i=0;i<panelList.size();i++) {
						//panelList.get(i).
						if(cartCHB_1.isSelected()) {
							cartLastList.add(cartService.selectCart(cartNoList.get(i)));
						}
						
					}
					for (int i = 0; i < cartLastList.size(); i++) {
						int cartNo=cartLastList.get(i).getCart_no();
						cartService.deleteCartItem(cartNo);
					}
					cartListDisplay(memberNo);
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		panel_1.add(deleteSelectBtn, BorderLayout.WEST);

		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		cartItemBasicPanel = new JPanel();
		cartItemBasicPanel.setPreferredSize(new Dimension(10, 800));
		scrollPane.setViewportView(cartItemBasicPanel);

		cartItem_panel = new JPanel();
		cartItem_panel.setPreferredSize(new Dimension(400, 180));
		cartItemBasicPanel.add(cartItem_panel);
		cartItem_panel.setLayout(null);

		c_imgLB_1 = new JLabel("이미지");
		c_imgLB_1.setBounds(62, 41, 106, 108);
		cartItem_panel.add(c_imgLB_1);

		c_itemNameLB_1 = new JLabel("상품이름");
		c_itemNameLB_1.setBounds(194, 20, 136, 15);
		cartItem_panel.add(c_itemNameLB_1);

		cartCHB_1 = new JCheckBox("");
		cartCHB_1.setBounds(52, 12, 115, 23);
		cartItem_panel.add(cartCHB_1);

		comboBox_1 = new JComboBox();

		comboBox_1
				.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
		comboBox_1.setBounds(194, 109, 32, 23);
		cartItem_panel.add(comboBox_1);
		comboBox_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					String qty = (String) comboBox_1.getSelectedItem();
					int iqty = Integer.parseInt(qty);
					cartService.addProductCount(iqty, cartNo);
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}

			}
		});

		c_espressoLB = new JLabel("추가 샷 숫자");
		c_espressoLB.setBounds(270, 41, 57, 15);
		cartItem_panel.add(c_espressoLB);

		c_syrupLB = new JLabel("추가시럽 숫자");
		c_syrupLB.setBounds(270, 75, 57, 15);
		cartItem_panel.add(c_syrupLB);

		c_priceLB = new JLabel("가격");
		c_priceLB.setBounds(194, 155, 57, 15);
		cartItem_panel.add(c_priceLB);

		c_addshotLB = new JLabel("추가 샷");
		c_addshotLB.setBounds(194, 41, 57, 15);
		cartItem_panel.add(c_addshotLB);

		c_addsyrupLB = new JLabel("추가 시럽");
		c_addsyrupLB.setBounds(194, 75, 57, 15);
		cartItem_panel.add(c_addsyrupLB);

		panel_2 = new JPanel();
		add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new BorderLayout(0, 0));

		cartCountLB = new JLabel("총 몇개");
		panel_2.add(cartCountLB, BorderLayout.WEST);

		selectOrderBtn = new JButton("선택 주문");
		panel_2.add(selectOrderBtn, BorderLayout.EAST);

		allOrderBtn = new JButton("전체 주문");
		panel_2.add(allOrderBtn, BorderLayout.CENTER);
		allOrderBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					orderService.allCartToOrder(memberNo);
					System.out.println("주문완료");
					cartListDisplay(memberNo);
				} catch (Exception e1) {
					e1.printStackTrace();
					// TODO: handle exception
				}

			}
		});

		selectOrderBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					orderService.cartitemToOrder(memberNo, cartLastList);
					cartListDisplay(memberNo);

				} catch (Exception e2) {
					e2.printStackTrace();
				}

			}
		});

	}// 생성자 끝

	public void cartListDisplay(int memberNo) throws Exception {
		List<Cart> cartList = new ArrayList<Cart>();
		cartList = cartService.printCart(memberNo);

		cartItemBasicPanel.removeAll();

		for (int i = 0; i < cartList.size(); i++) {
			Cart cart = cartList.get(i);
			cartItem_panel = new JPanel();


			cartItem_panel.setPreferredSize(new Dimension(400, 180));
			cartItemBasicPanel.add(cartItem_panel);

			cartItem_panel.setLayout(null);

			JLabel c_imgLB = new JLabel("이미지");
			c_imgLB.setIcon(new ImageIcon(
					CartItemPanel.class.getResource("/images/" + cart.getProduct().getProduct_name() + ".jpg")));
			c_imgLB.setBounds(62, 41, 106, 108);
			cartItem_panel.add(c_imgLB);

			JLabel c_itemNameLB = new JLabel(cart.getProduct().getProduct_name());
			c_itemNameLB.setBounds(194, 20, 136, 15);
			cartItem_panel.add(c_itemNameLB);

			JCheckBox cartCHB_1 = new JCheckBox("");
			cartCHB_1.setBounds(52, 12, 115, 23);
			cartItem_panel.add(cartCHB_1);

			JComboBox comboBox = new JComboBox();

			comboBox.setModel(
					new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
			comboBox.setBounds(194, 109, 32, 23);
			cartItem_panel.add(comboBox);

			comboBox.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					try {
						String qty = (String) comboBox.getSelectedItem();
						int iqty = Integer.parseInt(qty);
						cartService.addProductCount(iqty, cart.getCart_no());
					} catch (Exception e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}

				}
			});

			c_addshotLB = new JLabel("추가 샷");
			c_addshotLB.setBounds(194, 41, 57, 15);
			cartItem_panel.add(c_addshotLB);

			c_addsyrupLB = new JLabel("추가 시럽");
			c_addsyrupLB.setBounds(194, 75, 57, 15);
			cartItem_panel.add(c_addsyrupLB);

			JLabel c_espressoLB1 = new JLabel(cart.getProduct_espresso() + "");
			c_espressoLB1.setBounds(270, 41, 57, 15);
			cartItem_panel.add(c_espressoLB1);

			JLabel c_syrupLB = new JLabel(cart.getProduct_syrup() + "");
			c_syrupLB.setBounds(270, 75, 57, 15);
			cartItem_panel.add(c_syrupLB);

			JLabel c_priceLB = new JLabel(cart.getCart_qty() * (cart.getProduct().getProduct_price()
					+ (cart.getProduct_espresso() * cart.getProduct().getProduct_espressoprice())
					+ cart.getProduct_syrup() * cart.getProduct().getProduct_syrupprice()) + "원");
			c_priceLB.setBounds(194, 155, 57, 15);
			cartItem_panel.add(c_priceLB);
			
			//panelList.add(cartItem_panel);
			//cartNoList.add(cart.getCart_no());
		}

		cartCountLB = new JLabel("총 " + cartList.size() + " 개");
		panel_2.add(cartCountLB, BorderLayout.WEST);

		/*JPanel cartCountPanel = new JPanel();
		add(cartCountPanel, BorderLayout.SOUTH);
		cartCountPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel cartCountLB = new JLabel("총" + cartList.size() + "수");
		cartCountLB.setFont(new Font("굴림", Font.PLAIN, 19));
		cartCountPanel.add(cartCountLB, BorderLayout.NORTH);*/

	}

	public void setFrame(CartTestFrame mainFrame) {
		this.mainFrame = mainFrame;

		try {
			if (mainFrame.memberNo > 0) {
				cartListDisplay(mainFrame.memberNo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
