package Task2;

public class Product {
    private final String productName;
    private final String dateProduce;
    private final String producer;
    private final String produceCountry;
    private final int price;
    private final Boolean bookingState;

    public Product(String productName, String dateProduce, String producer, String produceCountry, int price, Boolean bookingState) {
        this.productName = productName;
        this.dateProduce = dateProduce;
        this.producer = producer;
        this.produceCountry = produceCountry;
        this.price = price;
        this.bookingState = bookingState;
    }

    public static void printProductInfo(Product products) {
        System.out.println(products);
    }

    public String toString() {
        return "goodName: " + productName + "; dateProduce: " + dateProduce + "; producer: " + producer + "; produceCountry: " + produceCountry
                + "; price: " + price + "; bookingState: " + bookingState;
    }

    public static void main(String[] args) {
        Product[] productsArray = new Product[5];
        productsArray[0] = new Product("Good1", "28.02.2025", "Kravchenko G.", "Belarus", 25, true);
        productsArray[1] = new Product("Good2", "28.02.2025", "Kravchenko G.", "Belarus", 50, true);
        productsArray[2] = new Product("Good3", "28.02.2025", "Kravchenko G.", "Belarus", 75, true);
        productsArray[3] = new Product("Good4", "03.03.2025", "Kravchenko G.", "Belarus", 100, true);
        productsArray[4] = new Product("Good5", "03.03.2025", "Kravchenko G.", "Belarus", 125, true);

        for (Product products : productsArray) {
            printProductInfo(products);
        }
    }

}