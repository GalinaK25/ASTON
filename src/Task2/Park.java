package Task2;

public class Park {

    public static class Attraction {
        private final String name;
        private final String workHours;
        private final double price;

        public Attraction(String name, String workHours, double price) {
            this.name = name;
            this.workHours = workHours;
            this.price = price;
        }

        public void printAttractionInfo() {
            System.out.println("name: " + name + "; workHours: " + workHours + "; price: " + price);
        }

    }

    public static void main(String[] args) {

        Attraction[] attractionsArray = new Attraction[5];

        attractionsArray[0] = new Attraction("Attraction One", "10:00-22:00", 25.25);
        attractionsArray[1] = new Attraction("Attraction Two", "12:00-20:00", 50.50);
        attractionsArray[2] = new Attraction("Attraction Three", "12:00-22:00", 75.75);
        attractionsArray[3] = new Attraction("Attraction Four", "12:00-20:00", 50.50);
        attractionsArray[4] = new Attraction("Attraction Five", "10:00-22:00", 25.25);

        for (Attraction attractions : attractionsArray) {
            attractions.printAttractionInfo();
        }

    }
}