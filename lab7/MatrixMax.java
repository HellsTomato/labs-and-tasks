public class MatrixMax {
    public static void main(String[] args) {
        // матрица 4 x 4
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        // Массив для хранения максимальных элементов в каждой строке
        int[] maxInRows = new int[matrix.length];

        // Массив для хранения потоков
        // Для каждой строки отдельный поток
        Thread[] threads = new Thread[matrix.length];

        // Цикл для создания и запуска потоков
        for (int i = 0; i < matrix.length; i++) {
            // final для доступа внутри лямбда-выражения
            final int row = i;
            // поток, для поиска максиму в строке
            threads[i] = new Thread(() -> {
                // Инициализируем максимальное значение в строке
                int maxInRow = matrix[row][0];
                // чикл, чтобы просмотреть все элементы строк
                for (int j = 1; j < matrix[row].length; j++) {
                    // если текущий элемент больше, обновляем max
                    if (matrix[row][j] > maxInRow) {
                        maxInRow = matrix[row][j];
                    }
                }
                // Сохраняем максимальный элемент строки
                maxInRows[row] = maxInRow;
            });
            threads[i].start(); // Запускаем поток для обработки строки
        }

        try {
            // Ждем завершения всех потоков
            for (int i = 0; i < threads.length; i++) {
                threads[i].join(); // Ждем завершения каждого потока
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Находим наибольшее значение среди максимальных элементов строк
        int overallMax = maxInRows[0];
        for (int i = 1; i < maxInRows.length; i++) {
            if (maxInRows[i] > overallMax) {
                overallMax = maxInRows[i];
            }
        }

        // Выводим итоговый результат
        System.out.println("The largest element in the matrix: " + overallMax);
    }
}

