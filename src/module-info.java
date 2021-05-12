module pokedex {
	requires javafx.fxml;
	requires javafx.controls;
	requires javafx.graphics;
	requires java.net.http;

	opens app;
	opens app.resources;
	opens app.components;

	exports app;
	exports app.components;
//	exports app.resources;
}
