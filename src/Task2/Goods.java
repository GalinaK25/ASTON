package Task2;

public class Goods {
    private final String goodName;
    private final String dateProduce;
    private final String producer;
    private final String produceCountry;
    private final int price;//тип указан как в примере к заданию
    private final Boolean bookingState;

    public Goods(String goodName, String dateProduce, String producer, String produceCountry, int price, Boolean bookingState) {
        this.goodName = goodName;
        this.dateProduce = dateProduce;
        this.producer = producer;
        this.produceCountry = produceCountry;
        this.price = price;
        this.bookingState = bookingState;
    }

    public void printGoodsInfoWithoutToString() {
        System.out.println("goodName: " + goodName + "; dateProduce: " + dateProduce + "; producer: " + producer + "; produceCountry: " + produceCountry
                + "; price: " + price + "; bookingState: " + bookingState);
    }

    public static void main(String[] args) {

        Goods[] goodsArray = new Goods[5];

        goodsArray[0] = new Goods("Good1", "28.02.2025", "Kravchenko G.", "Belarus", 25, true);
        goodsArray[1] = new Goods("Good2", "28.02.2025", "Kravchenko G.", "Belarus", 50, true);
        goodsArray[2] = new Goods("Good3", "28.02.2025", "Kravchenko G.", "Belarus", 75, true);
        goodsArray[3] = new Goods("Good4", "03.03.2025", "Kravchenko G.", "Belarus", 100, true);
        goodsArray[4] = new Goods("Good5", "03.03.2025", "Kravchenko G.", "Belarus", 125, true);

        /*for (int i=0; i<goodsArray.length; i++) {
            goodsArray[i].printGoodsInfoWithoutToString();
        }*/

        for (Goods goods : goodsArray) {        //замена на enhanced 'for' предложена IDEA
            goods.printGoodsInfoWithoutToString();
        }

    }

}
