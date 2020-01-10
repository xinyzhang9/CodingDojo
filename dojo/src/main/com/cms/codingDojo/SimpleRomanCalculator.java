package com.cms.codingDojo;

import java.util.*;

public class SimpleRomanCalculator {
    private Map<String, String> reduceMap = new LinkedHashMap<>();
    private Map<String, String> minusToNormalMap = new LinkedHashMap<>();
    private Map<Character, Integer> tmpStore = new LinkedHashMap<>();

    public SimpleRomanCalculator() {
        reduceMap.put("IIIII","V");
        reduceMap.put("VV","X");
        reduceMap.put("XXXXX","L");
        reduceMap.put("LL","C");
        reduceMap.put("CCCCC","D");
        reduceMap.put("DD","M");

        minusToNormalMap.put("CM", "DCCCC"); // 900
        minusToNormalMap.put("CD", "CCCC"); // 400
        minusToNormalMap.put("XC", "LXXXX"); // 90
        minusToNormalMap.put("XL", "XXXX"); // 40
        minusToNormalMap.put("IX", "VIIII"); // 9
        minusToNormalMap.put("IV", "IIII"); // 4
        tmpStore.put('M', 0);
        tmpStore.put('D', 0);
        tmpStore.put('C', 0);
        tmpStore.put('L', 0);
        tmpStore.put('X', 0);
        tmpStore.put('V', 0);
        tmpStore.put('I', 0);
    }

    public String add(String a, String b) {
        String combinedString = transform(a, 0) + transform(b, 0);
        String sortedString = combine(combinedString);
        for (Map.Entry<String, String> entry : reduceMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            sortedString = sortedString.replaceAll(key, value);
        }
        return transform(sortedString, 1);
    }

    private String combine(String str) {
        Map<Character, Integer> store = getCharacterIntegerMap();

        String res = "";
        for(Character c : str.toCharArray()) {
            store.put(c, store.get(c) + 1);
        }
        for(Map.Entry<Character, Integer> entry : store.entrySet()) {
            for(int i = 0; i < entry.getValue(); i++) {
                res += entry.getKey();
            }
        }
        return res;
    }

    private Map<Character, Integer> getCharacterIntegerMap() {
        Map<Character, Integer> store = new LinkedHashMap<>();
        store.put('M', 0);
        store.put('D', 0);
        store.put('C', 0);
        store.put('L', 0);
        store.put('X', 0);
        store.put('V', 0);
        store.put('I', 0);
        return store;
    }

    private String transform(String str, int mode) {
        for (Map.Entry<String, String> entry : minusToNormalMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            str = mode == 0 ? str.replaceAll(key, value) : str.replaceAll(value, key);
        }
        return str;
    }

    public String subtract(String a, String b) {
        String res = "";
        String a0 = combine(transform(a,0));
        String b0 = combine(transform(b,0));

        // compare b and a, convert a symbol to b's common symbol recursively until they have common symbols
        List<String> reverseOrderedKeys = new ArrayList<String>(reduceMap.keySet());
        Collections.reverse(reverseOrderedKeys);

        for(Character c : b0.toCharArray()) {
            while (a0.indexOf(c) < 0) {
                for (String key : reverseOrderedKeys) {
                    String value = reduceMap.get(key);
                    a0 = a0.replaceFirst(value, key);
                }
            }
        }
        for(Character c : a0.toCharArray()) {
            tmpStore.put(c, tmpStore.get(c) + 1);
        }
        for(Character c : b0.toCharArray()) {
            tmpStore.put(c, tmpStore.get(c) - 1);
        }
        for(Map.Entry<Character, Integer> entry : tmpStore.entrySet()) {
            for(int i = 0; i < entry.getValue(); i++) {
                res += entry.getKey();
            }
        }
        return transform(res, 1);
    }
}
