import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class AppWindow extends Application {

	private static final int WINDOW_WIDTH = 300;
	private static final int WINDOW_HEIGHT = 300;
	private static final String APP_TITLE = "Config XML Generator";
	private static final String ICON_PATH = "xml.png";
	
	private Image icon;
	
	@Override
	public void start(Stage rootStage) {
		setDefaultWindowDimension(rootStage);
		setIcon(rootStage);
		rootStage.setTitle(APP_TITLE);
		rootStage.show();
	}
	private void setDefaultWindowDimension(Stage stage) {
		stage.setWidth(WINDOW_WIDTH);
		stage.setHeight(WINDOW_HEIGHT);
	}
	private void setIcon(Stage stage) {
		try {
			icon = new Image(new FileInputStream(ICON_PATH));
			stage.getIcons().add(icon);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public static void main(String[] args) {
		launch();
	}
	
}
