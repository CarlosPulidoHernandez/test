package uclm.esi.filemanagement;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * This class represents a {@code PythonFile}.
 */
public class PythonFile extends FileElement {

	List<PythonFunction> methods;

	/**
	 * Creates a new empty {@code PythonFile}.
	 */
	public PythonFile() {
		super();
	}

	/**
	 * Creates a new {@code PythonFile} with the given file.
	 *
	 * @param file the file to use for the {@code PythonFile}
	 */
	public PythonFile(File file) {
		super(file);
		methods = new ArrayList<>();
	}

	/**
	 * Returns the value that {@code PythonFile} represents.
	 *
	 * @return the instrument value that {@code PythonFile} represents
	 */
	@JsonIgnore
	public boolean isInstrumentable() {
		return this.methods.size() > 0;
	}

	/**
	 * Returns the methods of this {@code PythonFile}.
	 *
	 * @return the methods of this {@code PythonFile}
	 */
	public List<PythonFunction> getMethods() {
		return methods;
	}

	/**
	 * Sets the methods of this {@code PythonFile}.
	 *
	 * @param methods the methods to set
	 */
	public void setMethods(List<PythonFunction> methods) {
		this.methods = methods;
	}

	/**
	 * Returns a string representation of this {@code PythonFile}.
	 * 
	 * @return a string representation of this {@code PythonFile}
	 */
	@Override
	public String toString() {
		return "PythonFile [methods=" + methods + "]";
	}

}
