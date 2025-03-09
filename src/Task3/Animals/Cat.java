package Task3.Animals;

class Cat extends Animal {
    private static int catCount = 0;
    String name;
    boolean isSatiety = false;

    public Cat(String name, boolean isSatiety) {
        this.name = name;
        this.isSatiety = isSatiety;
        catCount++;
    }

    public static int countCat() {
        return catCount;
    }

    @Override
    void run(int length) {
        if (length <= 200) {
            System.out.println("Cat " + name + " run: " + length + " m.");
        } else {
            System.out.println("Cat can't run more 200 m.");
        }
    }

    @Override
    void swim(int length) {
        System.out.println("Cat can't swim");
    }

    void eat(int bowl, int portion) {
        //System.out.println("In the bowl (before eating): " + bowl);
        if (portion <= bowl) {
            bowl = bowl - portion;
            isSatiety = true;
            //System.out.println("Cat " + name + " ate a portion");
        } else {
            //System.out.println("Not enough food in the bowl for cat " + name);
            isSatiety = false;
        }
        //System.out.println("The rest in the bowl: " + bowl);
    }

    void printSatietyInfo() {
        if (isSatiety) {
            System.out.println("Cat " + name + " is full");
        } else {
            System.out.println("Cat " + name + " is hungry");
        }
    }
}
