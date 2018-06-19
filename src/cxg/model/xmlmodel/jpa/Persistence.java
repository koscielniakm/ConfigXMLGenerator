package cxg.model.xmlmodel.jpa;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="persistence")
public class Persistence {

	private String xmlns;
	private String xmlnsXsi;
	private String xsiSchemaLocation;
	private String version;
	private PersistenceUnit persistenceUnit;
	
	public Persistence() { }

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
	
	public void setXmlns(String xmlns) {
		this.xmlns = xmlns;
	}
	
	public void setXmlnsXsi(String xmlnsXsi) {
		this.xmlnsXsi = xmlnsXsi;
	}
	
	public void setXsiSchemaLocation(String xsiSchemaLocation) {
		this.xsiSchemaLocation = xsiSchemaLocation;
	}
	
	public void setVersion(String version) {
		this.version = version;
	}
	
	public void setPersistenceUnit(PersistenceUnit persistenceUnit) {
		this.persistenceUnit = persistenceUnit;
	}
	
}
