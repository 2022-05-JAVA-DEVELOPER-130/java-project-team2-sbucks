package com.team2.sbucks.ui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class cartPanel1 extends JPanel {
	private JTextField productnameTF;
	private JTextField shotnumTF;
	private JTextField syrupTF;
	private JTextField priceTF;
	private JTextField numTF;
	private JTextField allpriceTF;
	public cartPanel1() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 370, 85);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("장바구니");
		lblNewLabel_3.setFont(new Font("굴림", Font.PLAIN, 30));
		lblNewLabel_3.setBounds(12, 10, 135, 65);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setForeground(Color.WHITE);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(0, 416, 370, 104);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("총");
		lblNewLabel_4.setFont(new Font("굴림", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(12, 27, 18, 23);
		panel_1.add(lblNewLabel_4);
		
		numTF = new JTextField();
		numTF.setOpaque(false);
		numTF.setFont(new Font("굴림", Font.PLAIN, 18));
		numTF.setBounds(34, 29, 25, 21);
		panel_1.add(numTF);
		numTF.setColumns(10);
		
		JLabel lblNewLabel_4_1 = new JLabel("개");
		lblNewLabel_4_1.setFont(new Font("굴림", Font.PLAIN, 18));
		lblNewLabel_4_1.setBounds(62, 27, 18, 23);
		panel_1.add(lblNewLabel_4_1);
		
		allpriceTF = new JTextField();
		allpriceTF.setBackground(Color.LIGHT_GRAY);
		allpriceTF.setFont(new Font("굴림", Font.PLAIN, 22));
		allpriceTF.setBounds(223, 23, 135, 33);
		panel_1.add(allpriceTF);
		allpriceTF.setColumns(10);
		
		JButton orderBtn = new JButton("");
		orderBtn.setIcon(new ImageIcon("C:\\Users\\ITWILL\\Desktop\\주문하기.PNG"));
		orderBtn.setForeground(Color.WHITE);
		orderBtn.setBackground(Color.GREEN);
		orderBtn.setBounds(120, 71, 117, 23);
		panel_1.add(orderBtn);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(0, 140, 370, 3);
		add(panel_2);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(Color.LIGHT_GRAY);
		panel_2_1.setBounds(0, 360, 370, 3);
		add(panel_2_1);
		
		JLabel lblNewLabel = new JLabel("음료/푸드");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 18));
		lblNewLabel.setBounds(139, 94, 88, 36);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("주문 메뉴");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(22, 156, 67, 26);
		add(lblNewLabel_1);
		
		JButton productchoicedeleteBtn = new JButton("선택삭제");
		productchoicedeleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		productchoicedeleteBtn.setContentAreaFilled(false);
		productchoicedeleteBtn.setFont(new Font("굴림", Font.PLAIN, 8));
		productchoicedeleteBtn.setBounds(218, 158, 65, 27);
		add(productchoicedeleteBtn);
		
		JButton productalldeleteBtn = new JButton("전체삭제");
		productalldeleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		productalldeleteBtn.setContentAreaFilled(false);
		productalldeleteBtn.setFont(new Font("굴림", Font.PLAIN, 8));
		productalldeleteBtn.setBounds(281, 158, 67, 27);
		add(productalldeleteBtn);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.LIGHT_GRAY);
		panel_3.setBounds(281, 156, 2, 26);
		add(panel_3);
		
		JCheckBox pricechoiceCB = new JCheckBox("");
		pricechoiceCB.setBounds(8, 188, 21, 23);
		add(pricechoiceCB);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\ITWILL\\Desktop\\아이스아메.PNG"));
		lblNewLabel_2.setBounds(18, 217, 88, 97);
		add(lblNewLabel_2);
		
		productnameTF = new JTextField();
		productnameTF.setEnabled(false);
		productnameTF.setBounds(118, 217, 206, 21);
		add(productnameTF);
		productnameTF.setColumns(10);
		
		shotnumTF = new JTextField();
		shotnumTF.setEnabled(false);
		shotnumTF.setBounds(118, 248, 67, 21);
		add(shotnumTF);
		shotnumTF.setColumns(10);
		
		syrupTF = new JTextField();
		syrupTF.setEnabled(false);
		syrupTF.setColumns(10);
		syrupTF.setBounds(118, 279, 67, 21);
		add(syrupTF);
		
		JButton optionchangeBtn = new JButton("옵션 변경");
		optionchangeBtn.setForeground(Color.ORANGE);
		optionchangeBtn.setBorderPainted(false);
		optionchangeBtn.setFont(new Font("굴림", Font.PLAIN, 9));
		optionchangeBtn.setBounds(105, 310, 80, 14);
		add(optionchangeBtn);
		
		priceTF = new JTextField();
		priceTF.setEnabled(false);
		priceTF.setBounds(270, 328, 88, 21);
		add(priceTF);
		priceTF.setColumns(10);
		
		JComboBox numchangBtn = new JComboBox();
		numchangBtn.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		numchangBtn.setBounds(218, 327, 40, 23);
		add(numchangBtn);
	}
}

