package layout;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;

import gui.ButtonPanelDelegate;

public class ButtonPanel extends QPanel {
	private ButtonPanelDelegate delegate;

	public JButton firstBtn;
	public JButton secondBtn;
	public JButton thirdBtn;

	public ButtonPanel(ButtonPanelDelegate delegate) {
		this.delegate = delegate;
		initComponents();
		addComponents();
	}

	void initComponents() {
		firstBtn = new JButton();
		secondBtn = new JButton();
		thirdBtn = new JButton();
		
		firstBtn.addActionListener(e -> delegate.firstBtnWasClicked());
		secondBtn.addActionListener(e -> delegate.secondBtnWasClicked());
		thirdBtn.addActionListener(e -> delegate.thirdBtnWasClicked());
	}
	
	private void addComponents() {
		int row = 1;
		// 1. Buttons
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.WEST;
		
		addComponent(firstBtn, row, 0);
		addComponent(secondBtn, row, 1);
		
		gbc.anchor = GridBagConstraints.EAST;
		gbc.insets = new Insets(0, 0, 0, 50);
		addComponent(thirdBtn, row, 2);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
