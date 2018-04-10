/**
 * 题目名称：spiral-matrix-ii
 * 题目描述：
 * Given an integer n, generate a square matrix filled with elements from 1 to n 2 in spiral order.
 * For example,
 * Given n =3,
 * You should return the following matrix:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 */
public class Solution {
    /**
     * 思路：
     * 一直朝着一个方向走走到头换下一个方向
     */
    public int[][] generateMatrix(int n) {
        // 合法性判断
        if (n <= 0) {
            return new int[0][0];
        }
        int[][] matrix = new int[n][n];
        // 标记数组
        byte[][] flag = new byte[n][n];
        int total = 1;
        int x = 0;
        int y = -1;
        while (total <= n * n) {
            // 先一直往右走
            while (y + 1 < n && flag[x][y + 1] != 1) {
                matrix[x][++y] = total++;
                flag[x][y] = 1;
            }
            // 再一直往下走
            while (x + 1 < n && flag[x + 1][y] != 1) {
                matrix[++x][y] = total++;
                flag[x][y] = 1;
            }
            // 然后一直往左走
            while (y - 1 > -1 && flag[x][y - 1] != 1) {
                matrix[x][--y] = total++;
                flag[x][y] = 1;
            }
            // 再一直往上走
            while (x - 1 > -1 && flag[x - 1][y] != 1) {
                matrix[--x][y] = total++;
                flag[x][y] = 1;
            }
        }
        return matrix;
    }
}