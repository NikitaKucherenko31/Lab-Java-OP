public class Matrix {
    private int[][] matrix;

    public Matrix(int rows, int cols) {
        matrix = new int[rows][cols];
    }

    //Заполнение матрицы значениями
    public void setElement(int row, int col, int value) {
        matrix[row][col] = value;
    }

    //Возвращение элемента матрицы по адресу
    public int getElement(int row, int col) {
        return matrix[row][col];
    }

    //Сложение матриц
    public Matrix add(Matrix other) {
        Matrix result = new Matrix(matrix.length, matrix[0].length);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result.setElement(i, j, matrix[i][j] + other.getElement(i, j));
            }
        }
        return result;
    }

    //Вычитание матриц
    public Matrix subtract(Matrix other) {
        Matrix result = new Matrix(matrix.length, matrix[0].length);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result.setElement(i, j, matrix[i][j] - other.getElement(i, j));
            }
        }
        return result;
    }

    //Произведение матриц
    public Matrix multiply(Matrix other) {
        int rows = matrix.length;
        int cols = other.matrix[0].length;
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int sum = 0;
                for (int k = 0; k < matrix[0].length; k++) {
                    sum += matrix[i][k] * other.getElement(k, j);
                }
                result.setElement(i, j, sum);
            }
        }
        return result;
    }

    //Печать матрицы в консоль
    public void printMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    //Печать столбца матрицы
    public void printColumn(int col) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(matrix[i][col]);
        }
    }

    //Печать строки матрицы
    public void printRow(int row) {
        for (int j = 0; j < matrix[0].length; j++) {
            System.out.print(matrix[row][j] + " ");
        }
        System.out.println();
    }

    //Печать главной диагонали матрицы
    public void printMainDiagonal() {
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(matrix[i][i] + " ");
        }
        System.out.println();
    }

    //Печать побочной диагонали матрицы
    public void printSecondaryDiagonal() {
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(matrix[i][matrix.length - 1 - i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Matrix matrixA = new Matrix(4,4);
        matrixA.setElement(0,0,3);
        matrixA.setElement(0,1,2);
        matrixA.setElement(0,2,7);
        matrixA.setElement(0,3,9);
        matrixA.setElement(1,0,1);
        matrixA.setElement(1,1,6);
        matrixA.setElement(1,2,12);
        matrixA.setElement(1,3,6);
        matrixA.setElement(2,0,4);
        matrixA.setElement(2,1,7);
        matrixA.setElement(2,2,9);
        matrixA.setElement(2,3,1);
        matrixA.setElement(3,0,8);
        matrixA.setElement(3,1,2);
        matrixA.setElement(3,2,3);
        matrixA.setElement(3,3,5);
        Matrix matrixB = new Matrix(4,4);
        matrixB.setElement(0,0,1);
        matrixB.setElement(0,1,9);
        matrixB.setElement(0,2,2);
        matrixB.setElement(0,3,5);
        matrixB.setElement(1,0,4);
        matrixB.setElement(1,1,2);
        matrixB.setElement(1,2,1);
        matrixB.setElement(1,3,4);
        matrixB.setElement(2,0,8);
        matrixB.setElement(2,1,5);
        matrixB.setElement(2,2,7);
        matrixB.setElement(2,3,2);
        matrixB.setElement(3,0,2);
        matrixB.setElement(3,1,9);
        matrixB.setElement(3,2,11);
        matrixB.setElement(3,3,4);
        System.out.println("Матрица A:");
        matrixA.printMatrix();

        System.out.println("Матрица B:");
        matrixB.printMatrix();

        Matrix sum = matrixA.add(matrixB);
        System.out.println("Сумма матриц:");
        sum.printMatrix();

        Matrix difference = matrixA.subtract(matrixB);
        System.out.println("Разность матриц:");
        difference.printMatrix();

        Matrix product = matrixA.multiply(matrixB);
        System.out.println("Произведение матриц:");
        product.printMatrix();

        System.out.println("3 столбец матрицы A:");
        matrixA.printColumn(2);

        System.out.println("2 строка матрицы B:");
        matrixB.printRow(1);

        System.out.println("Главная диагональ матрицы B:");
        matrixB.printMainDiagonal();

        System.out.println("Побочная диагональ матрицы A:");
        matrixA.printSecondaryDiagonal();
    }
}