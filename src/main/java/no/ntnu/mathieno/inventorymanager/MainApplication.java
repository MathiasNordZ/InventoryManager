package no.ntnu.mathieno.inventorymanager;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApplication extends javafx.application.Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/no/ntnu/mathieno/inventorymanager/product-overview.fxml"));
    Scene scene = new Scene(loader.load());
    primaryStage.setScene(scene);
    primaryStage.setTitle("Inventory Manager");
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
