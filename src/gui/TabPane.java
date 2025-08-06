package gui;
import java.awt.Font;

import javax.swing.JTabbedPane;

/**
 * A customized tabbed pane component used to display multiple panels with a
 * consistent tab font. This class extends {@link JTabbedPane} and configures a
 * default appearance: - Tabs are positioned at the top
 * ({@link JTabbedPane#TOP}) - A uniform font ({@code Arial, 24pt}) is applied
 * to all tab labels Subclasses or containers can add tabs using standard
 * methods like {@link #addTab(String, java.awt.Component)}.
 */
public class TabPane extends JTabbedPane {

	/**
	 * The standard font used for tab labels: Arial, plain, 24pt.
	 */
	private static final Font FONT_TAB = new Font("Arial", Font.PLAIN, 24);

	/**
     * Constructs a new TabPane with tabs positioned at the top.
     * Applies a default font ({@value #FONT_TAB}) to improve readability
     * and ensure visual consistency across all tabs.
     */
	public TabPane() {
		super(JTabbedPane.TOP);
		setFont(FONT_TAB);
	}

}
