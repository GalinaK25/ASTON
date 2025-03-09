package Task3.Animals;

public class AnimalApp {
    static int portion = 15;
    static int bowl = 5;

    public static void main(String[] args) {
        Dog dogA = new Dog("DogAAA");
        Dog dogB = new Dog("DogBBB");
        Cat catA = new Cat("CatAAA", false);
        Cat catB = new Cat("CatBBB", false);

        System.out.println("Animals: " + Animal.countAnimal());
        System.out.println("Dogs: " + Dog.countDog());
        System.out.println("Cats: " + Cat.countCat());

        dogA.run(501);
        dogB.run(300);
        dogA.swim(5);
        catA.run(201);
        catB.run(150);
        catA.swim(1);

        Cat[] cats = new Cat[3];
        cats[0] = new Cat("Cat111", false);
        cats[1] = new Cat("Cat222", false);
        cats[2] = new Cat("Cat333", false);

        if (bowl < 0) {
            System.out.println("The bowl can't be < 0");
            return;
        }

        if (portion > bowl) {
            System.out.println("Check the bowl (fill it)");
            addToBowl(30);
        }

        for (Cat cat : cats) {
            cat.eat(bowl, portion);
            bowl = bowl - portion;
            cat.printSatietyInfo();
        }
    }

    private static void addToBowl(int num) {
        bowl = bowl + num;
    }

}

