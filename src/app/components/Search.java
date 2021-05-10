package app.components;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class Search extends HBox {
	public Search(){
		FXMLLoader loader = new FXMLLoader();
		loader.setRoot(this);
		loader.setControllerFactory(t -> this);
		String fileName = this.getClass().getSimpleName() + ".fxml";
		try {
			loader.load(this.getClass().getResourceAsStream(fileName));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
