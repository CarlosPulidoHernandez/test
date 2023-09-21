package uclm.esi.filemanagement;

import java.util.List;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * This class represents a {@code Project}.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
public class Project {
	
	private FileSystemElement project;
	private ProjectConfiguration projectConfiguration;

	public Project() {
		super();
	}
	
	public Project(FileSystemElement project) {
        this.project = project;
        this.projectConfiguration = new ProjectConfiguration();
    }

	public Project(FileSystemElement project, ProjectConfiguration projectConfiguration) {
        this.project = project;
        this.projectConfiguration = projectConfiguration;
    }
	
	@JsonIgnore
    public List<PythonFile> getAllPythonFiles() {
        List<PythonFile> pythonFiles = new ArrayList<>();
        this.collectPythonFiles(this.project, pythonFiles);
        return pythonFiles;
    }
	
	@JsonIgnore
    public List<JavaFile> getAllJavaFiles() {
        List<JavaFile> pythonFiles = new ArrayList<>();
        this.collectJavaFiles(this.project, pythonFiles);
        return pythonFiles;
    }
	
	@JsonIgnore
    private void collectJavaFiles(FileSystemElement fileSystemElement, List<JavaFile> pythonFiles) {
        if (fileSystemElement instanceof Directory) {
            Directory directory = (Directory) fileSystemElement;
            for (FileSystemElement child : directory.getChildren()) {
            	collectJavaFiles(child, pythonFiles);
            }
        } else if (fileSystemElement instanceof JavaFile) {
        	JavaFile pythonFile = (JavaFile) fileSystemElement;
            pythonFiles.add(pythonFile);
        }
    }
	

	@JsonIgnore
    private void collectPythonFiles(FileSystemElement fileSystemElement, List<PythonFile> pythonFiles) {
        if (fileSystemElement instanceof Directory) {
            Directory directory = (Directory) fileSystemElement;
            for (FileSystemElement child : directory.getChildren()) {
                collectPythonFiles(child, pythonFiles);
            }
        } else if (fileSystemElement instanceof PythonFile) {
            PythonFile pythonFile = (PythonFile) fileSystemElement;
            pythonFiles.add(pythonFile);
        }
    }

	public FileSystemElement getProject() {
		return project;
	}

	public void setProject(FileSystemElement project) {
		this.project = project;
	}

	public ProjectConfiguration getProjectConfiguration() {
		return projectConfiguration;
	}

	public void setProjectConfiguration(ProjectConfiguration projectConfiguration) {
		this.projectConfiguration = projectConfiguration;
	}

	@Override
	public String toString() {
		return "Project [project=" + project + ", projectConfiguration=" + projectConfiguration + "]";
	}

}
