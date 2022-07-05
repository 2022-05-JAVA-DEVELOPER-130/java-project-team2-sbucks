package com.team2.sbucks.ui.productPanel;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ProductDetailPanel extends JPanel {
	private JTextField productNameTF;
	private JTextField productPriceTF;
	private JTextField productAllergyTF;
	private JTextField productContentTF;
	private JTextField productKalTF;
	private JTextField productCaffineTF;
	private JTextField productNaTF;

	/**
	 * Create the panel.
	 */
	public ProductDetailPanel() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("상품이름");
		lblNewLabel.setBounds(43, 76, 57, 15);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("상품상세");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblNewLabel_1.setBounds(12, 20, 115, 15);
		add(lblNewLabel_1);
		
		productNameTF = new JTextField();
		productNameTF.setBounds(157, 73, 116, 21);
		add(productNameTF);
		productNameTF.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("상품가격");
		lblNewLabel_2.setBounds(43, 117, 57, 15);
		add(lblNewLabel_2);
		
		productPriceTF = new JTextField();
		productPriceTF.setBounds(157, 114, 116, 21);
		add(productPriceTF);
		productPriceTF.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("알러지정보");
		lblNewLabel_3.setBounds(43, 154, 84, 15);
		add(lblNewLabel_3);
		
		productAllergyTF = new JTextField();
		productAllergyTF.setBounds(157, 151, 116, 21);
		add(productAllergyTF);
		productAllergyTF.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("상품설명");
		lblNewLabel_4.setBounds(43, 195, 57, 15);
		add(lblNewLabel_4);
		
		productContentTF = new JTextField();
		productContentTF.setBounds(157, 192, 116, 21);
		add(productContentTF);
		productContentTF.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("영양정보");
		lblNewLabel_6.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblNewLabel_6.setBounds(12, 247, 85, 30);
		add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("칼로리");
		lblNewLabel_7.setBounds(43, 319, 57, 15);
		add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("카페인");
		lblNewLabel_8.setBounds(43, 362, 57, 15);
		add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("나트륨");
		lblNewLabel_9.setBounds(43, 407, 57, 15);
		add(lblNewLabel_9);
		
		productKalTF = new JTextField();
		productKalTF.setBounds(157, 316, 116, 21);
		add(productKalTF);
		productKalTF.setColumns(10);
		
		productCaffineTF = new JTextField();
		productCaffineTF.setBounds(157, 359, 116, 21);
		add(productCaffineTF);
		productCaffineTF.setColumns(10);
		
		productNaTF = new JTextField();
		productNaTF.setBounds(157, 404, 116, 21);
		add(productNaTF);
		productNaTF.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(43, 474, 97, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(192, 474, 97, 23);
		add(btnNewButton_1);

	}

	
}
