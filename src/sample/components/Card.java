package sample.components;
import java.io.IOException;

import javafx.beans.property.StringProperty;
//import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.Parent;

public class Card extends HBox {
	@FXML
	private TextField textField;
	@FXML
	private ImageView img;

	public Card(String url) {
		super();
		loadFXML(this);
//		img.setImage(new Image(url));
		img.setOnMouseClicked((MouseEvent e)->{
			bug();
		});
	}

	public String getText() {
		return textProperty().get();
	}

	public void setText(String value) {
		textProperty().set(value);
	}

	public StringProperty textProperty() {
		return textField.textProperty();
	}

	@FXML
	protected void doSth() {
		System.out.println("The button was clicked!" + getText());
	}
	@FXML
	protected void bug(){
		String newImageString = String.format("https://assets.pokemon.com/assets/cms2/img/pokedex/full/%03d.png",(int) Math.ceil(Math.random()*800));
		img.setImage(new Image(newImageString));
	}
	public static <T extends Parent> void loadFXML(T component) {
		FXMLLoader loader = new FXMLLoader();
		loader.setRoot(component);
		loader.setControllerFactory(theClass -> component);

		String fileName = component.getClass().getSimpleName() + ".fxml";
		try {
			loader.load(component.getClass().getResourceAsStream(fileName));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}