package com.team2.sbucks.ui;

import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import com.team2.sbucks.dto.Cart;
import com.team2.sbucks.dto.Product;
import com.team2.sbucks.service.CartService;
import com.team2.sbucks.service.OrderService;
import com.team2.sbucks.service.ProductService;
import com.team2.sbucks.ui.LJH.OrderListPanel;
import com.team2.sbucks.ui.LJH.OrderListTestFrame;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;
import java.util.Vector;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class OrderPanel extends JPanel {
	private OrderService orderService;
	private CartService cartService;
	private ProductService productService;
	Product product;
	int memberNo=1;
	int product_no=3;
	private OrderListTestFrame mainFrame;
	private JButton orderBtn;
	private JButton cartJoinBtn;
	private JLabel coffeeLB;
	private JComboBox coffeeCB;
	private JLabel sypUpLB;
	private JComboBox sypUpCB;
	private JLabel countLB;
	private JComboBox countCB;
	private JLabel item_imgLB;
	private JButton o_CancelBtn;
	private JLabel item_nameLB;
	private JLabel totalPriceLB;
	private JLabel item_PriceLB;
	/**
	 * Create the panel.
	 */
	public OrderPanel()  {
		productService=new ProductService();
		orderService=new OrderService();
		cartService=new CartService();
		
		
		try {
			product=productService.selectByNo(product_no);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		coffeeLB = new JLabel("에스프레소");
		
		sypUpLB = new JLabel("시럽");
		
		countLB = new JLabel("수량");
		
		coffeeCB = new JComboBox();
		coffeeCB.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		
		sypUpCB = new JComboBox();
		sypUpCB.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		
		countCB = new JComboBox();
		countCB.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		
		
		
		cartJoinBtn = new JButton("담기");
		cartJoinBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					System.out.println("장바구니");
					
					product=productService.selectByNo(product_no);
					String qty=(String) countCB.getSelectedItem();
					int iqty=Integer.parseInt(qty);
					System.out.println("중간");
					
					String syrup=(String)sypUpCB.getSelectedItem();
					int isyrup=Integer.parseInt(syrup);
					
					String espresso=(String)coffeeCB.getSelectedItem();
					int iespresso=Integer.parseInt(espresso);
					
					
					product.setProduct_espresso(iespresso);
					product.setProduct_syrup(isyrup);
					
					
					
					cartService.insertCart(product,memberNo,iqty);
					System.out.println("담겼음");
				
					
				} catch (Exception e2) {

				}
				
				
			}
		});
		
		
		orderBtn = new JButton("주문하기");
		orderBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					System.out.println("주문");
					
					product=productService.selectByNo(product_no);
					String qty=(String) countCB.getSelectedItem();
					int iqty=Integer.parseInt(qty);
					System.out.println("중간");
					
					String syrup=(String)sypUpCB.getSelectedItem();
					int isyrup=Integer.parseInt(syrup);
					
					String espresso=(String)coffeeCB.getSelectedItem();
					int iespresso=Integer.parseInt(espresso);
					
					
					product.setProduct_espresso(iespresso);
					product.setProduct_syrup(isyrup);
					
					orderService.createOneOrder(memberNo, product, iqty);
					
					System.out.println("주문완료");
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		
		
		item_imgLB = new JLabel("상품이미지");
		item_imgLB.setIcon(new ImageIcon(
				OrderListPanel.class.getResource("/images/" +product.getProduct_name() + ".jpg")));

		
		
		item_nameLB = new JLabel(product.getProduct_name());
		
		totalPriceLB = new JLabel("총가격");
		/*int qty=(int)countCB.getSelectedItem();
		int syrup=(int)sypUpCB.getSelectedItem();
		int espresso=(int)coffeeCB.getSelectedItem();
		*/
		item_PriceLB = new JLabel("원");
		/*
		item_PriceLB.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				item_PriceLB.setText(qty*(product.getProduct_price()+(product.getProduct_espressoprice()*syrup)+(product.getProduct_syrupprice()*espresso))+"원");
			}
		});
		*/
		o_CancelBtn = new JButton("취소");
		o_CancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.tabbedPane.setSelectedIndex(0);
				
			}
		});
		
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(54)
					.addComponent(orderBtn, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addGap(69)
					.addComponent(cartJoinBtn, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(89)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(coffeeLB, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addGap(65)
							.addComponent(coffeeCB, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(sypUpLB, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addGap(65)
							.addComponent(sypUpCB, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(countLB, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addGap(65)
							.addComponent(countCB, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(134)
					.addComponent(item_imgLB, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
					.addComponent(o_CancelBtn))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(151)
					.addComponent(item_nameLB))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(79)
					.addComponent(totalPriceLB)
					.addGap(48)
					.addComponent(item_PriceLB, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(24)
							.addComponent(item_imgLB, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(item_nameLB)
							.addGap(30)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(coffeeLB, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(coffeeCB, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
							.addGap(32)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(sypUpLB, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(2)
									.addComponent(sypUpCB, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
							.addGap(28)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(countLB, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(2)
									.addComponent(countCB, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(o_CancelBtn)))
					.addGap(62)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(totalPriceLB)
						.addComponent(item_PriceLB))
					.addGap(68)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(orderBtn)
						.addComponent(cartJoinBtn)))
		);
		setLayout(groupLayout);

	}
	
//생성자끝
	public void setFrame(OrderListTestFrame mainFrame) {
		this.mainFrame=mainFrame;
		
	}

	
}
