package cxg.fx;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public abstract class AbstractStage extends Stage {
	
	private static final String ICON_PATH = "img/icon.png";
	
	private Image applicationIcon;
	
	public AbstractStage() {
		setIcon();
	}
	
	protected void activeCss(Pane pane, Scene scene) {
		pane.getStyleClass().add("layout");	
		scene.setUserAgentStylesheet("css/style.css");
	}
	
	protected void setIcon() {
		try {
			applicationIcon = getIconFromFile();
			getIcons().add(applicationIcon);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private Image getIconFromFile() throws FileNotFoundException {
		return new Image(new FileInputStream(ICON_PATH));
	}

}
