import java.util.ArrayList;
import java.util.Arrays;

/**
 * 题目名称：permutations
 * 题目描述：
 * Given a collection of numbers, return all possible permutations.
 * For example,
 * [1,2,3]have the following permutations:
 * [1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2], and[3,2,1].
 */
public class Solution {
    /**
     * 思路：
     * 把每个数字和它后面的所有数字进行交换
     */
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        // 合法性判断
        if (num == null || num.length == 0) {
            return result;
        }
        // 递归搜索
        permutation(num, 0, result);
        // 返回结果
        return result;
    }
    
    /**
     * 用于查找数组中所有元素的全排列
     */
    public void permutation(int[] num, int index, ArrayList<ArrayList<Integer>> list) {
        // 递归终止条件：index已经到达数组的末尾的时候就向集合中添加一条记录，并返回
        if (index == num.length - 1) {
            list.add(arrayToList(num));
            return ;
        }
        // 把当前位置的数字和它后面的所有数字进行交换
        for (int i = index; i < num.length; i++) {
            swap(num, index, i);
            permutation(num, index + 1, list);
            // 换完了还要换回来
            swap(num, index, i);
        }
    }
    
    // 交换数组中的两个元素的值
    public void swap(int[] num, int num1, int num2) {
        int temp = num[num1];
        num[num1] = num[num2];
        num[num2] = temp;
    }
    
    // 将数组转换成集合
    public ArrayList<Integer> arrayToList(int[] num) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int temp : num) {
            list.add(temp);
        }
        return list;
    }
    
}