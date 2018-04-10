/**
 * 题目名称：length-of-last-word
 * 题目描述：
 * Given a string s consists of upper/lower-case alphabets and empty space characters' ',
 * return the length of last word in the string.
 * If the last word does not exist, return 0.
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * For example, 
 * Given s ="Hello World",
 * return5.
 */
public class Solution {
    /**
     * 思路：
     * 反向查找，末尾空格忽略，行中出现空格就终止循环
     * 禁止用库函数
     */
    public int lengthOfLastWord(String s) {
        char[] ch = s.toCharArray();
        int count = 0;
        for (int i = s.length() - 1; i > -1; i--) {
            if (ch[i] == ' ') {
                if (count != 0) {
                    break;
                }
            } else {
                count++;
            }
        }
        return count;
    }
}