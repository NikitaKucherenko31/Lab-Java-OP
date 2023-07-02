package mineMatrix;

import java.io.*;
import java.util.Arrays;

public class Matrix {
    // Запись матрицы в файл
    public static void addMatrixToFile(double[][] matrix) {
        File file = new File("matr.txt");

        try {
            FileWriter fw = new FileWriter(file);

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    fw.write(matrix[i][j] + " ");
                }
                fw.write(System.lineSeparator());
            }
            fw.close();
            System.out.println("Матрица записана");
        } catch (IOException e) {
            System.out.println("Ошибка записи матрицы");
        }
    }

    // Печать матрицы из файла
    public static void outputLastMatrix() {

        try (FileReader fr = new FileReader("matr.txt");
             BufferedReader br = new BufferedReader(fr))
        {
            String line = br.readLine();

            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    // Сложение двух матриц
    public static double[][] sum2Matrix(double[][] A, double[][] B) {
        int rows = A.length;
        int cols = A[0].length;
        double[][] result = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = A[i][j] + B[i][j];
            }
        }
        return result;
    }
    // Вычитание двух матриц
    public static double[][] sub2Matrix(double[][] A, double[][] B) {
        int rows = A.length;
        int cols = A[0].length;
        double[][] result = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = A[i][j] - B[i][j];
            }
        }
        return result;
    }
    // Транспонирование матрицы
    public static double[][] transposeMatrix(double[][] A) {
        int rows = A.length;
        int cols = A[0].length;
        double[][] result = new double[cols][rows];
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                result[i][j] = A[j][i];
            }
        }
        return result;
    }
    // Умножение двух матриц
    public static double[][] multiplyMatrix(double[][] A, double[][] B) {
        int rowsA = A.length;
        int colsA = A[0].length;
        int rowsB = B.length;
        int colsB = B[0].length;
        if (colsA != rowsB) {
            throw new IllegalArgumentException("Количество столбцов матрицы " +
                    "A не совпадает с количеством строк матрицы B");
        }
        double[][] result = new double[rowsA][colsB];
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                double sum = 0;
                for (int k = 0; k < colsA; k++) {
                    sum += A[i][k] * B[k][j];
                }
                result[i][j] = sum;
            }
        }
        return result;
    }

    // Детерминант матрицы
    public static double determinant(double[][] A) {
        int n = A.length;
        if (n != A[0].length) {
            throw new IllegalArgumentException("Матрица должна быть квадратной!");
        }
        double det = 0;
        if (n == 1) {
            det = A[0][0];
        } else if (n == 2) {
            det = A[0][0] * A[1][1] - A[1][0] * A[0][1];
        } else {
            for (int j1 = 0; j1 < n; j1++) {
                double[][] m = new double[n - 1][];
                for (int k = 0; k < n - 1; k++) {
                    m[k] = new double[n - 1];
                }
                for (int i = 1; i < n; i++) {
                    int j2 = 0;
                    for (int j = 0; j < n; j++) {
                        if (j == j1) {
                            continue;
                        }
                        m[i - 1][j2] = A[i][j];
                        j2++;
                    }
                }
                det += Math.pow(-1.0, j1 + 2.0) * A[0][j1] * determinant(m);
            }
        }
        return det;
    }

    // Сумма элементов матрицы
    public static double sumMatrix(double[][] A) {
        double sum = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                sum += A[i][j];
            }
        }
        return sum;
    }
    // Произведение элементов матрицы
    public static double multMatrix(double[][] A) {
        double mult = 1;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                mult = mult * A[i][j];
            }
        }
        return mult;
    }
}