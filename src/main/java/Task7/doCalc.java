import java.util.Arrays;

public class doCalc {

    public static int doCalc(String[][] array) throws ArraySizeException, ArrayDataException {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new ArraySizeException("Array size must be 4x4");
            }
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new ArrayDataException("Invalid data in cell [" + i + "][" + j + "]", e);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String[][] array = {{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};
        try {
            int sum = doCalc(array);
            System.out.println("Sum: " + sum);
        } catch (ArraySizeException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (ArrayDataException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Cause: " + e.getCause().getMessage());
        }
    }
}