package uclm.esi.filemanagement;

import java.io.File;

/**
 * This class represents a {@code FileElement}.
 */
public class FileElement extends FileSystemElement {

	/**
	 * Creates a new empty {@code FileElement}.
	 */
	public FileElement() {
		super();
	}

	/**
	 * Creates a new {@code FileElement} with the given file.
	 *
	 * @param file the file to use for the {@code FileElement}
	 */
	public FileElement(File file) {
		super(file);
	}

	/**
	 * Returns a string representation of this {@code FileElement}.
	 *
	 * @return a string representation of this {@code FileElement}
	 */
	@Override
	public String toString() {
		return "FileElement []";
	}

}
