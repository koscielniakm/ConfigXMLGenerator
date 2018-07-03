package cxg.fx.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class GeneratorButtonFactory {

	public static List<Button> getButtons(GeneratorStage stage) {
		Map<String, TextField> userDatas = stage.getUserDatas();
		List<Button> stageButtons = new ArrayList<>();
		stageButtons.add(getOkButton());
		stageButtons.add(getClearButton(userDatas));
		return stageButtons;
	}
	
	public static Button getOkButton() {
		Button okButton = new Button("Generate!");
		okButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				System.out.println("TODO IMPL");
			}
		});
		return okButton;
	}
	
	public static Button getClearButton(Map<String, TextField> userDatas) {
		Button clearButton = new Button("Clear form");
		clearButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				userDatas.forEach((k, v) -> {
					v.setText("");
				});
			}
		});		
		return clearButton;
	}
	
}
