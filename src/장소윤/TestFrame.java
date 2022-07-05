package 장소윤;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import com.team2.sbucks.dto.Member;
import com.team2.sbucks.service.CartService;
import com.team2.sbucks.service.LoginService;
import com.team2.sbucks.service.MemberService;
import com.team2.sbucks.service.OrderDetailService;
import com.team2.sbucks.service.OrderService;
import com.team2.sbucks.service.ProductDetailService;
import com.team2.sbucks.service.ProductService;

public class TestFrame extends JFrame {

		
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
	private JTextField id_TF;
	private JTextField password_TF;
	private JTextField loginExplain;
	private MemberService memberService;
	
	/*************로그인한 회원***************/
	private Member loginMember = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestFrame frame = new TestFrame();
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
	public TestFrame() {
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
		
		
			/**
			 * Create the panel.
			 */
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
				JButton loginBtn = new JButton("");
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
	}//생성자끝
	
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
		loginMember = loginSuccessMember;
		setTitle(loginMember.getMember_id());
		
		
	}
	
	
	
}//클래스끝
