package uclm.esi.filemanagement;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * This class represents a {@code FileSystemElement}. This is an abstract class
 * that cannot be instantiated directly, but serves as the base class for files
 * and directories.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
public abstract class FileSystemElement {

	protected File file;

	/**
	 * Creates a new empty {@code FileSystemElement}.
	 */
	protected FileSystemElement() {
		super();
	}

	/**
	 * Creates a new {@code FileSystemElement} with the given file.
	 *
	 * @param file the file to use for the {@code FileSystemElement}
	 */
	protected FileSystemElement(File file) {
		this.file = file;
	}

	/**
	 * Returns the file that {@code FileSystemElement} represents.
	 *
	 * @return the file that {@code FileSystemElement} represents
	 */
	public File getFile() {
		return file;
	}

	/**
	 * Sets the file that {@code FileSystemElement} represents.
	 *
	 * @param file the file that {@code FileSystemElement} represents
	 */
	public void setFile(File file) {
		this.file = file;
	}

	/**
	 * Returns a string representation of this {@code FileSystemElement}.
	 *
	 * @return a string representation of this {@code FileSystemElement}
	 */
	@Override
	public String toString() {
		return "FileSystemElement [file=" + file + "]";
	}

}
