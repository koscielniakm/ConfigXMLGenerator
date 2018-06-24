package cxg.model.xmlmodel.hibernate;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="hibernate-configuration")
public class HibernateConfiguration {
	
	private SessionFactory sessionFactory;
	
	public HibernateConfiguration() { }

	@XmlElement(name = "session-factory")
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
