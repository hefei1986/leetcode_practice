package com.hangzhou.hefei;

import java.util.LinkedList;
import java.util.List;

/**
 * leetcode practice
 *
 * @author hefei.hfei@alibaba-inc.com
 * @create 2017-05-21 9:36
 */
public class CombanationsOfPhoneNumber {
    String[] alphas = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> combinations = new LinkedList<String>();

    public void findCombinations(String current, byte[] digits, int index) {
        if(index >= digits.length) {
            if(current.length() > 0) {
                combinations.add(current);
            }
            return;
        }
        String currentPossibleString = alphas[digits[index] - '0'];
        for(int i = 0; i < currentPossibleString.length(); ++i) {
            findCombinations(current + currentPossibleString.substring(i, i+1), digits, index + 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        findCombinations("", digits.getBytes(), 0);
        return combinations;
    }

    public static void main(String[] args) {
        CombanationsOfPhoneNumber cp = new CombanationsOfPhoneNumber();
        List<String> l = cp.letterCombinations("");
        System.out.println(l);

    }
}
