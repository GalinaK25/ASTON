package Task4;

public class TestArray {
    static String[][] stringArraySizeException = {
            {"11", "12", "13", "14"},
            {"21", "22", "23", "24"},
            {"31", "32", "33", "34"},
            {"41", "42", "43"}
    };
    static String[][] stringArrayDataException = {
            {"11", "12", "13", "14"},
            {"21", "A2", "23", "24"},
            {"31", "32", "A3", "34"},
            {"41", "42", "43", "44"}
    };
    static String[][] stringArray = {
            {"11", "12", "13", "14"},
            {"21", "22", "23", "24"},
            {"31", "32", "33", "34"},
            {"41", "42", "43", "44"}
    };

    public static void main(String[] args) {
        try {
            sumArray(stringArraySizeException);
        } catch (MyArraySizeException e) {
            System.out.println("MyArraySizeException: " + e.getMessage());
        }
        try {
            sumArray(stringArrayDataException);
        } catch (MyArrayDataException e) {
            System.out.println("MyArrayDataException: " + e.getMessage());
        }
        sumArray(stringArray);//for ArrayIndexOutOfBoundsException change condition in 'for': from < to <=
    }

    static void sumArray(String[][] stringArray) {
        int[][] intArray = new int[4][4];
        int sum = 0;
        for (int i = 0; i < stringArray.length; i++) {
            for (int j = 0; j < stringArray[i].length; j++) {
                if (stringArray.length == 4 && stringArray[i].length == 4) {
                    try {
                        intArray[i][j] = Integer.parseInt(stringArray[i][j]);
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException("Value in cell [" + i + "][" + j + "] is not a number, " + e.getMessage());
                    }
                } else {
                    throw new MyArraySizeException("Array size should be 4 x 4");
                }
            }
        }
        try {
            //for (int i = 0; i <= intArray.length; i++) {//example for ArrayIndexOutOfBoundsException
            for (int i = 0; i < intArray.length; i++) {
                for (int j = 0; j < intArray[i].length; j++) {
                    sum += intArray[i][j];
                }
            }
            System.out.println("Sum = " + sum);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException: " + e.getMessage());
        }
    }
}
