import mineMatrix.Matrix;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Matrix matrix = new Matrix();

        double[][] A = {
                {10, 8, 2},
                {1, 3, 19},
                {5, 14, 1}
        };
        double[][] B = {
                {12, 8, 6},
                {11, 15, 8},
                {7, 9, 1}
        };

        double[][] sum2Matr = matrix.sum2Matrix(A, B);
        System.out.println(Arrays.deepToString(sum2Matr));
        double[][] sub2Matr = matrix.sub2Matrix(A, B);
        System.out.println(Arrays.deepToString(sub2Matr));
        double[][] tMatr = matrix.transposeMatrix(A);
        System.out.println(Arrays.deepToString(tMatr));
        double[][] mult2Matr = matrix.multiplyMatrix(A, B);
        System.out.println(Arrays.deepToString(mult2Matr));
        double dMatr = matrix.determinant(A);
        System.out.println(dMatr);
        double multMatr = matrix.multMatrix(A);
        System.out.println(multMatr);
        double result7 = matrix.sumMatrix(A);
        System.out.println(result7);
        matrix.addMatrixToFile(A);
        matrix.outputLastMatrix();


    }
}