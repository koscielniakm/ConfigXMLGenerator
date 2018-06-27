package cxg.fx;

import java.util.LinkedHashMap;
import java.util.Map;
import javafx.scene.control.TextField;;

public class JpaGeneratorStageUserDatasFactory {

	public static Map<String, TextField> getUserDatas() {
		Map<String, TextField> userDatas = new LinkedHashMap<>();
		userDatas.put("persistence-unit-name", getPersistenceUnitTextField());
		userDatas.put("driver-name", getDriverTextField());
		userDatas.put("db-user", getDbUserTextField());
		userDatas.put("db-password", getDbPasswordTextField());
		userDatas.put("url", getUrlTextField());
		userDatas.put("dialect", getDialectTextField());
		userDatas.put("path", getOutputPathTextField());
		return userDatas;
	}
	
	private static TextField getPersistenceUnitTextField() {
		TextField persistenceUnitTextField = new TextField();
		persistenceUnitTextField.setPromptText("PersistenceUnit (ex. MyPersistenceUnit)");
		persistenceUnitTextField.getStyleClass().add("textfield");
		return persistenceUnitTextField;
	}
	
	private static TextField getDriverTextField() {
		TextField driverTextField = new TextField();
		driverTextField.setPromptText("Driver (ex. com.mysql.jdbc.Driver)");
		driverTextField.getStyleClass().add("textfield");
		return driverTextField;
	}
	
	private static TextField getDbUserTextField() {
		TextField dbUserTextField = new TextField();
		dbUserTextField.setPromptText("Database user (ex. root)");
		dbUserTextField.getStyleClass().add("textfield");	
		return dbUserTextField;
	}
	
	private static TextField getUrlTextField() {
		TextField dbPasswordTextField = new TextField();
		dbPasswordTextField.setPromptText("Database password (optional)");
		dbPasswordTextField.getStyleClass().add("textfield");	
		return dbPasswordTextField;
	}
	
	private static TextField getDbPasswordTextField() {
		TextField urlTextField = new TextField();
		urlTextField.setPromptText("URL (ex. jdbc:mysql://localhost:3306/dbname)");
		urlTextField.getStyleClass().add("textfield");	
		return urlTextField;
	}
	
	private static TextField getDialectTextField() {
		TextField dialectTextField = new TextField();
		dialectTextField.setPromptText("Dialect (ex. org.hibernate.dialect.MySQL5Dialect)");
		dialectTextField.getStyleClass().add("textfield");	
		return dialectTextField;
	}
	
	private static TextField getOutputPathTextField() {
		TextField outputPathTextField = new TextField();
		outputPathTextField.setPromptText("Output path");
		outputPathTextField.getStyleClass().add("textfield");	
		return outputPathTextField;
	}
	
}
