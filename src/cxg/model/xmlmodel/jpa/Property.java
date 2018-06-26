package cxg.model.xmlmodel.jpa;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="property")
public class Property {
	
	private String name;
	private String value;
	
	public Property() { }
	
	public Property(String name, String value) {
		this.name = name;
		this.value = value;
	}

	@XmlAttribute
	public String getName() {
		return name;
	}

	@XmlAttribute
	public String getValue() {
		return value;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
