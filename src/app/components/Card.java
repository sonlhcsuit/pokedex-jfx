package app.components;

import java.io.IOException;
import java.util.Locale;

import javafx.beans.DefaultProperty;
import javafx.beans.NamedArg;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.Parent;


@DefaultProperty(value = "children")
public class Card extends VBox {
	@FXML
	private ImageView img;
	@FXML
	private Label pokemonName;
	@FXML
	private HBox pokemonType;

	private String imgUrl;

	public Card(@NamedArg("name") String name, @NamedArg("types") String types) {
		loadFXML(this);
		pokemonName.setText(name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase());
		insertTypes(types);
//		img.setOnMouseClicked(t -> {
//			bug();
//		});
	}

	// custom property

	public void setImgUrl(String url) {
		this.imgUrl = url;
		img.setImage(new Image(url));
	}

	public String getImgUrl() {
		return this.imgUrl;
	}

	private void insertTypes(String types) {
		String[] typeList = types.split(";");
		Label a = createType(typeList[0].toUpperCase());
		a.getStyleClass().add("pokemon-type");
		a.getStyleClass().add(typeList[0]);
		pokemonType.getChildren().add(a);
		HBox.setHgrow(a, Priority.ALWAYS);
		if (typeList.length == 2) {
			a = createType(typeList[1].toUpperCase());
			pokemonType.getChildren().add(a);
			a.getStyleClass().add("pokemon-type");
			a.getStyleClass().add(typeList[1]);
		}
	}

	private Label createType(String type) {
		Label label = new Label();
		label.setText(type);
		return label;
	}

	@FXML
	protected void bug() {
		String newImageString = String.format("https://assets.pokemon.com/assets/cms2/img/pokedex/full/%03d.png", (int) Math.ceil(Math.random() * 800));
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