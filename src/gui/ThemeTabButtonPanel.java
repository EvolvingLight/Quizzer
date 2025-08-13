package gui;

import layout.ButtonPanel;

/**
 * Constructs a new QuestionTabButtonPanel based on the superclass (ButtonPanel) 
 * with the specified delegate for handling button events.
 */
public class ThemeTabButtonPanel extends ButtonPanel {

	/**
	 * The constructor initializes the panel by passing the delegate to the
	 * superclass (ButtonPanel), then sets up the button text specific to this
	 * panel. This ensures the panel is fully configured and ready for use upon
	 * instantiation.
	 *
	 * @param delegate the object that will handle user interactions (e.g., button
	 *                 clicks); must not be {@code null}
	 */
	public ThemeTabButtonPanel(ButtonPanelDelegate delegate) {
		super(delegate);
		setBtnText();
	}

	/**
	 * Sets the text for every single button
	 */
	public void setBtnText() {
		firstBtn.setText("Thema löschen");
		secondBtn.setText("Thema Speichern");
		thirdBtn.setText("Neues Thema");
	}

}
