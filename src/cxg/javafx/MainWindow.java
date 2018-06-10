package cxg.javafx;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.Application;
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

public class MainWindow extends Application {

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
	
	@Override
	public void start(Stage rootStage) {
		loadComponents(rootStage);
		setRootStageProperties(rootStage);
	}
	
	private void loadComponents(Stage stage) {
		loadLayout();
		loadTitleText();
		loadJpaButton();
		loadHibernateButton();
		loadAboutButton();
		loadExitButton();
		addComponentsToLayout();
		setLayoutProperties();
		loadMainScene(stage);
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
	private void loadMainScene(Stage stage) {
		mainScene = new Scene(layout);
		stage.setScene(mainScene);
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
	
	private void setRootStageProperties(Stage rootStage) {
		setDefaultWindowDimension(rootStage);
		setIcon(rootStage);
		rootStage.setTitle(APP_TITLE);
		rootStage.setResizable(false);
		rootStage.show();
	}
	private void setDefaultWindowDimension(Stage stage) {
		stage.setWidth(WINDOW_WIDTH);
		stage.setHeight(WINDOW_HEIGHT);
	}
	private void setIcon(Stage stage) {
		try {
			icon = new Image(new FileInputStream(PathContainer.PATH_ICON));
			stage.getIcons().add(icon);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch();
	}
	
}
