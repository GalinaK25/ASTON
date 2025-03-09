package Task3.Animals;

public class Animal {
    private static int count = 0;

    public Animal() {
        count++;
    }

    public static int countAnimal() {
        return count;
    }

    void run(int length) {
    }

    void swim(int length) {
    }

}
