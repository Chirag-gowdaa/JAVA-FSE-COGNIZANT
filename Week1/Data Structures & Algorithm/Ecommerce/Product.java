package Ecommerce;
import java.util.Locale.Category;

public class Product {
    private int productid;
    private String productName;
    private String category;

    public Product(int productId, String productName, String category){
        this.productid = productId;
        this.productName = productName;
        this.category = category;
    }
    public int getProductId(){
        return productid;
    }
    public String getProductName(){
        return productName;
    }
    public String getProductCategory(){
        return category;
    }
    @Override
    public String toString() {
        return "Product ID: " + productid +
                ", Name: " + productName +
                ", Category: " + category;
    }
}
