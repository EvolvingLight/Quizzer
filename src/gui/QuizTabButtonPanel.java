package gui;

import layout.ButtonPanel;

public class QuizTabButtonPanel extends ButtonPanel{

	public QuizTabButtonPanel(ButtonPanelDelegate delegate) {
		super(delegate);
		setBtnText();
	}

	/**
	 * Sets the text for every single button
	 */
	public void setBtnText() {
		firstBtn.setText("Antwort zeigen");
		secondBtn.setText("Antwort Speichern");
		thirdBtn.setText("Nächste Frage");
	}

}
