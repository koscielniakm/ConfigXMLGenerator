package cxg.fx;

import java.util.List;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainStage extends Stage {
	
	private static final String TITLE = "Config Xml Generator";
	private static final String FOOTER_TEXT = "Author: Mateusz Kościelniak";
	
	private Scene mainScene;
	private VBox layout;
	
	private Text headerText;
	private Text footerText;
	
	private List<Button> buttons;
	
	public MainStage() {
		initStageElements();
		addStageElementsToLayout();
		setLayoutProperties();
		addMainSceneToStage();
		setStageProperties();
		activeCss();
	}
	
	private void initStageElements() {
		headerText = new Text(TITLE);
		headerText.getStyleClass().add("headertext");
		layout = new VBox();
		mainScene = new Scene(layout);
		buttons = MainStageButtonFactory.getButtonList();
		footerText = new Text(FOOTER_TEXT);
	}
	
	private void addStageElementsToLayout() {
		layout.getChildren().add(headerText);
		layout.getChildren().addAll(buttons);
		layout.getChildren().add(footerText);
	}
	
	private void addMainSceneToStage() {
		setScene(mainScene);
	}
	
	private void setStageProperties() {
		setWidth(300);
		setHeight(240);
		setTitle(TITLE);
		setResizable(false);
		show();
	}
	
	private void setLayoutProperties() {
		layout.setSpacing(10);
		layout.setAlignment(Pos.TOP_CENTER);
	}
	
	private void activeCss() {
		layout.getStyleClass().add("layout");	
		mainScene.setUserAgentStylesheet("css/style.css");
	}
	
}
