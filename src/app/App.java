package app;

import app.components.Card;
import app.components.Detail;
import app.components.SideBar;
import javafx.fxml.FXML;

import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.util.Callback;

import java.net.http.*;
import java.net.URI;
import java.util.Vector;
import java.util.concurrent.CompletableFuture;


public class App {

	@FXML
	private SideBar side;
	@FXML
	private FlowPane cardCont;

	@FXML
	private HBox cont;
	@FXML
	private Vector<Card> cards;

	@FXML
	private Detail detail;

	public void initialize() {
		side.updateList(0, 4, this.renderPokemon);
		detail.getNavigator().setRenderPokemon(this.renderPokemon);
		detail.getNavigator();
	}

	@FXML
	private Callback<Integer, String> loadPokemon = (Integer id) -> {
		System.out.println(id);
//		renderPokemon(String.format("%d", id));
		return "";
//		HttpClient client = HttpClient.newBuilder().build();
//		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(String.format("https://pokeapi.co/api/v2/pokemon/%s", name)))
//				.build();
//
//		CompletableFuture<String> result = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
//				.thenApplyAsync((response) -> {
//					int status = response.statusCode();
//					if (status != 200) {
//						System.err.println("Error: " + response.statusCode());
//						return "NOT VALID";
//					}
//					return response.body();
//				});
//		return result.join();
	};

	private final Callback<Integer, Void> renderPokemon = (Integer pokemonId) -> {
		System.out.println(String.format("render %d", pokemonId));
		this.detail.setPokemonId(pokemonId);
		return null;
	};
//
//	public void createCard(String name) {
//		HttpClient client = HttpClient.newBuilder().build();
//		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(String.format("https://pokeapi.co/api/v2/pokemon/%s", name)))
//				.build();
//
//		CompletableFuture<String> result = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
//				.thenApplyAsync((response) -> {
//					int status = response.statusCode();
//					if (status != 200) {
//						System.err.println("Error: " + response.statusCode());
//						return "NOT VALID";
//					}
//					return response.body();
//				})
//				.thenApplyAsync((body) -> {
//					Pattern pattern = Pattern.compile("(?<=\\\"id\\\":)\\'?.+?\\\"?(?=,)", Pattern.DOTALL);
//					Matcher matcher = pattern.matcher(body);
//					String id = "";
//					if (matcher.find()) {
//						id = matcher.group();
//					}
//
//					pattern = Pattern.compile("(?<=\\\"types\\\":\\[).+?(?=\\])", Pattern.DOTALL);
//					matcher = pattern.matcher(body);
//					matcher.find();
//					String typeGroup = matcher.group();
//
//					pattern = Pattern.compile("(?<=\\\"name\\\":\\\").+?(?=\\\")", Pattern.DOTALL);
//					matcher = pattern.matcher(typeGroup);
//					matcher.find();
//					String types = matcher.group();
//					try {
//						matcher.find();
//						types = types + ";" + matcher.group();
//					} catch (IllegalStateException e) {
//						System.out.println(e.getMessage());
//					} finally {
////						Only 1 type
//						Card card = new Card(name, types, String.format("https://assets.pokemon.com/assets/cms2/img/pokedex/full/%03d.png", Integer.parseInt(id)));
////						this.cardCont.getChildren().add(card);
//						return "";
//					}
//
//				});
//		result.join();
//
//	}
//
//	public void updateView() {
//		System.out.println(this.cards);
//	}
//
//	public void pokemonList(int from, int amount) {
//		HttpClient client = HttpClient.newBuilder().build();
//		HttpRequest request = HttpRequest.newBuilder()
//				.uri(URI.create(String.format("https://pokeapi.co/api/v2/pokemon?limit=%d&offset=%d", amount, from)))
//				.build();
//		CompletableFuture<String> thenApplyAsync = client
//				.sendAsync(request, HttpResponse.BodyHandlers.ofString())
//				.thenApplyAsync((resp) -> {
//					int status = resp.statusCode();
//					if (status != 200) {
//						System.err.println("Error: " + resp.statusCode());
//						return "NOT VALID";
//					}
//					return resp.body();
//				}).thenApplyAsync((body) -> {
//					Pattern pattern = Pattern.compile("(?<=\\\"name\\\":\\\").*?(?=\\\")", Pattern.DOTALL);
//					Matcher matches = pattern.matcher(body);
//					Vector<Label> v = new Vector<>();
//					Vector<String> names = new Vector<>();
//					int i = 0;
//					while (matches.find()) {
//						var name = matches.group();
//						Label label = new Label();
//						label.setText(name.toUpperCase());
//						label.setOnMouseClicked((MouseEvent e) -> {
//							System.out.println(label.getText());
//						});
//						v.add(label);
//						try {
////							createCard(name);
//						} catch (Exception e) {
//							System.out.println(name);
//							System.out.println(e.getMessage());
//						}
//						names.add(name);
//					}
//					side.updateList(v);
//					return null;
//				});
//		String data = thenApplyAsync.join(); // prevents main() from exiting too early
////		System.out.println(data);
//	}
//

}
