package cxg.model.save;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import cxg.model.xmlmodel.hibernate.HibernateConfiguration;
import cxg.model.xmlmodel.hibernate.Property;
import cxg.model.xmlmodel.hibernate.SessionFactory;

public class HibernateSaverTest {
	
	private HibernateSaver saver;
	
	@Before
	public void before() {
		saver = new HibernateSaver(getExampleHibernateConfiguration());
	}
	
	@Test
	public void testSaveHibernateCfgXmlFile() throws IOException {
		saver.save("");
		File xmlFile = new File("hibernate.cfg.xml");
		if (!xmlFile.exists()) throw new IOException();
		xmlFile.delete();
	}
	
	private HibernateConfiguration getExampleHibernateConfiguration() {
		return new HibernateConfiguration(getExampleSessionFactory());
	}
	
	private SessionFactory getExampleSessionFactory() {
		return new SessionFactory(getExamplePropertyList());
	}
	
	private List<Property> getExamplePropertyList() {
		List<Property> propertyList = new ArrayList<>();
		propertyList.add(new Property("name", "value"));
		propertyList.add(new Property("name", "value"));
		propertyList.add(new Property("name", "value"));
		return propertyList;
	}
	
}
