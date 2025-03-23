package Task2;

public class Park {

    private final String namePark;

    public Park(String namePark) {
        this.namePark = namePark;
    }

    public String getNamePark() {
        return namePark;
    }

    public static class Attraction {
        private final String name;
        private final String workHours;
        private final double price;
        private final Park namePark;

        public Attraction(String name, String workHours, double price, Park namePark) {
            this.name = name;
            this.workHours = workHours;
            this.price = price;
            this.namePark = namePark;
        }

        public void printAttractionInfo(Attraction attractions) {
            System.out.println(attractions);
        }

        public String toString() {
            return name + "; workHours: " + workHours + "; price: " + price + " ; park: " + namePark.getNamePark();
        }
    }

    public static void main(String[] args) {
        Park park = new Park("Aston");
        Attraction[] attractionsArray = new Attraction[5];
        attractionsArray[0] = new Attraction("Attraction One", "10:00-22:00", 25.25, park);
        attractionsArray[1] = new Attraction("Attraction Two", "12:00-20:00", 50.50, park);
        attractionsArray[2] = new Attraction("Attraction Three", "12:00-22:00", 75.75, park);
        attractionsArray[3] = new Attraction("Attraction Four", "12:00-20:00", 50.50, park);
        attractionsArray[4] = new Attraction("Attraction Five", "10:00-22:00", 25.25, park);

        for (Attraction attractions : attractionsArray) {
            attractions.printAttractionInfo(attractions);
        }
    }
}
