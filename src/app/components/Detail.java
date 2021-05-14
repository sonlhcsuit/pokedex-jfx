package app.components;

import javafx.beans.NamedArg;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.Collections;
import java.util.Vector;


public class Detail extends BorderPane {
	@FXML
	private VBox cont;
	@FXML
	private HBox types;
	@FXML
	private Label name;
	@FXML
	private Label number;
	@FXML
	private ImageView image;
	@FXML
	private Navigator navigator;

	private Integer pokemonId;

	public Detail(@NamedArg("name") String name, @NamedArg("number") int number,
				  @NamedArg("image") String image, @NamedArg("types") String types,
				  @NamedArg("stats") String stats) {
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

		String[] types_arr = types.split(";");
		Vector<String> types_vec = new Vector<>();
		Collections.addAll(types_vec, types_arr);
		updateTypes(types_vec);

		String[] stat_arr = stats.split(";");
		Vector<Integer> stat_vec = new Vector<>();
		for (String stat : stat_arr) {
			stat_vec.add(Integer.parseInt(stat));
		}
		updateStat(stat_vec);
	}

	public void updateStat(Vector<Integer> stats) {
		String[] stat_names = {"hp", "attack", "defense", "sp.atk", "sp.def", "speed"};
		for (int i = 0; i < stat_names.length; i++) {
			Stat stat = new Stat(stat_names[i], stats.get(i), 150);
			if (i == 0) {
				VBox.setMargin(stat, new Insets(30, 0, 10, 0));
			}
			if (i == 5) {
				VBox.setMargin(stat, new Insets(10, 0, 20, 0));
			}
			if (i != 0 && i != 5) {
				VBox.setMargin(stat, new Insets(10, 0, 10, 0));
			}
			try {
				this.cont.getChildren().set(i + 1, stat);
			} catch (Exception e) {
				this.cont.getChildren().add(i + 1, stat);
			}
		}

	}

	public void updateImage(Integer id) {
		Image image = new Image(String.format("https://assets.pokemon.com/assets/cms2/img/pokedex/full/%03d.png", id));
		this.image.setImage(image);
		this.setPokemonId(id);
		this.number.setText(String.format("%03d", id));

	}

	public void updateName(String name) {
		this.name.setText(name.toUpperCase());
	}


	private Label createType(String type) {
		Label label = new Label();
		label.setText(type.toUpperCase());
		label.setMinWidth(100);
		Insets margin = new Insets(0, 15, 0, 15);
		HBox.setMargin(label, margin);
		label.getStyleClass().add("pokemon-type");
		label.getStyleClass().add(type);
		label.setAlignment(Pos.CENTER);
		return label;
	}

	public void updateTypes(Vector<String> types) {
		int l = 2;
		if (types.size() < l) {
			l = types.size();
		}
		this.types.getChildren().clear();
		for (int i = 0; i < l; i++) {
			this.types.getChildren().add(createType(types.get(i)));
		}
	}

	public void setPokemonId(Integer pokemonId) {
		this.pokemonId = pokemonId;
		this.navigator.setPokemonId(this.pokemonId);
	}

	public Integer getPokemonId() {
		return pokemonId;
	}

	public Navigator getNavigator() {
		return navigator;
	}

	public void setNavigator(Navigator navigator) {
		this.navigator = navigator;
	}

}
