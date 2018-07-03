package cxg.fx.generator.jpa;

import java.util.List;
import java.util.Map;

import cxg.fx.generator.AbstractGeneratorStage;
import cxg.fx.generator.GeneratorButtonFactory;
import cxg.fx.generator.GeneratorStage;
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
		buttons = GeneratorButtonFactory.getButtons(this);
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

}
