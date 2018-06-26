package cxg.model.xmlmodel.jpa;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="persistence")
public class Persistence {

	private static final String xmlns = "http://java.sun.com/xml/ns/persistence";
	private static final String xmlnsXsi = "http://www.w3.org/2001/XMLSchema-instance";
	private static final String xsiSchemaLocation = "http://java.sun.com/xml/ns/persistence http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd";
	private static final String version = "2.0";
	private PersistenceUnit persistenceUnit;
	
	public Persistence() { }
	
	public Persistence(PersistenceUnit persistenceUnit) {
		this.persistenceUnit = persistenceUnit;
	}

	@XmlAttribute
	public String getXmlns() {
		return xmlns;
	}
	
	@XmlAttribute(name="xmlns:xsi")
	public String getXmlnsXsi() {
		return xmlnsXsi;
	}
	
	@XmlAttribute(name="xsi:schemaLocation")
	public String getXsiSchemaLocation() {
		return xsiSchemaLocation;
	}
	
	@XmlAttribute
	public String getVersion() {
		return version;
	}
	
	@XmlElement(name = "persistence-unit")
	public PersistenceUnit getPersistenceUnit() {
		return persistenceUnit;
	}
	
	public void setPersistenceUnit(PersistenceUnit persistenceUnit) {
		this.persistenceUnit = persistenceUnit;
	}
	
}
