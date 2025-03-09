package no.ntnu.mathieno.inventorymanager.backend.filehandling;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import no.ntnu.mathieno.inventorymanager.backend.models.Product;
import no.ntnu.mathieno.inventorymanager.backend.exceptions.InvalidStringException;

/**
 * Class to handle CRUD operations related to JSON files.
 *
 * @author Mathias Erik Nord
 * @version 0.0.1
 * @since 08.03.2025
 */
public class JsonHandler {

  private static final String FILE_PATH = "src/main/resources/no/ntnu"
      + "/mathieno/inventorymanager/products.json";
  private final Gson gson;
  private List<Product> products;
  private final Logger logger = Logger.getLogger(JsonHandler.class.getName());

  /**
   * Constructor that instantiates gson and products + loading saved inventory from json.
   */
  public JsonHandler() {
    gson = new GsonBuilder().setPrettyPrinting().create();
    this.products = new ArrayList<>();
    loadInventory();
  }

  /**
   * Method that adds a product.
   *
   * @param product product to add.
   */
  public void addProduct(Product product) {
    if (product == null) {
      throw new IllegalArgumentException("Product cannot be null");
    }
    logger.log(Level.INFO, "Adding product.");
    Optional<Product> existingProduct = products.stream()
        .filter(p -> p.getProductName().equalsIgnoreCase(product.getProductName()))
        .findFirst();

    if (existingProduct.isPresent()) {
      logger.log(Level.INFO, "Product is already present.");
      return;
    }
    products.add(product);
    saveInventory();
    logger.log(Level.INFO, "Product was added, and saved to inventory.");
  }

  /**
   * Method that deletes a product.
   *
   * @param name product to delete.
   */
  public void deleteProduct(String name) {
    stringValidator(name);
    boolean removed = products.removeIf(p -> p.getProductName().equalsIgnoreCase(name));
    if (removed) {
      saveInventory();
      logger.log(Level.INFO, "Product was removed.");
    }
  }

  /**
   * Method to update the quantity of a product.
   *
   * @param name        name of the product.
   * @param newQuantity the new quantity of the product.
   * @return true if product is updated, false if not found.
   */
  public boolean updateQuantity(String name, int newQuantity) {
    stringValidator(name);
    for (Product product : products) {
      if (product.getProductName().equalsIgnoreCase(name)) {
        product.setQuantity(newQuantity);
        saveInventory();
        logger.log(Level.INFO, "Quantity was updated");
        return true;
      }
    }
    logger.log(Level.INFO, "Quantity was not updated");
    return false; // Product not found
  }

  /**
   * Method to update the category of a product.
   *
   * @param name        name of product.
   * @param newCategory the new category of product.
   * @return true if updated, else false.
   */
  public boolean updateCategory(String name, String newCategory) {
    stringValidator(name, newCategory);
    for (Product product : products) {
      if (product.getProductName().equalsIgnoreCase(name)) {
        product.setProductCategory(newCategory);
        saveInventory();
        logger.log(Level.INFO, "Category was updated.");
        return true;
      }
    }
    logger.log(Level.INFO, "Category was not updated");
    return false; // Product not found
  }

  /**
   * Method to update the name of a product.
   *
   * @param name    old name of product.
   * @param newName new name of product.
   * @return true if updated, false if not.
   */
  public boolean updateName(String name, String newName) {
    stringValidator(name, newName);
    for (Product product : products) {
      if (product.getProductName().equalsIgnoreCase(name)) {
        product.setProductName(newName);
        saveInventory();
        logger.log(Level.INFO, "Name was updated");
        return true;
      }
    }
    logger.log(Level.INFO, "Name was not updated");
    return false; // Product not found
  }

  /**
   * Method that loads the inventory from JSON file.
   */
  private void loadInventory() {
    logger.log(Level.INFO, "Loading inventory.");
    File file = new File(FILE_PATH);
    if (!file.exists()) {
      logger.log(Level.INFO, "File doesn't exist, initializing new ArrayList.");
      products = new ArrayList<>();
    }

    try (FileReader fileReader = new FileReader(file)) {
      logger.log(Level.INFO, "Loading from JSON file.");
      Type productListType = new TypeToken<ArrayList<Product>>() {
      }.getType();
      products = gson.fromJson(fileReader, productListType);

      if (products == null) {
        logger.log(Level.INFO, "Parsed JSON is null, initializing new ArrayList.");
        products = new ArrayList<>();
      }
    } catch (IOException e) {
      logger.log(Level.SEVERE, "Error when loading file.");
      products = new ArrayList<>();
    }
  }

  /**
   * Method that saves the inventory to the JSON file.
   */
  private void saveInventory() {
    try (FileWriter fileWriter = new FileWriter(FILE_PATH)) {
      gson.toJson(products, fileWriter);
      logger.log(Level.INFO, "Inventory was successfully saved.");
    } catch (IOException e) {
      logger.log(Level.SEVERE, "Error when saving to inventory.");
    }
  }

  /**
   * Method that validates inputted string(s).
   *
   * @param inputStrings provided string(s).
   * @throws InvalidStringException if string is null or blank.
   */
  private void stringValidator(String... inputStrings) {
    if (inputStrings == null) {
      throw new InvalidStringException("String is invalid");
    }
    for (String inputString : inputStrings) {
      if (inputString == null || inputString.trim().isBlank()) {
        throw new InvalidStringException("String is invalid.");
      }
    }
  }
}
