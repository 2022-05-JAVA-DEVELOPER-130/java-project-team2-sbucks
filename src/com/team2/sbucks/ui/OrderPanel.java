package com.team2.sbucks.ui;

import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import com.team2.sbucks.dto.Cart;
import com.team2.sbucks.dto.Product;
import com.team2.sbucks.service.CartService;
import com.team2.sbucks.service.OrderService;
import com.team2.sbucks.service.ProductService;

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
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class OrderPanel extends JPanel {
	private OrderService orderService;
	private CartService cartService;
	private ProductService productService;
	Product product;
	
	int product_no=3;
	/**
	 * Create the panel.
	 */
	public OrderPanel() {
		
		JLabel coffeeLB = new JLabel("에스프레소");
		
		JLabel sypUpLB = new JLabel("시럽");
		
		JLabel countLB = new JLabel("수량");
		
		JComboBox coffeeCB = new JComboBox();
		coffeeCB.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		
		JComboBox sypUpCB = new JComboBox();
		sypUpCB.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		
		JComboBox countCB = new JComboBox();
		countCB.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		
		
		
		JButton cartJoinBtn = new JButton("담기");
		cartJoinBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Product newProduct=new Product();
					//Product product = productService.selectByNo(product_no);
					cartService.insertCart(null);//카트 수량체크 후 담기 메소드. 매개변수 어디서 끌고오는가
				} catch (Exception e2) {

				}
				
			}
		});
		
		JButton orderBtn = new JButton("주문하기");
		orderBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Product product = productService.selectByNo(1);
					
					orderService.createOneOrder(1, product, 1);
				} catch (Exception e2) {

				}
			}
		});
		
		JLabel item_imgLB = new JLabel("상품이미지");
		
		
		JLabel item_nameLB = new JLabel("상품이름");
		
		JLabel totalPriceLB = new JLabel("총가격");
		
		JLabel item_PriceLB = new JLabel("Price원");
		
		JButton o_CancelBtn = new JButton("취소");
		
		
		
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
	

	
}
