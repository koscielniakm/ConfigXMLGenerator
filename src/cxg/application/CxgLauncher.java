package cxg.application;

import cxg.fx.mainstage.MainStage;
import javafx.application.Application;
import javafx.stage.Stage;

public class CxgLauncher extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage = new MainStage();
	}
	
	public static void main(String[] args) {
		launch();
	}

}
