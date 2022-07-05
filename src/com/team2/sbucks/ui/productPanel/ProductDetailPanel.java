package com.team2.sbucks.ui.productPanel;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ProductDetailPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

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
		
		textField = new JTextField();
		textField.setBounds(157, 73, 116, 21);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("상품가격");
		lblNewLabel_2.setBounds(43, 117, 57, 15);
		add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(157, 114, 116, 21);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("알러지정보");
		lblNewLabel_3.setBounds(43, 154, 84, 15);
		add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(157, 151, 116, 21);
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("상품설명");
		lblNewLabel_4.setBounds(43, 195, 57, 15);
		add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(157, 192, 116, 21);
		add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("영양정보");
		lblNewLabel_6.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblNewLabel_6.setBounds(12, 247, 85, 30);
		add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setBounds(43, 319, 57, 15);
		add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setBounds(43, 362, 57, 15);
		add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setBounds(43, 407, 57, 15);
		add(lblNewLabel_9);
		
		textField_5 = new JTextField();
		textField_5.setBounds(157, 316, 116, 21);
		add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(157, 359, 116, 21);
		add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(157, 404, 116, 21);
		add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(43, 474, 97, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(202, 474, 97, 23);
		add(btnNewButton_1);

	}
}
