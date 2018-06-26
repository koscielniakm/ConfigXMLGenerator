package cxg.model.xmlmodel.jpa;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="persistence-unit")
@XmlType(propOrder={"provider", "properties"})
public class PersistenceUnit {

	private static final String transactionType = "RESOURCE_LOCAL";
	private static final String provider = "org.hibernate.jpa.HibernatePersistenceProvider";
	private String name;
	private Properties properties;
	
	public PersistenceUnit() { }
	
	public PersistenceUnit(Properties properties, String persistenceUnitName) {
		this.name = persistenceUnitName;
		this.properties = properties;
	}

	@XmlAttribute
	public String getName() {
		return name;
	}

	@XmlAttribute(name = "transaction-type")
	public String getTransactionType() {
		return transactionType;
	}

	@XmlElement
	public String getProvider() {
		return provider;
	}

	@XmlElement
	public Properties getProperties() {
		return properties;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	
}
