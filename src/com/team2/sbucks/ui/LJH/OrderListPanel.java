package com.team2.sbucks.ui.LJH;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.team2.sbucks.dto.OrderList;
import com.team2.sbucks.service.OrderService;

import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.awt.Dimension;
import javax.swing.JSplitPane;

public class OrderListPanel extends JPanel {
	private JPanel orderListPanel;
	private OrderService orderService;
	private JPanel orderListBasicPanel;

	/**
	 * Create the panel.
	 */
	public OrderListPanel() {
		orderService=new OrderService();
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("주문 내역");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 26));
		add(lblNewLabel, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		orderListBasicPanel = new JPanel();
		orderListBasicPanel.setPreferredSize(new Dimension(10, 800));
		scrollPane.setViewportView(orderListBasicPanel);
		
		orderListPanel = new JPanel();
		orderListPanel.setPreferredSize(new Dimension(310, 100));
		orderListBasicPanel.add(orderListPanel);
		orderListPanel.setLayout(null);
		
		JLabel p_NameLB = new JLabel("상품 이름");
		p_NameLB.setBounds(122, 10, 57, 15);
		orderListPanel.add(p_NameLB);
		
		JLabel o_DateLB = new JLabel("주문 날짜");
		o_DateLB.setBounds(122, 64, 57, 15);
		orderListPanel.add(o_DateLB);
		
		JLabel o_PriceLB = new JLabel("주문금액");
		o_PriceLB.setBounds(227, 64, 57, 15);
		orderListPanel.add(o_PriceLB);
		
		JLabel p_imgLB = new JLabel("이미지");
		p_imgLB.setBounds(23, 10, 66, 69);
		orderListPanel.add(p_imgLB);
		
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		

	} //생성자 끝
	
	public void orderListDisplay(int memberNo) throws Exception{
		List<OrderList> orderList=new ArrayList<OrderList>();
		orderList=orderService.printAllOrderList(memberNo);
		
		orderListBasicPanel.removeAll();
		for (int i = 0; i < orderList.size(); i++) {
			OrderList order=orderList.get(i);
			orderListPanel=new JPanel();
			
			orderListPanel.setPreferredSize(new Dimension(400,130));
			orderListBasicPanel.add(orderListPanel);
			orderListPanel.setLayout(null);
			
			JLabel
			
			
		}
		
		
		
	}
	
}
