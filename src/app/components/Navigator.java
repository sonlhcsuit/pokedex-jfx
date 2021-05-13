package app.components;

import javafx.beans.NamedArg;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.util.function.Function;

public class Navigator extends HBox {
	@FXML
	private Button next;
	@FXML
	private Button previous;
	private int pokemonId;
	private Function<String, String> loadPokemon;

	public Navigator(@NamedArg("id") int id) {
		FXMLLoader loader = new FXMLLoader();
		loader.setRoot(this);
		loader.setControllerFactory((empty) -> this);
		String filename = this.getClass().getSimpleName();
		try {
			loader.load(this.getClass().getResourceAsStream(String.format("%s.fxml", filename)));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		this.pokemonId = id;

	}

	public void setLoadPokemon(Function<String, String> loadPokemon) {
		this.loadPokemon = loadPokemon;
	}

	public Function<String, String> getLoadPokemon() {
		return loadPokemon;
	}

	public void setPokemonId(int pokemonId) {
		this.pokemonId = pokemonId;
	}

	public int getPokemonId() {
		return pokemonId;
	}

	@FXML

	public void next(MouseEvent e) {
		this.loadPokemon.apply("asgdas");
//		loadPokemon("a");

	}


//	@FXML
//	public void loadPokemon(MouseEvent e) {
//		if (this.next.equals(e.getSource())) {
//			System.out.println("Next");
//		}
//		if (this.previous.equals(e.getSource())) {
//			System.out.println("Previous");
//		}
//
//	}
}
