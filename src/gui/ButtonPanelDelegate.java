package gui;

/**
 * A delegate interface for handling button click events from UI panels.
 * Classes that implement this interface agree to receive notifications when
 * buttons in a control panel (e.g., {@link QuestionTabButtonPanel}) are clicked.
 * This follows the delegation pattern, commonly used in GUI programming to separate
 * event handling logic from component layout.
 * Typically implemented by container panels or controllers that need to respond
 * to user actions such as navigation, data updates, or view changes.
 */
public interface ButtonPanelDelegate {

	/**
     * Called when the first button is clicked.
     * No default behavior — implementation is up to the delegate.
     */
	public void firstBtnWasClicked();
	
	/**
     * Called when the second button is clicked.
     * No default behavior — implementation is up to the delegate.
     */
	public void secondBtnWasClicked();
	
	/**
     * Called when the third button is clicked.
     * No default behavior — implementation is up to the delegate.
     */
	public void thirdBtnWasClicked();
	
	
}