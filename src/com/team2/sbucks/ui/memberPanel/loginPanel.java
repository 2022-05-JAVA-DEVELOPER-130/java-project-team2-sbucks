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

import com.team2.sbucks.dto.Member;
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
					int result = memberService.loginSuccess(id, password);
					if(result == 0) {
						loginProccess(id);
					}else if(result == 1) {
						//아이디틀림
						System.out.println("아이디를 다시 입력해주세요.");
						id_TF.requestFocus();
					}else if(result ==2) {
						//비밀번호 틀림
						System.out.println("비밀번호를 다시 입력해주세요.");
						password_TF.requestFocus();
					}
					
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
//생성자끝

/**************로그인 성공시 호출할 메쏘드*******************/
public void loginProccess(String id) throws Exception{
	/*
	 * 1.로그인멤버객체 저장
	 * 2.MemberMainFrame타이틀변경
	 * 3.로그인,회원가입 tab 불활성화
	 * 4.로그아웃메뉴아이템 활성화
	 * 5.회원리스트탭 활성화
	 */
	Member loginSuccessMember = memberService.findById(id);
	Member loginMember = loginSuccessMember;
	//setTitle(loginMember.getMember_id());
	
	
}

}
