package com.team2.sbucks.ui.productPanel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.FlowLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class ProductAllPanel extends JPanel {
	private JPanel prodductListBasicpanel;

	/**
	 * Create the panel.
	 */
	public ProductAllPanel() {
		setForeground(SystemColor.info);
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);
		
		prodductListBasicpanel = new JPanel();
		
		prodductListBasicpanel.setForeground(new Color(46, 139, 87));
		prodductListBasicpanel.setPreferredSize(new Dimension(320, 1000));
		scrollPane.setViewportView(prodductListBasicpanel);
		prodductListBasicpanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		/**********************************************************/
		JPanel productitemPanel = new JPanel();
		productitemPanel.setPreferredSize(new Dimension(350, 130));
		prodductListBasicpanel.add(productitemPanel);
		productitemPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ProductAllPanel.class.getResource("/images/아메리카노.jpg")));
		lblNewLabel.setBounds(12, 10, 107, 98);
		productitemPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("아메리카노");
		lblNewLabel_1.setBounds(131, 28, 113, 15);
		productitemPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("<html>안녕<br>안녕</html>");
		lblNewLabel_2.setBounds(131, 35, 126, 73);
		productitemPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("전체상품");
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		add(lblNewLabel_3, BorderLayout.NORTH);
		/*********************************************************/
	}//생성자끝
	/***********************************************************/
	public void productListDispaly() {
		prodductListBasicpanel.removeAll();
		for(int i=0;i<10;i++) {
			JPanel productitemPanel = new JPanel();
			productitemPanel.setPreferredSize(new Dimension(350, 130));
			prodductListBasicpanel.add(productitemPanel);
			productitemPanel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(ProductAllPanel.class.getResource("/images/아메리카노.jpg")));
			lblNewLabel.setBounds(12, 10, 107, 98);
			productitemPanel.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("아메리카노"+i);
			lblNewLabel_1.setBounds(131, 10, 113, 15);
			productitemPanel.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("<html>안녕<br>안녕"+i+"</html>");
			lblNewLabel_2.setBounds(131, 35, 126, 73);
			productitemPanel.add(lblNewLabel_2);
		}
		
	}

}
