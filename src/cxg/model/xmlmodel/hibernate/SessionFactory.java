package cxg.model.xmlmodel.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="session-factory")
public class SessionFactory {

	private List<Property> property;
	
	public SessionFactory() {
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
