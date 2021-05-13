package app.components;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class Navigator extends HBox {

	public Navigator() {
		FXMLLoader loader = new FXMLLoader();
		loader.setRoot(this);
		loader.setControllerFactory((empty) -> this);
		String filename = this.getClass().getSimpleName();
		try {
			loader.load(this.getClass().getResourceAsStream(String.format("%s.fxml", filename)));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
