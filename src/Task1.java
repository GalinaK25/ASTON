//import java.util.Arrays;

public class Task1 {

    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        checkSum(5, 7);
        checkNumberPrint(10);
        checkNumber(10);
        printString("Galina K.", 3);
        checkYear(100);
        reverseArray();
        fillArray();
        changeArray();
        fillSquareArray();//править
        initArray(5, 7);
    }

    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign() {
        int a = 25;
        int b = 5;
        int sum = a + b;

        if (sum < 0) {
            System.out.println("Сумма отрицательная");
        } else {
            System.out.println("Сумма положительная");
        }

    }

    public static void printColor() {
        int value = 25;

        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        int a = 25;
        int b = 5;

        if (a < b) {
            System.out.println("a < b");
        } else {
            System.out.println("a >= b");
        }
    }

    public static boolean checkSum(int a, int b) {

        int sum = a + b;
        if (sum > 10 && sum <= 20) {
            return true;
        }
        return false;
    }

    public static void checkNumberPrint(int a) {

        if (a < 0) {
            System.out.println("Отрицательное число");
        } else {
            System.out.println("Положительное число");
        }
    }

    public static boolean checkNumber(int a) {

        if (a < 0) {
            return true;
        }
        return false;
    }

    public static void printString(String str, int a) {
        for (int i = 0; i < a; i++) {
            System.out.println(str);
        }
    }

    public static boolean checkYear(int year) {

        if (year % 4 != 0) {
            return false;
        }
        if (year % 100 == 0) {
            if (year % 400 == 0) {
                return true;
            }
            return false;
        }
        return true;
    }

    public static void reverseArray() {
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else {
                array[i] = 0;
            }
        }
    }

    public static void fillArray() {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
    }

    public static void changeArray() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] = array[i] * 2;
            }
        }
    }

    public static void fillSquareArray() {
        int square = 3;
        int[][] squareArray = new int[square][square];
        for (int i = 0; i < squareArray.length; i++) {
            for (int j = 0; j < squareArray.length; j++) {
                if (i == j) {
                    squareArray[i][j] = 1;
                }
            }
        }
    }

    public static int[] initArray(int length, int initialValue) {

        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = initialValue;
        }
        //Arrays.fill(array, initialValue);//предложение IDEA
        return array;
    }
}

