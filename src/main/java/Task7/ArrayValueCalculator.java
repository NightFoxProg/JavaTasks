package Task7;

import java.util.Arrays;

public class ArrayValueCalculator {
    private static final int ARRAY_SIZE = 4;

    public static int doCalc(String[][] array) throws ArraySizeException, ArrayDataException {
        // Check array size
        if (array.length != ARRAY_SIZE || Arrays.stream(array).anyMatch(a -> a.length != ARRAY_SIZE)) {
            throw new ArraySizeException("Array size must be 4x4");
        }

        int result = 0;
        for (int i = 0; i < ARRAY_SIZE; i++) {
            for (int j = 0; j < ARRAY_SIZE; j++) {
                // Parse element and add to result
                try {
                    result += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new ArrayDataException("Invalid data in cell [" + i + "][" + j + "]: " + array[i][j], e);
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String[][] array = {{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};
        try {
            int result = ArrayValueCalculator.doCalc(array);
            System.out.println("Result: " + result);
        } catch (ArraySizeException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (ArrayDataException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Cause: " + e.getCause().getMessage());
        }
    }
}


