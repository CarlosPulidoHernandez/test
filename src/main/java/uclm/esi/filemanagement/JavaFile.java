package uclm.esi.filemanagement;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * This class represents a {@code PythonFile}.
 */
public class JavaFile extends FileElement {

	List<GenericMethod> methods;

	/**
	 * Creates a new empty {@code JavaFile}.
	 */
	public JavaFile() {
		super();
	}

	/**
	 * Creates a new {@code JavaFile} with the given file.
	 *
	 * @param file the file to use for the {@code JavaFile}
	 */
	public JavaFile(File file) {
		super(file);
		methods = new ArrayList<>();
	}

	/**
	 * Returns the value that {@code JavaFile} represents.
	 *
	 * @return the instrument value that {@code JavaFile} represents
	 */
	@JsonIgnore
	public boolean isInstrumentable() {
		return this.methods.size() > 0;
	}

	/**
	 * Returns the methods of this {@code JavaFile}.
	 *
	 * @return the methods of this {@code JavaFile}
	 */
	public List<GenericMethod> getMethods() {
		return methods;
	}

	/**
	 * Sets the methods of this {@code JavaFile}.
	 *
	 * @param methods the methods to set
	 */
	public void setMethods(List<GenericMethod> methods) {
		this.methods = methods;
	}

	/**
	 * Returns a string representation of this {@code JavaFile}.
	 * 
	 * @return a string representation of this {@code JavaFile}
	 */
	@Override
	public String toString() {
		return "PythonFile [methods=" + methods + "]";
	}

}