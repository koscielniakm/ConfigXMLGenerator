package cxg.model.save;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import cxg.model.xmlmodel.jpa.Persistence;

public class JpaSaver extends AbstractXmlSaver implements XmlSaver {

	private Persistence persistence;
	
	public JpaSaver(Persistence persistence) {
		this.persistence = persistence;
		createJaxbContext();
		loadMarshaller(getJaxbContext());
	}
	
	public void createJaxbContext() {
		try {
			JAXBContext currentContext = JAXBContext.newInstance(Persistence.class);
			super.setJaxbContext(currentContext);
		} catch(JAXBException e) {
			e.printStackTrace();
		}
	}
	
	public void save(String path) {
		try {
			Marshaller m = getMarshaller();
			m.marshal(persistence, new File(path + "/" + "persistence.xml"));	
		} catch(JAXBException e) {
			e.printStackTrace();
		}
	}
	
}
