package pokedex;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("App.fxml")));

		String javaVersion = System.getProperty("java.version");
		String javafxVersion = System.getProperty("javafx.version");
		String version_check = String.format("Hello, JavaFX %s, running on Java %s.", javafxVersion, javaVersion);
		System.out.println(version_check);

		setUserAgentStylesheet(STYLESHEET_CASPIAN);
		primaryStage.setTitle("Pokedex");
		primaryStage.setScene(new Scene(root, 1080, 720));
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
