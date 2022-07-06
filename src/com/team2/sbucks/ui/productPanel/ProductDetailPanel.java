package com.team2.sbucks.ui.productPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.team2.sbucks.dto.Product;
import com.team2.sbucks.dto.ProductDetail;
import com.team2.sbucks.ui.MainFrame;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ProductDetailPanel extends JPanel {
	private JTextField productNameTF;
	private JTextField productPriceTF;
	private JTextField productAllergyTF;
	private JTextField productKalTF;
	private JTextField productCaffineTF;
	private JTextField productNaTF;
	private Product product;
	private ProductDetail productDetial;
	
	private MainFrame mainFrame;
	private JLabel lblNewLabel_4;
	
	/**
	 * Create the panel.
	 */
	public ProductDetailPanel() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				if(mainFrame.selectedProduct!=null  && mainFrame.selectedProductDetail!=null) {
					productNameTF.setText(mainFrame.selectedProduct.getProduct_name());
					productPriceTF.setText(mainFrame.selectedProduct.getProduct_price()+"");
					productAllergyTF.setText(mainFrame.selectedProduct.getProduct_allergy());
					productKalTF.setText(mainFrame.selectedProductDetail.getKal()+"");
					productCaffineTF.setText(mainFrame.selectedProductDetail.getCaffeine()+"");
					productNaTF.setText(mainFrame.selectedProductDetail.getNa()+"");
					lblNewLabel_4.setIcon(new ImageIcon(ProductDetailPanel.class.getResource("/images/"+mainFrame.selectedProduct.getProduct_name()+".jpg")));
					
					
				}
				
					
				
			}
			
			
			
		});
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("상품이름");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lblNewLabel.setBounds(42, 196, 57, 15);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("상품상세");
		lblNewLabel_1.setForeground(new Color(0, 100, 0));
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblNewLabel_1.setBounds(42, 156, 115, 15);
		add(lblNewLabel_1);
		
		productNameTF = new JTextField();
		productNameTF.setBounds(157, 195, 154, 21);
		add(productNameTF);
		productNameTF.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("상품가격");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lblNewLabel_2.setBounds(42, 226, 57, 15);
		add(lblNewLabel_2);
		
		productPriceTF = new JTextField();
		productPriceTF.setBounds(157, 226, 154, 21);
		add(productPriceTF);
		productPriceTF.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("알러지정보");
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lblNewLabel_3.setBounds(42, 258, 84, 15);
		add(lblNewLabel_3);
		
		productAllergyTF = new JTextField();
		productAllergyTF.setBounds(157, 257, 154, 21);
		add(productAllergyTF);
		productAllergyTF.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("영양정보");
		lblNewLabel_6.setForeground(new Color(0, 100, 0));
		lblNewLabel_6.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblNewLabel_6.setBounds(42, 309, 85, 30);
		add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("칼로리");
		lblNewLabel_7.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lblNewLabel_7.setBounds(42, 349, 57, 15);
		add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("카페인");
		lblNewLabel_8.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lblNewLabel_8.setBounds(42, 382, 57, 15);
		add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("나트륨");
		lblNewLabel_9.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lblNewLabel_9.setBounds(42, 418, 57, 15);
		add(lblNewLabel_9);
		
		productKalTF = new JTextField();
		productKalTF.setBounds(157, 348, 154, 21);
		add(productKalTF);
		productKalTF.setColumns(10);
		
		productCaffineTF = new JTextField();
		productCaffineTF.setBounds(157, 381, 154, 21);
		add(productCaffineTF);
		productCaffineTF.setColumns(10);
		
		productNaTF = new JTextField();
		productNaTF.setBounds(157, 417, 154, 21);
		add(productNaTF);
		productNaTF.setColumns(10);
		
		
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setIcon(new ImageIcon(ProductDetailPanel.class.getResource("/images/(ICE)아메리카노.jpg")));
		lblNewLabel_4.setBounds(71, 10, 213, 151);
		add(lblNewLabel_4);
		
		JButton orderBtn = new JButton("주문하기");
		orderBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		orderBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
				/*******************************************/
				mainFrame.tabbedPane.setSelectedIndex(2);
				mainFrame.OrderTabbedPane.setSelectedIndex(2);
			}
		});
		orderBtn.setBounds(87, 463, 197, 23);
		add(orderBtn);
		
		
		
		
		
		

	}//생성자끝

	public void setFrame(MainFrame mainFrame) {
		this.mainFrame=mainFrame;
	}
}//클래스 끝