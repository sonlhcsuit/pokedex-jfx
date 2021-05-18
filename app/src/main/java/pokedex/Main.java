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
		launch();
	}

}

//import pokedex.list.LinkedList;
//
//import static pokedex.utilities.StringUtils.join;
//import static pokedex.utilities.StringUtils.split;
//import static pokedex.MessageUtils.getMessage;
//
//import org.apache.commons.text.WordUtils;
//
//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.scene.control.Label;
//import javafx.scene.layout.StackPane;
//import javafx.stage.Stage;
//
////public class HelloFX extends Application {
////
////    @Override
////    public void start(Stage stage) {
////        String javaVersion = System.getProperty("java.version");
////        String javafxVersion = System.getProperty("javafx.version");
////        Label l = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
////        Scene scene = new Scene(new StackPane(l), 640, 480);
////        stage.setScene(scene);
////        stage.show();
////    }
////
////    public static void main(String[] args) {
////        launch();
////    }
////
////}
//
//public class Main extends App{
//
//    public static void main(String[] args) {
//        LinkedList tokens;
//        tokens = split(getMessage());
//        String result = join(tokens);
//        System.out.println(WordUtils.capitalize(result));
//    }
//}
