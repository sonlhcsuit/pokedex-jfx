package app.components;

import javafx.beans.NamedArg;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;

import java.io.IOException;
import java.util.function.Function;

public class Detail extends BorderPane {

	@FXML
	private Label name;
	@FXML
	private Label number;
	@FXML
	private ImageView image;
	@FXML
	private Navigator navigator;

	@FXML
	private Callback<String, String> loadPokemon;

	public Detail(@NamedArg("name") String name, @NamedArg("number") int number, @NamedArg("image") String image
//			, @NamedArg(value = "loadPokemon", defaultValue = "null") String loadPokemon
	) {
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

		System.out.println(loadPokemon);
//		this.loadPokemon = loadPokemon;
	}

	public void setLoadPokemon(Callback<String, String> loadPokemon) {
		this.loadPokemon = loadPokemon;
	}

	public Callback<String, String> getLoadPokemon() {
		return loadPokemon;
	}

	public Navigator getNavigator() {
		return navigator;
	}

	public void setNavigator(Navigator navigator) {
		this.navigator = navigator;
	}
	//
//	public void initialize() {
//		this.navigator.setLoadPokemon(this.loadPokemon);
//		System.out.println("init load pokemon at detail");
//	}
}
