module no.ntnu.mathieno.inventorymanager {
  requires javafx.controls;
  requires javafx.fxml;
  requires com.google.gson;
  requires java.logging;

  opens no.ntnu.mathieno.inventorymanager to javafx.fxml, com.google.gson;
  exports no.ntnu.mathieno.inventorymanager;
  exports no.ntnu.mathieno.inventorymanager.backend.exceptions;
  opens no.ntnu.mathieno.inventorymanager.backend.exceptions to com.google.gson, javafx.fxml;
  exports no.ntnu.mathieno.inventorymanager.backend.models;
  opens no.ntnu.mathieno.inventorymanager.backend.models to com.google.gson, javafx.fxml;
  exports no.ntnu.mathieno.inventorymanager.backend.filehandling;
  opens no.ntnu.mathieno.inventorymanager.backend.filehandling to com.google.gson, javafx.fxml;
}