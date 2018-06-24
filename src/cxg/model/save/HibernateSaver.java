package cxg.model.save;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import cxg.model.xmlmodel.hibernate.HibernateConfiguration;

public class HibernateSaver extends AbstractXmlSaver implements XmlSaver {

	private HibernateConfiguration hibernateConfiguration;
	
	public HibernateSaver(HibernateConfiguration hibernateConfiguration) {
		this.hibernateConfiguration = hibernateConfiguration;
		createJaxbContext();
		loadMarshaller(getJaxbContext());
	}
	
	public void createJaxbContext() {
		try {
			JAXBContext currentContext = JAXBContext.newInstance(HibernateConfiguration.class);
			super.setJaxbContext(currentContext);
		} catch(JAXBException e) {
			e.printStackTrace();
		}
	}
	
	public void save(String path) {
		try {
			Marshaller m = getMarshaller();
			m.marshal(hibernateConfiguration, new File("hibernate.cfg.xml"));	
		} catch(JAXBException e) {
			e.printStackTrace();
		}
	}
	
}
