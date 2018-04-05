import java.util.Set;

/**
 * 题目名称：word-break
 * 题目描述：
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a 
 * space-separated sequence of one or more dictionary words.
 * For example, given
 * s ="leetcode",
 * dict =["leet", "code"].
 * Return true because"leetcode"can be segmented as"leet code".
 */
public class Solution {
    /**
     * 思路：
     * 动态规划，状态转移方程：
     * f(i)表示0-i是否可以分词
     * f(i) = f(j) && f(j + 1, i) 0 <= j < i
     */
    public boolean wordBreak(String s, Set<String> dict) {
        int len = s.length();
        boolean[] flag = new boolean[len + 1];
        flag[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (flag[j] && dict.contains(s.substring(j, i))) {
                    flag[i] = true;
                    break;
                }
            }
        }
        return flag[len];
    }
}