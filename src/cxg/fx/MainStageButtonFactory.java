package cxg.fx;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;

public class MainStageButtonFactory {

	public static List<Button> getButtonList() {
		List<Button> buttons = new ArrayList<>();
		buttons.add(getJpaGeneratorButton());
		return buttons;
	}
	
	private static Button getJpaGeneratorButton() {
		Button jpaButton = new Button();
		jpaButton.setText("Get persistence.xml for JPA 2.0");
		jpaButton.setTooltip(new Tooltip("Generate persistence.xml for JPA 2.0")); //TODO tooltip text
		jpaButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				//TODO action
			}
		});
		return jpaButton;
	}

}
