package cxg.javafx.stages;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import cxg.model.global.Finals;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public abstract class AbstractStage extends Stage {
		
	protected int width;
	protected int height;
	
	protected Image icon;
	protected String stageTitle;
	
	public AbstractStage(String stageTitle, int width, int height) {
		this.stageTitle = stageTitle;
		this.width = width;
		this.height = height;
		setStageProperties();
	}
	
	protected void setStageProperties() {
		setWidth(width);
		setHeight(height);
		setTitle(stageTitle);
		setIcon();
		show();
	}
	
	protected void setIcon() {
		try {
			icon = new Image(new FileInputStream(Finals.PATH_ICON));
			getIcons().add(icon);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
