package org.example.有效的字母异位词.leetcode383赎金信;

public class Solution2 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] record = new int[26];

        if(ransomNote.length() > magazine.length()){
            return false;
        }
        for(char c : magazine.toCharArray()){
            record[c - 'a']++;
        }
        for(char c : ransomNote.toCharArray()){
            record[c - 'a']--;
            if(record[c - 'a'] < 0){
                return false;
            }
        }
        return true;
    }
}
