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

public class OrderPaneljiHun extends JPanel {
	private OrderService orderService;
	private CartService cartService;
	private ProductService productService;
	private JTextField totPriceTF;
	private JTextField productNameTF;
	/**
	 * Create the panel.
	 */
	public OrderPaneljiHun() {
		
		JLabel coffeeLB = new JLabel("에스프레소");
		
		JLabel sypUpLB = new JLabel("시럽");
		
		JLabel countLB = new JLabel("수량");
		
		JComboBox coffeeCB = new JComboBox();
		coffeeCB.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		
		JComboBox sypUpCB = new JComboBox();
		sypUpCB.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		
		JComboBox countCB = new JComboBox();
		countCB.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		
		JButton cartJoinNB = new JButton("담기");
		cartJoinNB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Product product = productService.selectByNo(1);
					cartService.insertCart(null);//카트 수량체크 후 담기 메소드. 매개변수 어디서 끌고오는가
				} catch (Exception e2) {

				}
				
			}
		});
		
		JButton orderNB = new JButton("주문하기");
		orderNB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Product product = productService.selectByNo(1);
					
					orderService.createOneOrder(1, product, 1);
				} catch (Exception e2) {

				}
			}
		});
		
		totPriceTF = new JTextField();
		totPriceTF.setEditable(false);
		totPriceTF.setText("총 가격");
		totPriceTF.setColumns(10);
		
		JButton optionUpdateBtn = new JButton("확인");
		optionUpdateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		productNameTF = new JTextField();
		productNameTF.setEditable(false);
		productNameTF.setText("상품 이름");
		productNameTF.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(88)
							.addComponent(coffeeLB, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addGap(65)
							.addComponent(coffeeCB, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(88)
							.addComponent(sypUpLB, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addGap(65)
							.addComponent(sypUpCB, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(88)
							.addComponent(countLB, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addGap(65)
							.addComponent(countCB, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(127)
							.addComponent(optionUpdateBtn, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(127)
							.addComponent(totPriceTF, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(54)
							.addComponent(orderNB, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addGap(69)
							.addComponent(cartJoinNB, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(34)
							.addComponent(productNameTF, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(25, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(productNameTF, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addGap(52)
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
							.addComponent(countCB, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
					.addGap(26)
					.addComponent(optionUpdateBtn)
					.addGap(26)
					.addComponent(totPriceTF, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(orderNB)
						.addComponent(cartJoinNB)))
		);
		setLayout(groupLayout);

	}
}
