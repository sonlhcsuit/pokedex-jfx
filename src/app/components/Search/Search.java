package app.components.Search;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class Search extends HBox {
	public Search() throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setRoot(this);

		loader.setControllerFactory((t) -> this);
		String filename = this.getClass().getSimpleName().toString() + ".fxml";
		System.out.printf("%f", filename);
		try {
			loader.load(getClass().getResourceAsStream(filename));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
