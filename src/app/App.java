package app;

import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class App {

	@FXML
	private ListView listview;


	public void click(MouseEvent e) {
		ObservableList selectedIndices = listview.getSelectionModel().getSelectedIndices();

		for (Object o : selectedIndices) {
			System.out.println("o = " + o + " (" + o.getClass() + ")");
		}
		System.out.printf(e.getSource().toString(), "Clicked"
		);
	}

}
