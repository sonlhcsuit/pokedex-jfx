package app;

import app.components.Card;
import app.components.SideBar;
import javafx.fxml.FXML;

import javafx.scene.control.Label;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;

import java.net.http.*;
import java.net.URI;
import java.util.Vector;
import java.util.concurrent.CompletableFuture;
import java.util.regex.*;

public class App {

	@FXML
	private SideBar side;
	@FXML
	private FlowPane cardCont;


	public void initialize() {
		pokemonList(0, 30);
	}

	public void createCard(String name) {
		HttpClient client = HttpClient.newBuilder().build();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(String.format("https://pokeapi.co/api/v2/pokemon/%s", name)))
				.build();
		CompletableFuture<String> result = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
				.thenApplyAsync((response) -> {
					int status = response.statusCode();
					if (status != 200) {
						System.err.println("Error: " + response.statusCode());
						return "NOT VALID";
					}
					return response.body();
				})
				.thenApplyAsync((body) -> {
//					System.out.println(body); 
					Pattern pattern = Pattern.compile("(?<=\\\"id\\\":)\\'?.+?\\\"?(?=,)", Pattern.DOTALL);
					Matcher matcher = pattern.matcher(body);
					String id = "";
					if (matcher.find()) {
						id = matcher.group();
					}


					pattern = Pattern.compile("(?<=\\\"types\\\":\\[).+?(?=\\])", Pattern.DOTALL);
					matcher = pattern.matcher(body);
					matcher.find();
					String typeGroup = matcher.group();

					pattern = Pattern.compile("(?<=\\\"name\\\":\\\").+?(?=\\\")", Pattern.DOTALL);
					matcher = pattern.matcher(typeGroup);
					matcher.find();
					String types = matcher.group();
					matcher.find();
					if ("".equals(matcher.group())) {
						types = types + ";" + matcher.group();
					}
					Card card = new Card(name, types, String.format("https://assets.pokemon.com/assets/cms2/img/pokedex/full/%03d.png", Integer.parseInt(id) ));
					System.out.println(card);
					cardCont.getChildren().add(card);
					return "";
				});


	}

	public void pokemonList(int from, int amount) {
		HttpClient client = HttpClient.newBuilder().build();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(String.format("https://pokeapi.co/api/v2/pokemon?limit=%d&offset=%d", amount, from)))
				.build();
		CompletableFuture<String> thenApplyAsync = client
				.sendAsync(request, HttpResponse.BodyHandlers.ofString())
				.thenApplyAsync((resp) -> {
					int status = resp.statusCode();
					if (status != 200) {
						System.err.println("Error: " + resp.statusCode());
						return "NOT VALID";
					}
					return resp.body();
				}).thenApplyAsync((body) -> {
					Pattern pattern = Pattern.compile("(?<=\\\"name\\\":\\\").*?(?=\\\")", Pattern.DOTALL);
					Matcher matches = pattern.matcher(body);
					Vector<Label> v = new Vector<>();
					int i = 0;
					while (matches.find()) {
						var name = matches.group();
						Label label = new Label();
						label.setText(name.toUpperCase());
						label.setOnMouseClicked((MouseEvent e) -> {
							System.out.println(label.getText());
						});
						v.add(label);
						if (i == 0) {
							createCard(name);
							i++;
						}
					}
//					System.out.println(v);
					side.updateList(v);
					return null;
				});
		thenApplyAsync.join(); // prevents main() from exiting too early
	}


}
