package com.team2.sbucks.ui.memberPanel;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import com.team2.sbucks.dto.Login;
import com.team2.sbucks.dto.Member;
import com.team2.sbucks.service.LoginService;
import com.team2.sbucks.service.MemberService;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;

public class UpdatePanel extends JPanel {
	private JTextField updateID_TF;
	private JPasswordField originalPassword_TF;
	private JPasswordField updatePassword_TF;
	private JTextField updatePhone_TF;
	private JTextField updateBirth_TF;
	private JTextField updateEmail_TF;
	private JTextField updateNickname_TF;
	private JTextField updateLoc_TF;
	
	/**********멤버서비스 객체선언*************/
	private MemberService memberService;
	private LoginService loginService;
	
	/**********로그인한 회원******************/
	private Member loginMember = null;
	private Member newMember = null;
	
	
	private JCheckBox updatePagree_CB;
	private JCheckBox updateEagree_CB;
	private JComboBox updatePhone_CB;
	

	/**
	 * Create the panel.
	 */
	public UpdatePanel() {
		setLayout(null);
		
		JLabel updateTitle_LB = new JLabel("회원정보 수정");
		updateTitle_LB.setBounds(115, 12, 139, 40);
		updateTitle_LB.setHorizontalAlignment(SwingConstants.CENTER);
		updateTitle_LB.setFont(new Font("KoPubWorld돋움체 Bold", Font.BOLD, 25));
		add(updateTitle_LB);
		
		JButton sbucksLogo = new JButton("");
		sbucksLogo.setIcon(new ImageIcon(UpdatePanel.class.getResource("/images/스타벅스로고.png")));
		sbucksLogo.setFocusPainted(false);
		sbucksLogo.setContentAreaFilled(false);
		sbucksLogo.setBorderPainted(false);
		sbucksLogo.setBorder(null);
		sbucksLogo.setBounds(61, 40, 242, 94);
		add(sbucksLogo);
		
		JLabel updateID_LB = new JLabel("아이디");
		updateID_LB.setFont(new Font("KoPubWorld돋움체 Medium", Font.PLAIN, 13));
		updateID_LB.setBounds(20, 158, 57, 15);
		add(updateID_LB);
		
		updateID_TF = new JTextField();
		updateID_TF.setFont(new Font("KoPubWorld돋움체 Medium", Font.PLAIN, 12));
		updateID_TF.setColumns(10);
		updateID_TF.setBounds(101, 155, 143, 21);
		add(updateID_TF);
		
		JLabel originalPassword_LB = new JLabel("기존 비밀번호");
		originalPassword_LB.setFont(new Font("KoPubWorld돋움체 Medium", Font.PLAIN, 13));
		originalPassword_LB.setBounds(20, 199, 83, 15);
		add(originalPassword_LB);
		
		originalPassword_TF = new JPasswordField();
		originalPassword_TF.setBounds(101, 196, 143, 21);
		add(originalPassword_TF);
		
		JLabel updatePassword_LB = new JLabel("비밀번호변경");
		updatePassword_LB.setFont(new Font("KoPubWorld돋움체 Medium", Font.PLAIN, 13));
		updatePassword_LB.setBounds(20, 238, 97, 15);
		add(updatePassword_LB);
		
		updatePassword_TF = new JPasswordField();
		updatePassword_TF.setEnabled(false);
		updatePassword_TF.setBounds(101, 235, 143, 21);
		add(updatePassword_TF);
		
		JLabel updatePhone_LB = new JLabel("핸드폰");
		updatePhone_LB.setFont(new Font("KoPubWorld돋움체 Medium", Font.PLAIN, 13));
		updatePhone_LB.setBounds(20, 283, 57, 15);
		add(updatePhone_LB);
		
		
		
		
		updatePhone_TF = new JTextField();
		updatePhone_TF.setFont(new Font("KoPubWorld돋움체 Medium", Font.PLAIN, 12));
		updatePhone_TF.setEditable(false);
		updatePhone_TF.setColumns(10);
		updatePhone_TF.setBounds(170, 280, 74, 21);
		add(updatePhone_TF);
		
		JLabel updateBirth_LB = new JLabel("생일");
		updateBirth_LB.setFont(new Font("KoPubWorld돋움체 Medium", Font.PLAIN, 13));
		updateBirth_LB.setBounds(20, 320, 57, 15);
		add(updateBirth_LB);
		
		updateBirth_TF = new JTextField();
		updateBirth_TF.setFont(new Font("KoPubWorld돋움체 Medium", Font.PLAIN, 12));
		updateBirth_TF.setEditable(false);
		updateBirth_TF.setColumns(10);
		updateBirth_TF.setBounds(101, 317, 143, 21);
		add(updateBirth_TF);
		
		JLabel updateEmail_LB = new JLabel("이메일");
		updateEmail_LB.setFont(new Font("KoPubWorld돋움체 Medium", Font.PLAIN, 13));
		updateEmail_LB.setBounds(20, 353, 57, 15);
		add(updateEmail_LB);
		
		updateEmail_TF = new JTextField();
		updateEmail_TF.setFont(new Font("KoPubWorld돋움체 Medium", Font.PLAIN, 12));
		updateEmail_TF.setEditable(false);
		updateEmail_TF.setColumns(10);
		updateEmail_TF.setBounds(101, 350, 143, 21);
		add(updateEmail_TF);
		
		JLabel updateNickname_LB = new JLabel("닉네임");
		updateNickname_LB.setFont(new Font("KoPubWorld돋움체 Medium", Font.PLAIN, 13));
		updateNickname_LB.setBounds(20, 385, 57, 15);
		add(updateNickname_LB);
		
		updateNickname_TF = new JTextField();
		updateNickname_TF.setFont(new Font("KoPubWorld돋움체 Medium", Font.PLAIN, 12));
		updateNickname_TF.setEnabled(false);
		updateNickname_TF.setColumns(10);
		updateNickname_TF.setBounds(102, 380, 142, 21);
		add(updateNickname_TF);
		
		JLabel updateLoc_LB = new JLabel("지역");
		updateLoc_LB.setFont(new Font("KoPubWorld돋움체 Medium", Font.PLAIN, 13));
		updateLoc_LB.setBounds(20, 418, 57, 15);
		add(updateLoc_LB);
		
		updateLoc_TF = new JTextField();
		updateLoc_TF.setFont(new Font("KoPubWorld돋움체 Medium", Font.PLAIN, 12));
		updateLoc_TF.setEnabled(false);
		updateLoc_TF.setColumns(10);
		updateLoc_TF.setBounds(102, 415, 142, 21);
		add(updateLoc_TF);
		
		updatePagree_CB = new JCheckBox("핸드폰 정보제공 동의");
		updatePagree_CB.setEnabled(false);
		updatePagree_CB.setFont(new Font("KoPubWorld돋움체 Medium", Font.PLAIN, 13));
		updatePagree_CB.setBounds(20, 445, 148, 23);
		add(updatePagree_CB);
		
		updateEagree_CB = new JCheckBox("지역 정보제공 동의");
		updateEagree_CB.setEnabled(false);
		updateEagree_CB.setFont(new Font("KoPubWorld돋움체 Medium", Font.PLAIN, 13));
		updateEagree_CB.setBounds(203, 445, 146, 23);
		add(updateEagree_CB);
		
		
		
		JButton update_Btn = new JButton("업데이트");
		update_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String id = updateID_TF.getText();
					//String password = updatePassword_TF.getText();
					
					String ber = updatePhone_TF.getText();
					String phoneNum = (String)updatePhone_CB.getSelectedItem();
					String phoneNumber = phoneNum+ber;
					
					phoneNumber = updatePhone_TF.getText();
					
					String birth = updateBirth_TF.getText();
					String nickName = updateNickname_TF.getText();
					String email = updateEmail_TF.getText();
					String loc = updateLoc_TF.getText();
					int pAgreeStr = -999;
					if(updatePagree_CB.isSelected()) {
						pAgreeStr = 1;
					}else {
						pAgreeStr = 0;
					}
					
					int eAgreeStr = -999;
					if(updateEagree_CB.isSelected()) {
						eAgreeStr = 1;
					}else {
						eAgreeStr = 0;
					}
					if(id.equals("")||phoneNumber.equals("")|| birth.equals("")||nickName.equals("")||email.equals("")||loc.equals("")) {
						JOptionPane.showMessageDialog(null, "내용을 입력하세요.");
						return;
					}
					Member loginMember = new Member(0,id, phoneNumber, birth, email, nickName, loc, pAgreeStr, eAgreeStr);
					int check = memberService.updateMember(loginMember);
					if(check==1) {
					JOptionPane.showMessageDialog(null, "회원정보 변경이 완료되었습니다.");
					} else {
						JOptionPane.showMessageDialog(null, "회원정보 변경이 실패했습니다.");
					}
					
				}catch(Exception e1) {
					
				}
			}
		});
		update_Btn.setBounds(203, 466, 97, 23);
		add(update_Btn);
		
		JButton out_Btn = new JButton("탈퇴");
		out_Btn.setBounds(65, 466, 97, 23);
		add(out_Btn);
		
		JButton updatePassword_Btn = new JButton("변경");
		updatePassword_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String id = updateID_TF.getText();
					String newPassword = updatePassword_TF.getText();
					boolean isSuccess = loginService.CheckUpdatePassword(newPassword, id);
					if(isSuccess) {
						JOptionPane.showMessageDialog(null, "비밀번호가 변경되었습니다.");
					}else {
						JOptionPane.showMessageDialog(null, "다시 입력해주세요.");
					}
					/*
				    if() {
				    	loginService.updatePassword(newPassword, oldPassword);
				         System.out.println("화깅ㄴ");
				    	updatePassword_TF.setEnabled(false);
				    	updateNickname_TF.requestFocus();
				    }else {
				    }
					*/
					
					
				}catch(Exception e1) {
					
				}
			}
		});
		updatePassword_Btn.setFont(new Font("KoPubWorld돋움체 Medium", Font.PLAIN, 10));
		updatePassword_Btn.setBounds(258, 235, 71, 23);
		add(updatePassword_Btn);
		
		updatePhone_CB = new JComboBox();
		updatePhone_CB.setModel(new DefaultComboBoxModel(new String[] {"010", "017", "011"}));
		updatePhone_CB.setEnabled(false);
		updatePhone_CB.setBounds(102, 277, 61, 27);
		add(updatePhone_CB);
		
		JButton sameID_Btn = new JButton("일치 확인");
		sameID_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String id = updateID_TF.getText();
				String password = originalPassword_TF.getText();
				Member loginMember = memberService.findInfo(id, password);
				
				if(loginMember!=null) {
					
					updateID_TF.setEnabled(false);
					originalPassword_TF.setEnabled(false);
					updatePassword_TF.setEnabled(true);
					updatePassword_TF.setEnabled(true);
					updatePhone_TF.setText(loginMember.getMember_phone());
					updateBirth_TF.setText(loginMember.getMember_birthday().toLocaleString().substring(0,10));
					updateEmail_TF.setText(loginMember.getMember_email());
					updateLoc_TF.setText(loginMember.getMember_loc());
					updateNickname_TF.setText(loginMember.getMemeber_nickname());
					updateNickname_TF.setEnabled(true);
					updateLoc_TF.setEnabled(true);
					updatePagree_CB.setEnabled(true);
					updateEagree_CB.setEnabled(true);
					updatePhone_CB.setSelectedItem(loginMember.getMember_phone().substring(0, 3));
					if(loginMember.getMember_pagree()==0) {
						updatePagree_CB.setSelected(false);
					} else {
						updatePagree_CB.setSelected(true);
					}
			} else {
				JOptionPane.showMessageDialog(null, "다시 입력해주세요");
				updateID_TF.requestFocus();
			}
				}catch(Exception e1) {
					
				}
			}
		});
		sameID_Btn.setFont(new Font("KoPubWorld돋움체 Medium", Font.PLAIN, 10));
		sameID_Btn.setBounds(258, 179, 71, 23);
		add(sameID_Btn);
	
		memberService=new MemberService();
		loginService = new LoginService();
	}

/*******************로그인성공시호출할메쏘드******************/
public void loginProcess(String id)throws Exception {
	/*
	 * 1.로그인멤버객체 저장
	 * 2.MemberMainFrame타이틀변경
	 * 3.로그인,회원가입 tab 불활성화
	 * 4.로그아웃메뉴아이템 활성화
	 * 5.회원리스트탭 활성화
	 */
	Member loginSuccessMember=memberService.findById(id);
	loginMember = loginSuccessMember;
	//setTitle(loginMember.getMember_id());   --탭 생성시
	
	
}
}//클래스끝