package Task3.Animals;

class Dog extends Animal {
    private static int dogCount = 0;
    String name;

    public Dog(String name) {
        this.name = name;
        dogCount++;
    }

    public static int countDog() {
        return dogCount;
    }

    @Override
    void run(int length) {
        if (length <= 500) {
            System.out.println("Dog " + name + " run: " + length + " m.");
        } else {
            System.out.println("Dog can't run more 500 m.");
        }
    }

    @Override
    void swim(int length) {
        if (length <= 10) {
            System.out.println("Dog " + name + " swam: " + length + " m.");
        } else {
            System.out.println("Dog can't swim more 10 m.");
        }
    }
}