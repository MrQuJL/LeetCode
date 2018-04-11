import java.util.HashMap;

/**
 * 题目名称：two-sum
 * 题目描述：
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2.
 * Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution.
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */
public class Solution {
    /**
     * 思路：
     * 1.HashMap中存储键为target-每个数的结果值，值为下标
     * 2.每次放入的时候查看是否包含当前值
     * 3.有的话说明当前值和已包含的值的下标的那个元素为需要的结果
     */
    public int[] twoSum(int[] numbers, int target) {
        // 合法性判断
        if (numbers == null || numbers.length == 0) {
            return new int[0];
        }
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                result[0] = map.get(numbers[i]) + 1;
                result[1] = i + 1;
                break;
            } else {
                map.put(target - numbers[i], i);
            }
        }
        return result;
    }
    
}