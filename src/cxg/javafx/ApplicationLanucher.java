package cxg.javafx;

import javafx.application.Application;
import javafx.stage.Stage;

public class ApplicationLanucher extends Application {

	@Override
	public void start(Stage rootStage) {
		new MainStage();
	}

	public static void main(String[] args) {
		launch();
	}
	
}
