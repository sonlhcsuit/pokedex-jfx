module pokedex {
	requires javafx.fxml;
	requires javafx.controls;
	requires javafx.graphics;
	exports sample.components;
//	exports sample.resources;
	opens sample;
	opens sample.components;
}
