package cxg.model.save;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;

public abstract class AbstractXmlSaver {
	
	private JAXBContext jaxbContext;
	
	private Marshaller marshaller;
	
	protected void loadMarshaller(JAXBContext context) {
		try {
			createMarshaller(context);
			setMarshallerProperties();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	private void createMarshaller(JAXBContext context) throws JAXBException {
		marshaller = context.createMarshaller();
	}
	
	private void setMarshallerProperties() throws PropertyException {
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	}
	
	protected JAXBContext getJaxbContext() {
		return jaxbContext;
	}

	protected void setJaxbContext(JAXBContext jaxbContext) {
		this.jaxbContext = jaxbContext;
	}
	
	protected Marshaller getMarshaller() {
		return marshaller;
	}

}
