package cxg.fx.mainstage;

import java.util.ArrayList;
import java.util.List;

import cxg.fx.generator.hibernate.HibernateGeneratorStage;
import cxg.fx.generator.jpa.JpaGeneratorStage;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;

public class MainStageButtonFactory {
	
	public static List<Button> getButtonList() {
		List<Button> buttons = new ArrayList<>();
		buttons.add(getJpaGeneratorButton());
		buttons.add(getHibernateGeneratorButton());
		buttons.add(getExitButton());
		return buttons;
	}
	
	private static Button getJpaGeneratorButton() {
		Button jpaButton = new Button();
		jpaButton.setText("Get persistence.xml");
		jpaButton.setTooltip(new Tooltip("Generate persistence.xml for Java Persistence API 2.0"));
		jpaButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				new JpaGeneratorStage();
			}
		});
		return jpaButton;
	}

	private static Button getHibernateGeneratorButton() {
		Button hibernateButton = new Button();
		hibernateButton.setText("Get hibernate.cfg.xml");
		hibernateButton.setTooltip(new Tooltip("Generate hibernate.cfg.xml for Hibernate 5"));
		hibernateButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				new HibernateGeneratorStage();
			}
		});
		return hibernateButton;
	}
	
	private static Button getExitButton() {
		Button jpaButton = new Button();
		jpaButton.setText("Exit generator");
		jpaButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Platform.exit();
			}
		});
		return jpaButton;
	}
	
}
