module pokedex {
	requires javafx.fxml;
	requires javafx.controls;
	requires javafx.graphics;

//	exports sample.resources;
	opens app;
//	opens app.components.Card;
	opens app.components.Search;
	opens app.resources;

	exports app;
//	exports app.components.Card;
	exports app.components.Search;
}
