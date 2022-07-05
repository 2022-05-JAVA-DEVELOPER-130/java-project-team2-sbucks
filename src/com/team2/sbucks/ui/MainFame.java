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

public class MainFame extends JFrame {

	private JPanel contentPane;
	private JPanel loginPanel;
	private JPanel joinPanel;
	private JPanel memberInfoPanel;
	private JPanel productAllPanel;
	private JPanel productOnePanel;
	private JPanel productDetailAllPanel;
	private JPanel productDetailOnePanel;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JTable productTable;
	private JTable productDetailTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFame frame = new MainFame();
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
	public MainFame() {
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
		
		productAllPanel = new JPanel();
		productTabbedPane.addTab("전체상품", null, productAllPanel, null);
		productAllPanel.setLayout(null);
		
		JScrollPane productScrollPane = new JScrollPane();
		productScrollPane.setBounds(0, 0, 364, 188);
		productAllPanel.add(productScrollPane);
		
		productTable = new JTable();
		productTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"\uC0C1\uD488\uBC88\uD638", "\uC0C1\uD488\uC774\uB984", "\uC0C1\uD488\uAC00\uACA9", "\uC54C\uB7EC\uC9C0\uC815\uBCF4", "\uC0C1\uD488\uC124\uBA85"
			}
		));
		productScrollPane.setViewportView(productTable);
		
		productOnePanel = new JPanel();
		productTabbedPane.addTab("상품상세", null, productOnePanel, null);
		productOnePanel.setLayout(null);
		
		productDetailAllPanel = new JPanel();
		productTabbedPane.addTab("전체영양정보", null, productDetailAllPanel, null);
		productDetailAllPanel.setLayout(null);
		
		JScrollPane productDetailScrollPane = new JScrollPane();
		productDetailScrollPane.setBounds(0, 10, 364, 196);
		productDetailAllPanel.add(productDetailScrollPane);
		
		productDetailTable = new JTable();
		productDetailTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"\uC0C1\uD488\uBC88\uD638", "\uCE7C\uB85C\uB9AC", "\uCE74\uD398\uC778", "\uB098\uD2B8\uB968"
			}
		));
		productDetailScrollPane.setViewportView(productDetailTable);
		
		productDetailOnePanel = new JPanel();
		productTabbedPane.addTab("영양정보상세", null, productDetailOnePanel, null);
		productDetailOnePanel.setLayout(null);
		
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
	}
}
