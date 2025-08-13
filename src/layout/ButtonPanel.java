package layout;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;

import gui.ButtonPanelDelegate;

/**
 * Creates a standard button panel which can be adapted to the other panels
 */
public class ButtonPanel extends QPanel {

	/**
	 * Connection to the delegate interface
	 */
	private ButtonPanelDelegate delegate;

	/**
	 * Declaration of first button
	 */
	public JButton firstBtn;

	/**
	 * Declaration of second button
	 */
	public JButton secondBtn;

	/**
	 * Declaration of third button
	 */
	public JButton thirdBtn;
	
	/**
	 * Special constraints for buttons
	 */
	public GridBagConstraints gbcBtn; 

	/**
	 * Constructs a new ButtonPanel with the specified delegate for handling user interactions.
	 * The GUI components are initialized and added to the panel during
	 * construction, making the panel ready for immediate use.
	 *
	 * @param delegate the object responsible for handling events (e.g., button
	 *                 clicks) from this panel; must not be {@code null} to ensure
	 *                 proper event delegation
	 */
	public ButtonPanel(ButtonPanelDelegate delegate) {
		this.delegate = delegate;
		initComponents();
		addComponents();
	}

	/**
	 * Initializes the buttons and adds an actionListener
	 * The actions are defined in the QuizDataManager via the QuizDataInterface
	 */
	private void initComponents() {
		gbcBtn = new GridBagConstraints();
		
		firstBtn = new JButton();
		secondBtn = new JButton();
		thirdBtn = new JButton();

		firstBtn.addActionListener(e -> delegate.firstBtnWasClicked());
		secondBtn.addActionListener(e -> delegate.secondBtnWasClicked());
		thirdBtn.addActionListener(e -> delegate.thirdBtnWasClicked());
	}

	/**
	 * Adds the components (buttons) to the panel
	 * Some buttons don't use the standard GridBagConstraints
	 * and therefore have specific gbc's 
	 */
	private void addComponents() {
		int row = 0;
		// Row 1. Buttons
		gbcBtn.fill = GridBagConstraints.NONE;
		gbcBtn.anchor = GridBagConstraints.EAST;

		addComponent(firstBtn, row, 0);
		addComponent(secondBtn, row, 1);

		gbcBtn.anchor = GridBagConstraints.WEST;
		gbcBtn.insets = new Insets(0, 0, 0, 50);
		addComponent(thirdBtn, row, 2);
	}

}
