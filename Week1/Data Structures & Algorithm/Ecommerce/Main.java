package Ecommerce;

import java.util.*;
public class Main {
    public static void main(String args[]){
        Product[] products = {

                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Shoes", "Fashion"),
                new Product(103, "Watch", "Accessories"),
                new Product(104, "Phone", "Electronics"),
                new Product(105, "Camera", "Electronics")
        }; //these are the items present.
        Scanner sc = new Scanner(System.in);
        String inp = sc.nextLine();
        Product linearres = Search.linearsearch(products, inp); //they type is Product class cause we arent just displaying product name or number but whole object of the product.
        System.out.println("This is Linear Search Results: ");
        if (linearres != null) {
            System.out.println("Product Found:");
            System.out.println(linearres);
        } else {
            System.out.println("Product Not Found");
        }

        Arrays.sort(products,
                Comparator.comparing(Product::getProductName));

        System.out.println("This is Binary Search Results: ");
        Product binaryResult =
                Search.binarysearch(products, inp);

        if (binaryResult != null) {
            System.out.println("Product Found:");
            System.out.println(binaryResult);
        } else {
            System.out.println("Product Not Found");
        }

    }
}
