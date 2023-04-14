package org.example;

public class Solution {
    public String Stringtext(String[] s) {
        int[] k = new int[s.length];
        for (int h = 0; h < s.length; h++) {
            k[h] = 0;
        }
        int i;
        int j;
        for (i = 0; i < s.length; i++) {
            for (j = i; j < s.length; j++) {
                if (s.chartAt(i) > s.chartAt(j)) {
                    k[]++;
                }
            }
        }
    }
}
