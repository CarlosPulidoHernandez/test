package uclm.esi.filemanagement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * This class represents a {@code GenericMethod}.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
public class GenericMethod {

	private String name;
	private int beginLine;
	private int endLine;

	@JsonIgnore
	private boolean hasReturn;
	@JsonIgnore
	private boolean singleLine;

	/**
	 * Creates a new empty {@code GenericMethod}.
	 */
	public GenericMethod() {
		super();
	}

	/**
	 * Creates a new {@code GenericMethod} with the given name, beginLine and
	 * endLine.
	 *
	 * @param name      the name to use for the {@code PythonMethod}
	 * @param beginLine the beginLine to use for the {@code PythonMethod}
	 * @param endLine   the endLine to use for the {@code PythonMethod}
	 */
	public GenericMethod(String name, int beginLine, int endLine) {
		this.name = name;
		this.beginLine = beginLine;
		this.endLine = endLine;
	}

	/**
	 * Returns the name of this {@code GenericMethod}.
	 *
	 * @return the name of this {@code GenericMethod}
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of this {@code GenericMethod}.
	 *
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the beginLine of this {@code GenericMethod}.
	 *
	 * @return the beginLine of this {@code GenericMethod}
	 */
	public int getBeginLine() {
		return beginLine;
	}

	/**
	 * Sets the beginLine of this {@code GenericMethod}.
	 *
	 * @param beginLine the name to set
	 */
	public void setBeginLine(int beginLine) {
		this.beginLine = beginLine;
	}

	/**
	 * Returns the endLine of this {@code GenericMethod}.
	 *
	 * @return the endLine of this {@code GenericMethod}
	 */
	public int getEndLine() {
		return endLine;
	}

	/**
	 * Sets the endLine of this {@code GenericMethod}.
	 *
	 * @param endLine the name to set
	 */
	public void setEndLine(int endLine) {
		this.endLine = endLine;
	}

	public boolean isHasReturn() {
		return hasReturn;
	}

	public void setHasReturn(boolean hasReturn) {
		this.hasReturn = hasReturn;
	}

	public boolean isSingleLine() {
		return singleLine;
	}

	public void setSingleLine(boolean singleLine) {
		this.singleLine = singleLine;
	}

	/**
	 * Returns whether some other object is "equal to" this one.
	 * 
	 * @param obj the reference object with which to compare
	 * 
	 * @return true if any other object is "equal to" this one, false otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof GenericMethod)) {
			return false;
		}
		GenericMethod compare = (GenericMethod) obj;
		return this.beginLine == compare.beginLine;
	}

	/**
	 * Returns a hash code value for the object.
	 *
	 * @return a hash code value for the object
	 */
	@Override
	public int hashCode() {
		return beginLine;
	}

	/**
	 * Returns a string representation of this {@code PythonMethod}.
	 *
	 * @return a string representation of this {@code PythonMethod}
	 */
	@Override
	public String toString() {
		return "PythonMethod [name=" + name + ", beginLine=" + beginLine + ", endLine=" + endLine + "]";
	}

}