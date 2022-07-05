package com.team2.sbucks.ui.LJH;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class OrderListPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public OrderListPanel() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(12, 57, 57, 15);
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 97, 354, 117);
		add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblNewLabel_1);

	}
}
