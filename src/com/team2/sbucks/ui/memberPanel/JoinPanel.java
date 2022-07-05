package com.team2.sbucks.ui.memberPanel;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;

public class JoinPanel extends JPanel {
	private JTextField joinTitle_TF;
	private JTextField joinID_TF;
	private JTextField joinPhone_TF;
	private JTextField joinBirth_TF;
	private JTextField joinEmail_TF;
	private JTextField joinLoc_TF;
	private JTextField joinNickname_TF;
	private JPasswordField joinPassword_TF;
	private JPasswordField joinCpassword_TF;

	/**
	 * Create the panel.
	 */
	public JoinPanel() {
		setLayout(null);
		
		JButton sbucksLogo = new JButton("");
		//이미지투명화
		sbucksLogo.setBorderPainted(false);
		sbucksLogo.setContentAreaFilled(false);
		sbucksLogo.setFocusPainted(false);
		sbucksLogo.setBorder(null);
		sbucksLogo.setIcon(new ImageIcon(LoginPanel.class.getResource("/images/스타벅스로고.png")));
		sbucksLogo.setBounds(59, 29, 242, 94);
		add(sbucksLogo);
		
		joinTitle_TF = new JTextField();
		joinTitle_TF.setBackground(UIManager.getColor("Button.background"));
		joinTitle_TF.setBorder(null);
		joinTitle_TF.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		joinTitle_TF.setHorizontalAlignment(SwingConstants.CENTER);
		joinTitle_TF.setText("회원가입");
		joinTitle_TF.setBounds(125, 5, 116, 34);
		add(joinTitle_TF);
		joinTitle_TF.setColumns(10);
		
		JLabel joinID_LB = new JLabel("아이디");
		joinID_LB.setBounds(33, 140, 57, 15);
		add(joinID_LB);
		
		JLabel joinPassword_LB = new JLabel("비밀번호");
		joinPassword_LB.setBounds(33, 178, 57, 15);
		add(joinPassword_LB);
		
		JLabel joinPhone_LB = new JLabel("핸드폰");
		joinPhone_LB.setBounds(33, 245, 57, 15);
		add(joinPhone_LB);
		
		JLabel joinBirth_LB = new JLabel("생일");
		joinBirth_LB.setBounds(33, 282, 57, 15);
		add(joinBirth_LB);
		
		JLabel joinEmail_LB = new JLabel("이메일");
		joinEmail_LB.setBounds(33, 315, 57, 15);
		add(joinEmail_LB);
		
		JLabel joinLoc_LB = new JLabel("지역");
		joinLoc_LB.setBounds(33, 380, 57, 15);
		add(joinLoc_LB);
		
		JCheckBox joinPagree_CB = new JCheckBox("핸드폰 정보제공 동의");
		joinPagree_CB.setBounds(31, 416, 148, 23);
		add(joinPagree_CB);
		
		JCheckBox joinEagree_CB = new JCheckBox("지역 정보제공 동의");
		joinEagree_CB.setBounds(214, 416, 146, 23);
		add(joinEagree_CB);
		
		joinID_TF = new JTextField();
		joinID_TF.setBounds(115, 137, 116, 21);
		add(joinID_TF);
		joinID_TF.setColumns(10);
		
		JButton joinBtn = new JButton("");
		joinBtn.setBorderPainted(false);
		joinBtn.setContentAreaFilled(false);
		joinBtn.setFocusPainted(false);
		joinBtn.setBorder(null);
		joinBtn.setIcon(new ImageIcon(JoinPanel.class.getResource("/images/가입.png")));
		joinBtn.setBounds(79, 471, 97, 23);
		add(joinBtn);
		
		JButton joinCancelBtn = new JButton("");
		joinCancelBtn.setBorderPainted(false);
		joinCancelBtn.setContentAreaFilled(false);
		joinCancelBtn.setFocusPainted(false);
		joinCancelBtn.setBorder(null);
		joinCancelBtn.setIcon(new ImageIcon(JoinPanel.class.getResource("/images/취소.png")));
		joinCancelBtn.setBounds(214, 471, 97, 23);
		add(joinCancelBtn);
		
		joinPhone_TF = new JTextField();
		joinPhone_TF.setColumns(10);
		joinPhone_TF.setBounds(115, 242, 116, 21);
		add(joinPhone_TF);
		
		joinBirth_TF = new JTextField();
		joinBirth_TF.setColumns(10);
		joinBirth_TF.setBounds(115, 279, 116, 21);
		add(joinBirth_TF);
		
		joinEmail_TF = new JTextField();
		joinEmail_TF.setColumns(10);
		joinEmail_TF.setBounds(115, 312, 116, 21);
		add(joinEmail_TF);
		
		joinLoc_TF = new JTextField();
		joinLoc_TF.setColumns(10);
		joinLoc_TF.setBounds(115, 377, 116, 21);
		add(joinLoc_TF);
		
		joinNickname_TF = new JTextField();
		joinNickname_TF.setColumns(10);
		joinNickname_TF.setBounds(115, 342, 116, 21);
		add(joinNickname_TF);
		
		JLabel joinNickname_LB = new JLabel("닉네임");
		joinNickname_LB.setBounds(33, 347, 57, 15);
		add(joinNickname_LB);
		
		JButton IDduplicate_Btn = new JButton("아이디 중복확인");
		IDduplicate_Btn.setBounds(235, 136, 127, 23);
		add(IDduplicate_Btn);
		
		JLabel joinCPassword_LB = new JLabel("비밀번호확인");
		joinCPassword_LB.setBounds(33, 209, 97, 15);
		add(joinCPassword_LB);
		
		joinPassword_TF = new JPasswordField();
		joinPassword_TF.setBounds(115, 175, 119, 21);
		add(joinPassword_TF);
		
		joinCpassword_TF = new JPasswordField();
		joinCpassword_TF.setBounds(115, 206, 119, 21);
		add(joinCpassword_TF);

	}
}
