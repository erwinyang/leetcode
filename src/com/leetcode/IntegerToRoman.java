package com.leetcode;

public class IntegerToRoman {
    public String intToRoman(int num) {
        char[][] d = new char[][] { {'I', 'V', 'X'}, {'X', 'L', 'C'}, {'C', 'D', 'M'} };
        
        String result = "";
        int index = 0;
        num %=1000;
        while (num > 0) {
            result = roman(num % 10, d[index++]) + result;
            num /= 10;
        }
        result = thousands(num / 1000) + result;
        return result;
    }
    
    public String thousands(int v) {
        String s = "";
        for (int i=0; i<v; i++) {
            s += 'M';
        }
        return s;
    }
    
    public String roman(int value, char[] digit) {
        String result = null;
        switch (value) {
            case 0:
                return "";
            case 1:
                return ""+ digit[0];
            case 2:
                return ""+ digit[0]+digit[0];
            case 3:
                return ""+ digit[0]+digit[0]+digit[0];
            case 4:
                return ""+ digit[0] + digit[1];
            case 5:
                return ""+ digit[1];
            case 6:
                return ""+ digit[1] + digit[0];
            case 7:
                return ""+ digit[1] + digit[0] + digit[0];
            case 8:
                return ""+ digit[1] + digit[0] + digit[0] + digit[0];
            case 9:
                return ""+ digit[2] + digit[0];
            default:
                return "";
        }
    }
    
    
}
