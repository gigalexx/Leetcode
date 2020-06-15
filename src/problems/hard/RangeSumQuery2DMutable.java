package problems.hard;

public class RangeSumQuery2DMutable {


    public static void main(String[] args) {

        int[][] matrix = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};

        NumMatrix ma = new NumMatrix(matrix);


        System.out.println(ma.sumRegion(2, 1, 4, 3));
        ma.update(3, 2, 2);
        System.out.println(ma.sumRegion(2, 1, 4, 3));
    }
}

class NumMatrix {

    int[][] mat = null;

    public NumMatrix(int[][] matrix) {

        mat = matrix;

    }

    public void update(int row, int col, int val) {
        mat[row][col] = val;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;


        for (int row = row1; row <= row2; row++) {
            for (int col = col1; col <= col2; col++) {
                sum += mat[row][col];
            }
        }
        return sum;
    }

}
