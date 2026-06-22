package Ecommerce;

public class Search {
    public static Product linearsearch(Product[] products, String targetName){
        for (Product product : products) {

            if (product.getProductName().equalsIgnoreCase(targetName)) {
                return product;
            }
        }

        return null;
    }
    public static Product binarysearch(Product[] products, String targetName) {

        int low = 0;
        int high = products.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int comparison =
                    products[mid].getProductName()
                            .compareToIgnoreCase(targetName); //compares to target name and if match founnd returns 0 orlese returns other integer 

            if (comparison == 0) {
                return products[mid];
            }

            if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return null;
    }
}
