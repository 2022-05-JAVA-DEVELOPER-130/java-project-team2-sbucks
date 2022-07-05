package com.team2.sbucks.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.team2.sbucks.service.CartService;
import com.team2.sbucks.service.LoginService;
import com.team2.sbucks.service.MemberService;
import com.team2.sbucks.service.OrderDetailService;
import com.team2.sbucks.service.OrderService;
import com.team2.sbucks.service.ProductDetailService;
import com.team2.sbucks.service.ProductService;
import com.team2.sbucks.ui.productPanel.ProductAllPanel;

public class MainFrame extends JFrame {

		
	private JPanel contentPane;
	private JPanel loginPanel;
	private JPanel joinPanel;
	private JPanel memberInfoPanel;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private ProductAllPanel productAllPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setTitle("sbucks");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel memberPanel = new JPanel();
		tabbedPane.addTab("회원", null, memberPanel, null);
		memberPanel.setLayout(null);
		
		JTabbedPane memberTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		memberTabbedPane.setBounds(0, 0, 369, 512);
		memberPanel.add(memberTabbedPane);
		
		loginPanel = new JPanel();
		memberTabbedPane.addTab("로그인", null, loginPanel, null);
		loginPanel.setLayout(null);
		
		joinPanel = new JPanel();
		memberTabbedPane.addTab("회원가입", null, joinPanel, null);
		joinPanel.setLayout(null);
		
		memberInfoPanel = new JPanel();
		memberTabbedPane.addTab("회원정보수정", null, memberInfoPanel, null);
		memberInfoPanel.setLayout(null);
		
		JPanel productPanel = new JPanel();
		tabbedPane.addTab("상품", null, productPanel, null);
		productPanel.setLayout(null);
		
		JTabbedPane productTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		productTabbedPane.setBounds(0, 0, 369, 522);
		productPanel.add(productTabbedPane);
		
		productAllPanel = new ProductAllPanel();
		productTabbedPane.addTab("New tab", null, productAllPanel, null);
		
		JPanel orderPanel = new JPanel();
		tabbedPane.addTab("주문", null, orderPanel, null);
		orderPanel.setLayout(null);
		
		JTabbedPane orderTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		orderTabbedPane.setBounds(0, 0, 369, 522);
		orderPanel.add(orderTabbedPane);
		
		panel_4 = new JPanel();
		orderTabbedPane.addTab("New tab", null, panel_4, null);
		panel_4.setLayout(null);
		
		panel_5 = new JPanel();
		orderTabbedPane.addTab("New tab", null, panel_5, null);
		panel_5.setLayout(null);
		
		panel_6 = new JPanel();
		orderTabbedPane.addTab("New tab", null, panel_6, null);
		panel_6.setLayout(null);
		productAllPanel.productListDispaly();
	}//생성자끝
	
	
	
	
	
}//클래스끝
