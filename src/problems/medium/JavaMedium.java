package problems.medium;

import java.util.Arrays;

public class JavaMedium {


    public static void main(String[] args) {
        char[][] arr = {
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'}
        };

        JavaMedium medium = new JavaMedium();

        medium.numIslands(arr);

    }


    public int numIslands(char[][] grid) {

        int numsOfIslands = 0;

        for (int rowIndex = 0; rowIndex < grid.length; rowIndex++) {
            for (int colIndex = 0; colIndex < grid[rowIndex].length; colIndex++) {
                if (grid[rowIndex][colIndex] == '1') {
                    numsOfIslands++;
                    dfs(rowIndex, colIndex, grid);

                }
            }

        }


        return numsOfIslands;
    }

    private void dfs(int rowIndex, int colIndex, char[][] grid) {

        if (rowIndex < 0 || rowIndex >= grid.length || colIndex < 0 || colIndex >= grid[rowIndex].length || grid[rowIndex][colIndex] == '0') {
            return;
        }

        grid[rowIndex][colIndex] = '0';
        dfs(rowIndex + 1, colIndex, grid);
        dfs(rowIndex - 1, colIndex, grid);
        dfs(rowIndex, colIndex + 1, grid);
        dfs(rowIndex, colIndex - 1, grid);
    }


}
