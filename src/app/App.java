package app;

import app.components.Card;
import app.components.SideBar;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;

import java.io.IOException;
import java.lang.invoke.LambdaConversionException;
import java.net.http.*;
import java.net.URI;
import java.util.Vector;
import java.util.concurrent.CompletableFuture;
import java.util.regex.*;

public class App {

	@FXML
	private SideBar side;
	@FXML
	private FlowPane cardCont ;

	public App() {
		System.out.println(this);
	}

	public void initialize() {
		pokemonList(0, 30);
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
					while (matches.find()) {
						Label label = new Label();
						label.setText(matches.group().toUpperCase());
						label.setOnMouseClicked((MouseEvent e) -> {
							System.out.println(label.getText());
						});
						v.add(label);
					}
//					System.out.println(v);
					side.updateList(v);
					return null;
				});
		thenApplyAsync.join(); // prevents main() from exiting too early
	}

}
