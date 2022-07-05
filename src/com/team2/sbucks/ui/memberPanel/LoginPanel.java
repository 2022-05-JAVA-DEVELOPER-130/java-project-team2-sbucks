package com.team2.sbucks.ui.memberPanel;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LoginPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public LoginPanel() {
		setLayout(null);
		
		JButton sbucksLogo = new JButton("");
		sbucksLogo.setBorderPainted(false);
		sbucksLogo.setContentAreaFilled(false);
		sbucksLogo.setFocusPainted(false);
		sbucksLogo.setBorder(null);
		sbucksLogo.setIcon(new ImageIcon(JoinPanel.class.getResource("/images/스타벅스로고.png")));
		sbucksLogo.setBounds(59, 57, 242, 94);
		add(sbucksLogo);
		
		JLabel loginTitle_LB = new JLabel("로그인");
		loginTitle_LB.setHorizontalAlignment(SwingConstants.CENTER);
		loginTitle_LB.setFont(new Font("KoPubWorldDotum_Pro", Font.BOLD, 20));
		loginTitle_LB.setBounds(110, 6, 140, 46);
		add(loginTitle_LB);
		
		JLabel idLB = new JLabel("아이디");
		idLB.setHorizontalAlignment(SwingConstants.LEFT);
		idLB.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 17));
		idLB.setBounds(40, 218, 61, 16);
		add(idLB);
		
		JLabel passwordLB = new JLabel("패스워드");
		passwordLB.setFont(new Font("KoPubWorldDotum_Pro", Font.PLAIN, 17));
		passwordLB.setHorizontalAlignment(SwingConstants.LEFT);
		passwordLB.setBounds(40, 355, 61, 16);
		add(passwordLB);
		
		textField = new JTextField();
		textField.setBounds(151, 208, 150, 36);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(162, 350, 130, 26);
		add(textField_1);
		
		JButton loginBtn = new JButton("");
		loginBtn.setIcon(new ImageIcon(LoginPanel.class.getResource("/images/로그인버튼.png")));
		loginBtn.setBounds(110, 448, 117, 29);
		add(loginBtn);

	}
}
