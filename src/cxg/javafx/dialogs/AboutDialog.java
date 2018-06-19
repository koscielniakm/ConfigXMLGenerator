package cxg.javafx.dialogs;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import cxg.model.global.Finals;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class AboutDialog extends Dialog<ButtonType> {
	
	private static final String TITLE = "About";
	private static final String APPLICATION_NAME = "Config XML Generator";
	private static final String AUTHOR = "Author : Mateusz Kościelniak";
	
	public AboutDialog() {
		ButtonType btnOk = ButtonType.OK;
		setTitle(TITLE);
		setIcon();
		setContentText(APPLICATION_NAME + "\n" + AUTHOR + "\n");
		getDialogPane().getButtonTypes().add(btnOk);
		show();
	}
	
	private void setIcon() {
		try {
			Image icon = new Image(new FileInputStream(Finals.PATH_ICON));
			Stage dialogStage = (Stage) getDialogPane().getScene().getWindow();
			dialogStage.getIcons().add(icon);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
