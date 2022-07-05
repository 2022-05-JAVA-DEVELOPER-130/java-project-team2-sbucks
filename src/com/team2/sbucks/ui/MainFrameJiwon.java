package com.team2.sbucks.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import com.team2.sbucks.ui.productPanel.ProductDetailPanel;
import com.team2.sbucks.ui.productPanel.ProductAllPanel;

public class MainFrameJiwon extends JFrame {

	private JPanel contentPane;
	private ProductAllPanel productAllPanel;
	private ProductDetailPanel productDetailPanel;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrameJiwon frame = new MainFrameJiwon();
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
	public MainFrameJiwon() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 630);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.NORTH);
		
		productDetailPanel = new ProductDetailPanel();
		tabbedPane.addTab("New tab", null, productDetailPanel, null);
		
		productAllPanel = new ProductAllPanel();
		tabbedPane.addTab("New tab", null, productAllPanel, null);
		productAllPanel.productListDispaly();
	}
		

}
