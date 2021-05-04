package sample;
import javafx.scene.layout.Pane;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;

import java.io.IOException;
public class Card extends Pane {
	@FXML
	private TextField textField;

	public Card() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("custom_control.fxml"));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);

		try {
			fxmlLoader.load();
		} catch (IOException exception) {
			throw new RuntimeException(exception);
		}
	}

	@FXML
	protected void doSomething() {
		System.out.println("The button was clicked!");
	}



}
