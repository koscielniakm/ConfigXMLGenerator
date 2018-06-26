package cxg.model.save;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import cxg.model.xmlmodel.jpa.Persistence;
import cxg.model.xmlmodel.jpa.PersistenceUnit;
import cxg.model.xmlmodel.jpa.Properties;
import cxg.model.xmlmodel.jpa.Property;

public class JpaSaverTest {
	
	private JpaSaver saver;
	
	@Before
	public void before() {
		saver = new JpaSaver(getExamplePersistence());
	}

	@Test
	public void testSavePersistenceXmlFile() throws IOException {
		saver.save("");
		File xmlFile = new File("persistence.xml");
		if (!xmlFile.exists()) throw new IOException();
		xmlFile.delete();
	}
	
	private Persistence getExamplePersistence() {
		return new Persistence(getExamplePersistenceUnit());
	}
	
	private PersistenceUnit getExamplePersistenceUnit() {
		return new PersistenceUnit(getExampleProperties(), "persistenceUnitName");
	}
	
	private Properties getExampleProperties() {
		List<Property> propertyList = new ArrayList<Property>();
		propertyList.add(new Property("name1", "val1"));
		propertyList.add(new Property("name2", "val2"));
		propertyList.add(new Property("name3", "val3"));
		return new Properties(propertyList);
	}
	
}