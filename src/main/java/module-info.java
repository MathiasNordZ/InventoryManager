module no.ntnu.mathieno.inventorymanager {
  requires javafx.controls;
  requires javafx.fxml;
  requires com.google.gson;
  requires java.logging;

  opens no.ntnu.mathieno.inventorymanager to javafx.fxml, com.google.gson;
  exports no.ntnu.mathieno.inventorymanager;
}