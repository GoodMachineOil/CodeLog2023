package org.example.柠檬水找零leetcode860;

public class Solution {
    public boolean lemonadeChange(int[] bills) {
        int restFive = 0;
        int restTen = 0;

        for(int i = 0 ; i < bills.length; i++){
            if(bills[i] == 5){
                restFive++;
            }
            else if(bills[i] == 10){
                restFive--;
                restTen++;
            }
            else if(bills[i] == 20){
                if(restTen > 0){
                    restTen--;
                    restFive--;
                }else {
                    restFive -=3;
                }
            }
            if(restFive < 0 || restTen < 0){
                return false;
            }
        }
        return true;
    }
}
