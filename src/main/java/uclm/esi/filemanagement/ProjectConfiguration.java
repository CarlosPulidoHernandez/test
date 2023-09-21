package uclm.esi.filemanagement;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
public class ProjectConfiguration {
    private String instrumentationStrategy;

    public ProjectConfiguration() {

    }
    
    public ProjectConfiguration(String instrumentationStrategy) {
    	this.instrumentationStrategy = instrumentationStrategy;
    }

	public String getInstrumentationStrategy() {
		return instrumentationStrategy;
	}

	public void setInstrumentationStrategy(String instrumentationStrategy) {
		this.instrumentationStrategy = instrumentationStrategy;
	}

	@Override
	public String toString() {
		return "ProjectConfiguration [instrumentationStrategy=" + instrumentationStrategy + "]";
	}
    
}
