package Task10;

public class ValueCalculator {
    private float[] array;
    private int size;
    private int halfSize;

    public ValueCalculator(int size) {
        if (size < 1000000) {
            size = 1000000;
        }
        this.size = size;
        this.halfSize = size / 2;
        this.array = new float[size];
    }

    public void calculateValues() {
        long start = System.currentTimeMillis();

        // Заповнення масиву одиницями
        for (int i = 0; i < size; i++) {
            array[i] = 1.0f;
        }

        // Розбиття масиву на два
        float[] array1 = new float[halfSize];
        float[] array2 = new float[halfSize];
        System.arraycopy(array, 0, array1, 0, halfSize);
        System.arraycopy(array, halfSize, array2, 0, halfSize);

        // Створення та запуск потоків
        Thread thread1 = new Thread(() -> calculateValuesInRange(array1, 0, halfSize));
        Thread thread2 = new Thread(() -> calculateValuesInRange(array2, 0, halfSize));
        thread1.start();
        thread2.start();

        // Очікування завершення потоків
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Зворотне склеювання двох масивів в один
        System.arraycopy(array1, 0, array, 0, halfSize);
        System.arraycopy(array2, 0, array, halfSize, halfSize);

        long end = System.currentTimeMillis();
        long executionTime = end - start;

        System.out.println("Execution time: " + executionTime + "ms");
    }

    private void calculateValuesInRange(float[] array, int start, int end) {
        for (int i = start; i < end; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    public int getSize() {
        return size;
    }

    public int getHalfSize() {
        return halfSize;
    }

    public static void main(String[] args) {
        ValueCalculator calculator = new ValueCalculator(1000000);
        calculator.calculateValues();
    }
}