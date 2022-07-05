package com.team2.sbucks.ui.productPanel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.SwingConstants;


import com.team2.sbucks.dto.Product;
import com.team2.sbucks.service.ProductService;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.FlowLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProductAllPanel extends JPanel {
	private JPanel productListBasicpanel;
	private JPanel productitemPanel_1;
    private ProductService productService;
    private Product product;
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
	public ProductAllPanel() {
		setForeground(SystemColor.info);
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);
		
		productListBasicpanel = new JPanel();
		
		productListBasicpanel.setForeground(new Color(46, 139, 87));
		productListBasicpanel.setPreferredSize(new Dimension(320, 1000));
		scrollPane.setViewportView(productListBasicpanel);
		productListBasicpanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		/**********************************************************/
		productitemPanel_1 = new JPanel();
		productitemPanel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				/***********************************************************/
				try {
					
					Product findProduct = productService.selectByNo(product.getProduct_no());
					productNameTF.setText(findProduct.getProduct_name());
					
				}catch (Exception e1) {
					e1.printStackTrace();
				}
				/***********************************************************/
			}
		});
		productitemPanel_1.setPreferredSize(new Dimension(350, 130));
		productListBasicpanel.add(productitemPanel_1);
		productitemPanel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		lblNewLabel.setIcon(new ImageIcon(ProductAllPanel.class.getResource("/images/(HOT)아메리카노.jpg")));
		lblNewLabel.setBounds(12, 10, 107, 98);
		productitemPanel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("(HOT)아메리카노");
		lblNewLabel_1.setBounds(131, 28, 113, 15);
		productitemPanel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("<html>안녕<br>안녕</html>");
		lblNewLabel_2.setBounds(131, 35, 126, 73);
		productitemPanel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("전체상품");
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		add(lblNewLabel_3, BorderLayout.NORTH);
		/*********************************************************/
	}//생성자끝
	/**
	 * @throws Exception *********************************************************/
	public void productListDispaly() {
		productListBasicpanel.removeAll();
		for(int i=0;i<10;i++) {
			JPanel productitemPanel = new JPanel();
			productitemPanel.setPreferredSize(new Dimension(350, 130));
			productListBasicpanel.add(productitemPanel);
			productitemPanel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("");
			try {
				lblNewLabel.setIcon(new ImageIcon(ProductAllPanel.class.getResource("/images/(HOT)아메리카노.jpg")));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			lblNewLabel.setBounds(12, 10, 107, 98);
			productitemPanel.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("(HOT)아메리카노");
			lblNewLabel_1.setBounds(131, 10, 113, 15);
			productitemPanel.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("<html>안녕<br>안녕"+i+"</html>");
			lblNewLabel_2.setBounds(131, 35, 126, 73);
			productitemPanel.add(lblNewLabel_2);
		}
		
	}

}
