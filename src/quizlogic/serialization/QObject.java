package quizlogic.serialization;

import java.io.Serializable;

/**
 * /**
 * Base class for objects that require a unique identifier and support serialization
 * This class provides a common {@code id} field and serialization capability for subclasses.
 * It serves as a foundation for entity-like classes such as {@link Question} or {@link Thema}.
 */
public class QObject implements Serializable {
	
	/**
	 * General serial version UID for serialization compatibility
	 */
	protected static final long serialVersionUID = 1L;
	
	/**
	 * A unique id as identifier for this object
	 * A value of -1 indicates that the object has not been assigned a valid ID yet
	 */
	private int id = -1;
	
	/**
	 * Returns the unique id for this object
	 * @return the object id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Sets the unique id for this object
	 * @param id
	 * The id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
}
