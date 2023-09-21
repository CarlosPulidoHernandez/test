package uclm.esi.filemanagement;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FilenameUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * This class represents a {@code Directory}.
 */
public class Directory extends FileSystemElement {

	private List<FileSystemElement> children;

	/**
	 * Creates a new empty {@code Directory}.
	 */
	public Directory() {
		super();
	}

	/**
	 * Creates a new {@code Directory} with the given file.
	 *
	 * @param file the file to use for the {@code Directory}
	 */
	public Directory(File file) {
		super(file);
		children = new ArrayList<>();
	}

	/**
	 * Adds element as a child of the {@code Directory}
	 *
	 * @param element the element to add
	 */
	public void addElement(FileSystemElement element) {
		children.add(element);
	}

	/**
	 * Removes element as a child of the {@code Directory}
	 *
	 * @param element the element to remove
	 */
	public void removeElement(FileSystemElement element) {
		children.remove(element);
	}

	/**
	 * Returns a list of all Python files contained within this {@code Directory}
	 * and its subdirectories.
	 *
	 * @return a list of all Python files contained within this {@code Directory}
	 *         and its subdirectories
	 */
	@JsonIgnore
	public List<PythonFile> getPythonFiles() {
		List<PythonFile> pythonFiles = new ArrayList<>();
		for (FileSystemElement child : children) {
			if (child instanceof PythonFile) {
				pythonFiles.add((PythonFile) child);
			} else if (child instanceof Directory) {
				pythonFiles.addAll(((Directory) child).getPythonFiles());
			}
		}
		return pythonFiles;
	}
	
	public <T extends FileElement> List<T> getFilesOfType(Class<T> fileType) {
	    List<T> filesOfType = new ArrayList<>();
	    for (FileSystemElement child : children) {
	        if (fileType.isInstance(child)) {
	            filesOfType.add(fileType.cast(child));
	        } else if (child instanceof Directory) {
	            filesOfType.addAll(((Directory) child).getFilesOfType(fileType));
	        }
	    }
	    return filesOfType;
	}

	public List<FileElement> getFilesOfType(String extension) {
		List<FileElement> filesOfType = new ArrayList<>();
		for (FileSystemElement child : children) {
			if (child instanceof Directory) {
				filesOfType.addAll(((Directory) child).getFilesOfType(extension));
			} else {
				String childExtension = FilenameUtils.getExtension(child.getFile().getName());
				switch (childExtension) {
				case "java":
					if ("java".equals(extension)) {
						filesOfType.add((JavaFile) child);
					}
					break;
				case "py":
					if ("py".equals(extension)) {
						filesOfType.add((PythonFile) child);
					}
					break;
				}
			}
		}
		return filesOfType;
	}
	
	
	public List<FileElement> getFilesOfType2(String extension) {
		List<FileElement> filesOfType = new ArrayList<>();
		for (FileSystemElement child : children) {
			if (child instanceof Directory) {
				filesOfType.addAll(((Directory) child).getFilesOfType(extension));
			} else {
				String childExtension = FilenameUtils.getExtension(child.getFile().getName());
				switch (childExtension) {
				case "java":
					if ("Java".equals(extension)) {
						filesOfType.add((JavaFile) child);
					}
					break;
				case "py":
					if ("Python".equals(extension)) {
						filesOfType.add((PythonFile) child);
					}
					break;
				}
			}
		}
		return filesOfType;
	}

	/**
	 * Returns the children of this {@code Directory}.
	 *
	 * @return the children of this {@code Directory}
	 */
	public List<FileSystemElement> getChildren() {
		return children;
	}

	/**
	 * Sets the children of this {@code Directory}.
	 *
	 * @param children the children to set
	 */
	public void setChildren(List<FileSystemElement> children) {
		this.children = children;
	}

	/**
	 * Returns a string representation of this {@code Directory}.
	 *
	 * @return a string representation of this {@code Directory}
	 */
	@Override
	public String toString() {
		return "Directory [children=" + children + "]";
	}

}
