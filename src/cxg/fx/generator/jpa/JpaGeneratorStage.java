package cxg.fx.generator.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cxg.fx.generator.AbstractGeneratorStage;
import cxg.fx.generator.GeneratorButtonFactory;
import cxg.fx.generator.GeneratorStage;
import cxg.model.save.JpaSaver;
import cxg.model.xmlmodel.jpa.Persistence;
import cxg.model.xmlmodel.jpa.PersistenceUnit;
import cxg.model.xmlmodel.jpa.Properties;
import cxg.model.xmlmodel.jpa.Property;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class JpaGeneratorStage extends AbstractGeneratorStage implements GeneratorStage {

	private static final String TITLE = "Generate persistence.xml";
	private static final String DESCRIPTION = "JPA v. 2.0 with Hibernate ORM";
	
	private Text header;
	private Text description;
	private Map<String, TextField> userDatas;
	private List<Button> buttons;
	
	public JpaGeneratorStage() {
		initStageElements();
		addStageElementsToLayout();
		setLayoutProperties();
		setScene(scene);
		setStageProperties();
		activeCss(layout, scene);
	}
	
	private void initStageElements() {
		header = new Text(TITLE);
		description = new Text(DESCRIPTION);
		userDatas = JpaGeneratorStageUserDatasFactory.getUserDatas();
		buttons = GeneratorButtonFactory.getButtons(this, getOkButtonAction());
	}
	
	private void addStageElementsToLayout() {
		layout.getChildren().add(header);
		layout.getChildren().add(description);
		userDatas.forEach((k, v) -> {
			layout.getChildren().add(v);
		});
		layout.getChildren().addAll(buttons);
	}
	
	private void setLayoutProperties() {
		layout.setSpacing(5);
		layout.setAlignment(Pos.TOP_CENTER);
	}
	
	private void setStageProperties() {
		setWidth(310);
		setHeight(400);
		setTitle(TITLE);
		setResizable(false);
		show();
	}

	@Override
	public Map<String, TextField> getUserDatas() {
		return userDatas;
	}
	
	/* Event of OkButton click : generate persistence.xml */
	private EventHandler<ActionEvent> getOkButtonAction() {
		return new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Map<String, TextField> datasToSaver = getUserDatas();
				JpaSaver saver = new JpaSaver(generatePersistenceFromUserDatas());
				saver.save(datasToSaver.get("path").getText());
			}
		};
	}

	private Persistence generatePersistenceFromUserDatas() {
		Map<String, TextField> datasToSaver = getUserDatas();
		
		List<Property> propertyList = new ArrayList<>();
		propertyList.add(new Property("javax.persistence.jdbc.driver", 
			datasToSaver.get("driver-name").getText()));
		propertyList.add(new Property("javax.persistence.jdbc.user", 
				datasToSaver.get("db-user").getText()));
		propertyList.add(new Property("javax.persistence.jdbc.password", 
				datasToSaver.get("db-password").getText()));
		propertyList.add(new Property("javax.persistence.jdbc.url", 
				datasToSaver.get("url").getText()));
		propertyList.add(new Property("hibernate.dialect", 
				datasToSaver.get("dialect").getText()));
		
		Properties properties = new Properties();
		properties.setProperty(propertyList);
		
		PersistenceUnit persistenceUnit = new PersistenceUnit();
		persistenceUnit.setName(datasToSaver.get("path").getText());
		persistenceUnit.setProperties(properties);
		
		Persistence persistence = new Persistence();
		persistence.setPersistenceUnit(persistenceUnit);
		
		return persistence;
	}
	
}
