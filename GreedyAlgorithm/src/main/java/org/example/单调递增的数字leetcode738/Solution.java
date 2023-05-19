package org.example.单调递增的数字leetcode738;

public class Solution {
    public int monotoneIncreasingDigits(int n) {
        String s = String.valueOf(n);
        char[] ch = s.toCharArray();
        int flag = s.length();
        for(int i = s.length()-1; i > 0 ; i--){
            if( ch[i-1] > ch[i]){
                flag = i;
                ch[i-1]--;
            }
        }
        for(int i = flag ; i < s.length(); i++){
            ch[i] = '9';
        }
        return Integer.parseInt(String.valueOf(ch));
    }
}
