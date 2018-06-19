package cxg.model.xmlmodel.jpa;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="persistence-unit")
@XmlType(propOrder={"provider", "properties"})
public class PersistenceUnit {

	private String name;
	private String transactionType;
	private String provider;
	private Properties properties;
	
	public PersistenceUnit() { }

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

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}


	
}
