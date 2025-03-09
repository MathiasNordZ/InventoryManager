package no.ntnu.mathieno.inventorymanager.backend.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import no.ntnu.mathieno.inventorymanager.backend.filehandling.JsonHandler;
import no.ntnu.mathieno.inventorymanager.backend.models.Product;

public class ProductOverviewController {
  @FXML
  private Button addButton;
  @FXML
  private Button removeButton;
  @FXML
  private TextField nameField;
  @FXML
  private TextField categoryField;
  @FXML
  private Spinner<Integer> quantityField;

  private JsonHandler jsonHandler;

  public ProductOverviewController() {
    jsonHandler = new JsonHandler();
  }

  @FXML
  private void addButtonHandler() {
    addButton.setOnAction(event -> {
      Product product = new Product(nameField.getText(), categoryField.getText(), quantityField.getValue());

      jsonHandler.addProduct(product);
    });
  }

  @FXML
  private void init() {
    SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, Integer.MAX_VALUE, 1);
    quantityField.setValueFactory(valueFactory);
  }
}
