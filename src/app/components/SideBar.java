package app.components;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class SideBar extends VBox {
	public SideBar() {
		FXMLLoader loader = new FXMLLoader();
		loader.setRoot(this);
		loader.setControllerFactory((t) -> this);
		String filename = this.getClass().getSimpleName() + ".fxml";
		try {
			loader.load(this.getClass().getResourceAsStream(filename));
		} catch (IOException e){
			throw new RuntimeException(e);
		}

	}
}
