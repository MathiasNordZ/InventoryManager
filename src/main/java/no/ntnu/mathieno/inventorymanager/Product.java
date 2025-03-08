package no.ntnu.mathieno.inventorymanager;

/**
* Class that represents a product stored in the inventory.
*
* @author Mathias Erik Nord
* @since 08.03.2025
* @version 0.0.1
*/
public class Product {
  private String productName;
  private String productCategory;
  private int quantity;

  /**
   * Constructor that will set the product name, category and quantity.
   *
   * @param productName name of the product.
   * @param productCategory category of the product.
   * @param quantity quantity of the product.
   */
  public Product(String productName, String productCategory, int quantity) {
    setProductName(productName);
    setProductCategory(productCategory);
    setQuantity(quantity);
  }

  /**
   * Accessor method for {@code productName}.
   *
   * @return the product name.
   */
  public String getProductName() {
    return productName;
  }

  /**
   * Mutator method for {@code productName}
   *
   * @param productName the product name.
   */
  public void setProductName(String productName) {
    if (productName == null || productName.isBlank()) {
      throw new IllegalArgumentException("Product name cannot be null/blank.");
    }
    this.productName = productName;
  }

  /**
   * Accessor method for {@code productCategory}.
   *
   * @return the product category.
   */
  public String getProductCategory() {
    return productCategory;
  }

  /**
   * Mutator method for {@code productCategory}.
   *
   * @param productCategory the product category.
   */
  public void setProductCategory(String productCategory) {
    if (productName == null || productName.isBlank()) {
      throw new IllegalArgumentException("Product category cannot be null/blank.");
    }
    this.productCategory = productCategory;
  }

  /**
   * Accessor method for {@code quantity}.
   *
   * @return the quantity.
   */
  public int getQuantity() {
    return quantity;
  }

  /**
   * Mutator method for {@code quantity}.
   *
   * @param quantity the quantity.
   */
  public void setQuantity(int quantity) {
    if (quantity <= 0) {
      throw new IllegalArgumentException("Quantity cannot be less than or equal zero.");
    }
    this.quantity = quantity;
  }
}
