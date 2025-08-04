package gui;

import layout.ButtonPanel;

public class QuestionTabButtonPanel extends ButtonPanel {



	// ------------- Start ------------- //
	public QuestionTabButtonPanel(ButtonPanelDelegate delegate) {
		super(delegate);
		setBtnText();
	}

	
	private void setBtnText() {
		firstBtn.setText("Frage löschen");
		secondBtn.setText("Speichern");
		thirdBtn.setText("Neue Frage");
	}


	



	
	

}
