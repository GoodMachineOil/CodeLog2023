package org.example.替换空格leetcode剑指offer05;

public class Solution2 {
    public String replaceSpace(String s) {
        if (s == null) {
            return null;
        }
        StringBuffer sb = new StringBuffer();
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == ' ') {
                sb.append("%20");
            } else {
                sb.append(ch[i]);
            }
        }
        return sb.toString();
    }
}
