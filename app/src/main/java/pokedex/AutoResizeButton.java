package pokedex;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.transform.Scale;
import java.io.IOException;

public class AutoResizeButton extends VBox {
	@FXML
	Button btn;

	public AutoResizeButton() {
		FXMLLoader loader = new FXMLLoader();
		loader.setRoot(this);
		loader.setControllerFactory((empty) -> this);
		String filename = this.getClass().getSimpleName();
		try {
			loader.load(this.getClass().getResourceAsStream(String.format("%s.fxml", filename)));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

	public void initialize() {
		Scale scaleBig = new Scale();
		scaleBig.setX(3.0);
		scaleBig.setY(3.0);
		scaleBig.setPivotX(0);
		scaleBig.setPivotY(0);
		Scale scaleSmall = new Scale();
		scaleSmall.setX(1.0);
		scaleSmall.setY(1.0);
		scaleSmall.setPivotX(0);
		scaleSmall.setPivotY(0);
		btn.setOnMouseClicked((MouseEvent e) -> {
			System.out.println(btn);
			System.out.println("Button clicked!Change Size");
			if (btn.getTransforms().size() == 0) {
				btn.getTransforms().add(scaleBig);
			} else {
				if (scaleBig.equals(btn.getTransforms().get(0))) {
					btn.getTransforms().set(0, scaleSmall);
				} else if (scaleSmall.equals(btn.getTransforms().get(0))) {
					btn.getTransforms().set(0, scaleBig);
				}
			}
		});
	}
}
