package app.components;

import javafx.beans.NamedArg;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class Detail extends BorderPane {
	@FXML
	private Label name;
	@FXML
	private Label number;
	@FXML
	private ImageView image;
	@FXML
	private Navigator navigator;

	public Detail(@NamedArg("name") String name, @NamedArg("number") int number, @NamedArg("image") String image) {
		FXMLLoader loader = new FXMLLoader();
		loader.setRoot(this);
		loader.setControllerFactory((empty) -> this);
		String fileName = this.getClass().getSimpleName() + ".fxml";
		try {
			loader.load(this.getClass().getResourceAsStream(fileName));
		} catch (IOException e) {
			throw new RuntimeException(e);

		}

		this.name.setText(name.toUpperCase());
		this.number.setText(String.format("%03d", number));
		Image img = new Image(image);
		this.image.setImage(img);
	}

	public void initialize() {

	}
}
