package cxg.model.save;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import cxg.model.xmlmodel.jpa.Persistence;
import cxg.model.xmlmodel.jpa.PersistenceUnit;

public class JpaSaverTest {

	private Persistence persistence;
	
	private JpaSaver saver;
	
	@Before
	public void before() {
		persistence = new Persistence();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreateSaverWithoutCompletedPersistenceAttributes() {
		setCorrectPersistenceUnit();
		saver = new JpaSaver(persistence);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreateSaverWithoutCompletedPersistenceUnit() {
		setCorrectPersistenceAttributes();
		saver = new JpaSaver(persistence);
	}
	
	@Test
	public void testSaveXmlFile() throws IOException {
		setCorrectPersistenceUnit();
		setCorrectPersistenceAttributes();
		saver = new JpaSaver(persistence);
		saver.save("");
		File xmlFile = new File("persistence.xml");
		if (!xmlFile.exists()) throw new IOException();
		xmlFile.delete();
	}
	
	private void setCorrectPersistenceAttributes() {
		persistence.setXmlns("test");
		persistence.setXmlnsXsi("test");
		persistence.setXsiSchemaLocation("test");
		persistence.setVersion("test");
	}
	
	private void setCorrectPersistenceUnit() {
		persistence.setPersistenceUnit(new PersistenceUnit());
	}
	
}
