package com.cms.codingDojo;

public class RomanCalculator {
    public int toNum(String str) {
        int res = 0;
        Character tmp = 'Q';
        for(Character c : str.toCharArray()) {
            if(getRomanValue(c) > getRomanValue(tmp)) {
                res += getRomanValue(c) - 2 * getRomanValue(tmp);
            } else {
                res += getRomanValue(c);
            }
            tmp = c;
        }
        return res;
    }

    private int getRomanValue(Character c) {
        if(c == 'I') return RomanEnum.I.getValue();
        if(c == 'V') return RomanEnum.V.getValue();
        if(c == 'X') return RomanEnum.X.getValue();
        if(c == 'L') return RomanEnum.L.getValue();
        if(c == 'C') return RomanEnum.C.getValue();
        if(c == 'D') return RomanEnum.D.getValue();
        if(c == 'M') return RomanEnum.M.getValue();
        return 10000;
    }

    public String toRoman(int n) {
        int num[] = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
        String sym[] = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        int i = 12;
        String res = "";
        while(n > 0 && i >=0) {
            int div = n / num[i];
            n = n % num[i];
            while(div > 0) {
                res += sym[i];
                div--;
            }
            i--;
        }
        return res;
    }

    public String add(String a, String b) {
        return toRoman(toNum(a) + toNum(b));
    }
}


