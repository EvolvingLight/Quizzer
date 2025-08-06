package gui;

import java.awt.GridBagLayout;

import layout.QPanel;

public class QuizTabMainPanel extends QPanel implements ButtonPanelDelegate {

	private QPanel leftPanel;
	private QPanel rightPanel;
	private QPanel bottomPanel;

	public QuizTabMainPanel() {
		super();
		setLayout();
		initPanels();
	}
	
	/**
	 * Sets the layout manager for this panel to {@link GridBagLayout}.
     * This layout allows flexible and precise positioning of components in a grid.
     * Constraints are managed via the {@code gbc} instance field.
	 */
	private void setLayout() {
		setLayout(new GridBagLayout());
	}
	
	/**
	 * Initializes all sub-panels and content components.
     * Creates:
     * - Three placeholder panels (left, right, bottom)
     * - Two question display panels
     * - A button panel with this panel as delegate
	 */
	private void initPanels() {
		leftPanel = new QPanel();
		rightPanel = new QPanel();
		bottomPanel = new QPanel();
		
//		themeTabPanel = new ThemePanel();
//		themeTabListPanel = new ThemeListPanel();
//		themeTabBottomPanel = new BottomPanel();
	}

	@Override
	public void firstBtnWasClicked() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void secondBtnWasClicked() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void thirdBtnWasClicked() {
		// TODO Auto-generated method stub
		
	}

}
