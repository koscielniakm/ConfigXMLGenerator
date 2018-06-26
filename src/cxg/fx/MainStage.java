package cxg.fx;

import java.util.List;

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainStage extends Stage {
	
	private static final String TITLE = "Config Xml Generator";
	
	private Scene mainScene;
	private VBox layout;
	
	private List<Button> buttons;
	
	public MainStage() {
		initStageElements();
		addStageElementsToLayout();
		addMainSceneToStage();
		setStageProperties();
		setLayoutProperties();
		addCssToMainScene();
	}
	
	private void initStageElements() {
		layout = new VBox();
		mainScene = new Scene(layout);
		buttons = MainStageButtonFactory.getButtonList();
	}
	
	private void addStageElementsToLayout() {
		layout.getChildren().addAll(buttons);
	}
	
	private void addMainSceneToStage() {
		setScene(mainScene);
	}
	
	private void setStageProperties() {
		setWidth(300);
		setHeight(300);
		setTitle(TITLE);
		show();
	}
	
	private void setLayoutProperties() {
		layout.setSpacing(10);
		layout.setAlignment(Pos.TOP_CENTER);
	}
	
	private void addCssToMainScene() {
		mainScene.setUserAgentStylesheet("css/style.css");
	}
	
}
