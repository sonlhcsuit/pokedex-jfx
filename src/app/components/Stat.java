package app.components;

import javafx.beans.NamedArg;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;

import java.io.IOException;


public class Stat extends HBox {
	@FXML
	private Label labelType;
	@FXML
	private Label labelValue;
	@FXML
	private ProgressBar progress;

	public Stat(@NamedArg("type") String type,
				@NamedArg("value") int value,
				@NamedArg(value = "maxvalue", defaultValue = "150") int maxvalue) {
		FXMLLoader loader = new FXMLLoader();
		loader.setRoot(this);
		loader.setControllerFactory((empty) -> this);
		String filename = this.getClass().getSimpleName();
		try {
			loader.load(this.getClass().getResourceAsStream(String.format("%s.fxml", filename)));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		this.labelType.setText(type.toUpperCase());
		this.labelValue.setText(String.format("%d", value));
		this.progress.setProgress((double) value / maxvalue);
	}
}
