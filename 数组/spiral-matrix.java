import java.util.ArrayList;
/**
 * 题目名称：spiral-matrix
 * 题目描述：
 * Given a matrix of m x n elements (m rows, n columns),
 * return all elements of the matrix in spiral order.
 * For example,
 * Given the following matrix:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * You should return[1,2,3,6,9,8,7,4,5].
 */
public class Solution {
    /**
     * 思路：
     * 从左上角按照右->下->左->上的方式一直朝着一个方向走到边界（下标越界或下一个位置已经访问过），然后转换下一个方向
     * 循环走完所有的步数 = m * n
     */
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        // 合法性判断
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        // 记录行数和列数
        int rows = matrix.length;
        int cols = matrix[0].length;
        // 记录所需要走的总步数
        int total = rows * cols;
        // 记录当前遍历到的矩阵中的位置
        int x = 0;
        int y = -1;
        // 定义一个标记数组来记录矩阵是否被访问过
        byte[][] flag = new byte[rows][cols];
        // 循环顺时针遍历矩阵
        while (total-- > 0) {
            // 1.一直向右走
            while (y + 1 < cols && flag[x][y + 1] != 1) { // 没有过边界并且没有被访问过
                flag[x][++y] = 1;
                result.add(matrix[x][y]);
            }
            // 2.一直向下走
            while (x + 1 < rows && flag[x + 1][y] != 1) { // 没有过边界并且没有被访问过
                flag[++x][y] = 1;
                result.add(matrix[x][y]);
            }
            // 3.一直向左走
            while (y - 1 > -1 && flag[x][y - 1] != 1) { // 没有过边界并且没有被访问过
                flag[x][--y] = 1;
                result.add(matrix[x][y]);
            }
            // 4.一直向上走
            while (x - 1 > -1 && flag[x - 1][y] != 1) { // 没有过边界并且没有被访问过
                flag[--x][y] = 1;
                result.add(matrix[x][y]);
            }
        }
        
        return result;
    }
}