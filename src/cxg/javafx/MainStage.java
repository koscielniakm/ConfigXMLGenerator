package cxg.javafx;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainStage extends Stage {

	private static final int WINDOW_WIDTH = 300;
	private static final int WINDOW_HEIGHT = 225;
	private static final String APP_TITLE = "Config XML Generator";
	
	private Image icon;
	
	private Scene mainScene;
	private VBox layout;
	
	private Text title;
	private Button jpaBtn;
	private Button hibernateBtn;
	private Button aboutBtn;
	private Button exitBtn;
	
	public MainStage() {
		loadComponents();
		setRootStageProperties();
	}
	
	private void loadComponents() {
		loadLayout();
		loadTitleText();
		loadJpaButton();
		loadHibernateButton();
		loadAboutButton();
		loadExitButton();
		addComponentsToLayout();
		setLayoutProperties();
		loadMainScene();
	}
	private void loadLayout() {
		layout = new VBox();
	}
	private void loadTitleText() {
		title = new Text("Config XML Generator");
		title.setFont(new Font(null, 20));
	}
	private void loadJpaButton() {
		jpaBtn = new Button();
		jpaBtn.setText("Create persistence.xml for JPA 2.0");
		jpaBtn.setFocusTraversable(false);
	}
	private void loadHibernateButton() {
		hibernateBtn = new Button();
		hibernateBtn.setText("Create hibernate.cfg.xml for Hibernate 5");
		hibernateBtn.setFocusTraversable(false);
	}	
	private void loadAboutButton() {
		aboutBtn = new Button();
		aboutBtn.setText("About");
		aboutBtn.setFocusTraversable(false);
		aboutBtn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				new AboutDialog();
			}
		});
	}
	private void loadExitButton() {
		exitBtn = new Button();
		exitBtn.setText("Exit");
		exitBtn.setFocusTraversable(false);
		exitBtn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Platform.exit();
			}
		});
	}
	private void loadMainScene() {
		mainScene = new Scene(layout);
		setScene(mainScene);
	}
	
	private void addComponentsToLayout() {
		layout.getChildren().addAll(
			title, 
			jpaBtn, 
			hibernateBtn, 
			aboutBtn, 
			exitBtn
		);
	}
	
	private void setLayoutProperties() {
		layout.setAlignment(Pos.TOP_CENTER);
		layout.setLayoutY(10);
		layout.setSpacing(10);
	}
	
	private void setRootStageProperties() {
		setDefaultWindowDimension();
		setIcon();
		setTitle(APP_TITLE);
		setResizable(false);
		show();
	}
	private void setDefaultWindowDimension() {
		setWidth(WINDOW_WIDTH);
		setHeight(WINDOW_HEIGHT);
	}
	private void setIcon() {
		try {
			icon = new Image(new FileInputStream(PathContainer.PATH_ICON));
			getIcons().add(icon);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
