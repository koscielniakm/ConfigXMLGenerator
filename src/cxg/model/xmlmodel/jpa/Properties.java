package cxg.model.xmlmodel.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="properties")
public class Properties {

	List<Property> property;
	
	public Properties() {
		property = new ArrayList<>();
	}

	@XmlElement
	public List<Property> getProperty() {
		return property;
	}

	public void setProperty(List<Property> property) {
		this.property = property;
	}
	
	
	
}
