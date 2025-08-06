package layout;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.JPanel;

/**
 * Class to modify and standardize the layout of Panels
 */
public class QPanel extends JPanel {

	/**
	 * GridBagConstraints variable to be modified if necessary  
	 */
	protected GridBagConstraints gbc;
	
	/**
	 * Method to set the standards for Panel layout like
	 * insets, fill, grid height, grid width and so on
	 */
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
	
	/**
	 * Add components using gbc variable and row /column as arguments
	 * @param comp the component, like panel, textfield...
	 * @param row the row inside the GridBagLayout
	 * @param col the col inside the GridBagLayout
	 */
	protected void addComponent(Component comp, int row, int col) {
		gbc.gridx = col;
		gbc.gridy = row;
		add(comp, gbc);
	}

	/**
	 * Adds an empty box with a standard width of 1 at the position inserted as arguments  
	 * @param row the row inside the GridBagLayout
	 * @param col the col inside the GridBagLayout
	 */
	protected void addBoxOrEmpty(int row, int col) {
		gbc.gridx = col;
		gbc.gridy = row;
		gbc.gridwidth = 1;
		add(Box.createHorizontalStrut(20), gbc);
	}
}
