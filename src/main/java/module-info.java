module no.ntnu.mathieno.inventorymanager {
  requires javafx.controls;
  requires javafx.fxml;

  opens no.ntnu.mathieno.inventorymanager to javafx.fxml;
  exports no.ntnu.mathieno.inventorymanager;
}