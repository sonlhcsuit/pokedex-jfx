package pokedex;

import pokedex.components.Detail;
import pokedex.components.SideBar;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.util.Callback;

import java.net.http.*;
import java.net.URI;
import java.util.Vector;
import java.util.concurrent.CompletableFuture;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class App {

	@FXML
	private SideBar side;

	@FXML
	private Detail detail;

	public void initialize() {
		side.updateList(0, 50, this.renderPokemon);
		detail.getNavigator().setRenderPokemon(this.renderPokemon);
		this.renderPokemon.call(1);
	}

	@FXML
	private CompletableFuture<String> loadPokemon(Integer id) {
		HttpClient client = HttpClient.newBuilder().build();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(String.format("https://pokeapi.co/api/v2/pokemon/%s", id)))
				.build();
		return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
				.thenApplyAsync((response) -> {
					int status = response.statusCode();
					if (status != 200) {
						System.err.println("Error: " + response.statusCode());
						return "NOT VALID";
					}
					return response.body();
				});
	}


	private String strip(String regex, String jsonPokemon) {
		Pattern pattern = Pattern.compile(regex, Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
		return pattern.matcher(jsonPokemon).replaceAll("");
	}

	private Vector<String> extractTypes(String jsonPokemon) {
		Vector<String> types = new Vector<>();
		Pattern pattern = Pattern.compile("(?<=\\\"type\\\"\\:\\{\\\"name\\\"\\:\\\").+?(?=\\\")");
		Matcher matcher = pattern.matcher(jsonPokemon);
		while (matcher.find()) {
			types.add(matcher.group());
		}
		return types;

	}

	private String extractName(String jsonPokemon) {
		Pattern pattern = Pattern.compile("(?<=\\\"name\\\"\\:\\\").+?(?=\\\")");
		Matcher matcher = pattern.matcher(jsonPokemon);
		if (matcher.find()) {
			return matcher.group();
		}
		return "";
	}

	private Vector<Integer> extractStats(String jsonPokemon) {
		Vector<Integer> stats = new Vector<>();
		Pattern pattern = Pattern.compile("(?<=\\\"base_stat\\\":)\\d+");
		Matcher matcher = pattern.matcher(jsonPokemon);
		while (matcher.find()) {
			stats.add(Integer.parseInt(matcher.group()));
		}
		return stats;
	}

	private final Callback<Integer, Void> renderPokemon = (Integer pokemonId) -> {
		System.out.printf("Render %d%n", pokemonId);

		try {
			this.loadPokemon(pokemonId)
					.thenApplyAsync((String t) -> {
						Vector<String> regexes = new Vector<>();
						regexes.add("\\{\\\"ability\\\":.+?\\}");
//					strip ability
						regexes.add("\\\"sprites\\\":.+?\\{.+?\\}");
//					strip sprites
						regexes.add("\\,\\\"version_group_details\\\"\\:\\[.+?\\]");
//					strip version group details of moves
						regexes.add("\\\"move\\\":\\{.+?\\}");
//					strip moves
						for (String reg : regexes) {
							t = strip(reg, t);
						}
						return t;
					})
					.thenApplyAsync((String t) -> {
						Vector<Integer> stats = extractStats(t);
						Platform.runLater(() -> {
							this.detail.updateStat(stats);
							this.detail.updateImage(pokemonId);
						});
						return t;
					})
					.thenApplyAsync((String t) -> {
						Platform.runLater(() -> {
							Vector<String> types = extractTypes(t);
							String name = extractName(t);
							this.detail.setPokemonId(pokemonId);
							this.detail.updateTypes(types);
							this.detail.updateName(name);
							System.out.printf("Finish %d - %s%n", pokemonId, name);
						});
						return "";
					})
					.join();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	};
}
