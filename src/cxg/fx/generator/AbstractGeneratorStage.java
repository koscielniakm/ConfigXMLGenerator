package cxg.fx.generator;

import cxg.fx.AbstractStage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

public abstract class AbstractGeneratorStage extends AbstractStage {

	protected Scene scene;
	protected VBox layout;
	
	public AbstractGeneratorStage() {
		super();
		layout = new VBox();
		scene = new Scene(layout);
	}
	
}

