package layout;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.JPanel;

public class QPanel extends JPanel {

	protected GridBagConstraints gbc;
	
	public QPanel() {
		super();
		setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.insets = new Insets(3, 5, 3, 5);
		gbc.fill = GridBagConstraints.BOTH;
		
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.weighty = 1.;
		gbc.weightx = 1.;
	}
	
	protected void addComponent(Component comp, int row, int col) {
		gbc.gridx = col;
		gbc.gridy = row;
		add(comp, gbc);
	}

	protected void addBoxOrEmpty(int row, int col) {
		gbc.gridx = col;
		gbc.gridy = row;
		gbc.gridwidth = 1;
		add(Box.createHorizontalStrut(20), gbc);
	}
}
