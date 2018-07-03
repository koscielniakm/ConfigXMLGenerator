package cxg.fx.mainstage;

import java.util.List;

import cxg.fx.AbstractStage;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.WindowEvent;

public class MainStage extends AbstractStage {
	
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
		activeCss(layout, mainScene);
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
		setOnCloseRequest(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent event) {
				Platform.exit();
			}
		});
		show();
	}
	
	private void setLayoutProperties() {
		layout.setSpacing(10);
		layout.setAlignment(Pos.TOP_CENTER);
	}
	
}
