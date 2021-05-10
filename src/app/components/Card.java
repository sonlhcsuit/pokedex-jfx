package app.components;
import java.io.IOException;

import javafx.beans.DefaultProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.Parent;


@DefaultProperty(value = "children")
public class Card extends VBox {
	@FXML
	private Label textField;
	@FXML
	private ImageView img;

	private String imgUrl;

	public Card() {
		loadFXML(this);
		img.setOnMouseClicked((MouseEvent e)->{
			bug();
		});
	}

	public void setImgUrl(String url){
		this.imgUrl = url;
		img.setImage(new Image(url));
	}
	public String getImgUrl(){
		return this.imgUrl;
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
		setImgUrl(newImageString);
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