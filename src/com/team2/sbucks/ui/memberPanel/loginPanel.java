package com.team2.sbucks.ui.memberPanel;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import com.team2.sbucks.service.MemberService;

import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class loginPanel extends JPanel {
	private JTextField id_TF;
	private JTextField password_TF;
	private JTextField loginExplain;
	
	private MemberService memberService;
	/**
	 * Create the panel.
	 */
	public loginPanel() {
		setLayout(null);
		
		JButton sbucksLogo = new JButton("");
		sbucksLogo.setBorderPainted(false);
		sbucksLogo.setIcon(new ImageIcon("/Users/ddoyoon/eclipse/git-repositories/java-project-team2-sbucks/bin/images/스타벅스로고.png"));
		sbucksLogo.setBounds(61, 62, 242, 111);
		add(sbucksLogo);
		
		JLabel idLB = new JLabel("아이디");
		idLB.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 15));
		idLB.setBounds(57, 247, 75, 42);
		add(idLB);
		
		JLabel passwordLB = new JLabel("비밀번호");
		passwordLB.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 15));
		passwordLB.setBounds(57, 351, 75, 42);
		add(passwordLB);
		
		id_TF = new JTextField();
		id_TF.setBounds(155, 247, 149, 42);
		add(id_TF);
		id_TF.setColumns(10);
		
		loginExplain = new JTextField();
		loginExplain.setBackground(UIManager.getColor("Button.background"));
		loginExplain.setBorder(null);
		loginExplain.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 11));
		loginExplain.setHorizontalAlignment(SwingConstants.CENTER);
		loginExplain.setText("회원 서비스 이용을 위해 로그인 해주세요.");
		loginExplain.setBounds(43, 185, 279, 26);
		add(loginExplain);
		loginExplain.setColumns(10);
		
		password_TF = new JTextField();
		password_TF.setColumns(10);
		password_TF.setBounds(155, 352, 149, 42);
		add(password_TF);
		JButton loginBtn = new JButton("로그인");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String id = id_TF.getText();
					String password = password_TF.getText();
					memberService.loginSuccess(id, password);
					
				}catch(Exception e1) {
					
				}
				
				
			}
		});
		loginBtn.setIcon(new ImageIcon("/Users/ddoyoon/eclipse/git-repositories/java-project-team2-sbucks/bin/images/로그인버튼.png"));
		loginBtn.setBorderPainted(false);
		loginBtn.setForeground(new Color(0, 128, 0));
		loginBtn.setBackground(new Color(0, 100, 0));
		loginBtn.setBounds(97, 451, 171, 29);
		add(loginBtn);

	}
}
