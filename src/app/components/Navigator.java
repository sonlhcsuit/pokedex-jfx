package app.components;

import javafx.beans.NamedArg;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.util.Callback;

import java.io.IOException;

public class Navigator extends HBox {
	@FXML
	private Button next;
	@FXML
	private Button previous;
	private Callback<Integer, Void> renderPokemon;
	private int pokemonId;

	public Navigator(@NamedArg("pokemonId") int pokemonId) {
		FXMLLoader loader = new FXMLLoader();
		loader.setRoot(this);
		loader.setControllerFactory((empty) -> this);
		String filename = this.getClass().getSimpleName();
		try {
			loader.load(this.getClass().getResourceAsStream(String.format("%s.fxml", filename)));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		this.pokemonId = pokemonId;
	}

	public void setPokemonId(int pokemonId) {
		this.pokemonId = pokemonId;
	}

	public int getPokemonId() {
		return pokemonId;
	}

	public void setRenderPokemon(Callback<Integer, Void> renderPokemon) {
		this.renderPokemon = renderPokemon;
	}

	public Callback<Integer, Void> getRenderPokemon() {
		return this.renderPokemon;
	}

	@FXML
	public void trigger(MouseEvent e) {
		if (next.equals(e.getSource())) {
//			this.setPokemonId(this.pokemonId + 1);

			this.renderPokemon.call(this.pokemonId + 1);
		}
		if (previous.equals(e.getSource())) {
//			this.setPokemonId(this.pokemonId - 1);
			this.renderPokemon.call(this.pokemonId - 1);
		}

	}

}
