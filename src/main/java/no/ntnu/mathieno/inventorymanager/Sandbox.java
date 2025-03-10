package no.ntnu.mathieno.inventorymanager;

import no.ntnu.mathieno.inventorymanager.backend.models.Product;
import no.ntnu.mathieno.inventorymanager.backend.filehandling.JsonHandler;

public class Sandbox {

  public static void main(String[] args) {
    JsonHandler jsonHandler = new JsonHandler();

    Product shirt = new Product("Shirt", "Clothes", 2);
    Product pants = new Product("Pants", "Clothes", 1);
    Product phone = new Product("Phone", "Electronics", 10);

    jsonHandler.addProduct(shirt);
    jsonHandler.addProduct(pants);
    jsonHandler.addProduct(phone);

    jsonHandler.deleteProduct(shirt.getProductName());
  }

}
