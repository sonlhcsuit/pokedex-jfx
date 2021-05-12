package app.components;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Vector;
import java.util.concurrent.CompletableFuture;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SideBar extends VBox {
	@FXML
	private ListView listView;

	public SideBar() {
		FXMLLoader loader = new FXMLLoader();
		loader.setRoot(this);
		loader.setControllerFactory((t) -> this);
		String filename = this.getClass().getSimpleName() + ".fxml";
		try {
			loader.load(this.getClass().getResourceAsStream(filename));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

	public void updateList(Vector<Label> labelList) {
		for (Label label : labelList) {
			listView.getItems().add(label);
		}

	}
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
//
//					while (matches.find()){
//						Label label = new Label();
//						label.setText(matches.group().toUpperCase());
//						label.setOnMouseClicked((MouseEvent e)->{
//							System.out.println(label.getText());
//							System.out.println(e.getSource());
//
//						});
//						listView.getItems().add(label);
//					}
//
//					return null;
//				});
//		thenApplyAsync.join(); // prevents main() from exiting too early
//	}

}
