package com.cms.codingDojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public int add(String s) {
        if (s.equals("")) {
            return 0;
        }
        String delimiter = "[,\\n]";
        String numbers = s;
        if (s.startsWith("//")) {
            numbers = s.split("\n")[1];
            delimiter = s.substring(2,3);

            Pattern pattern = Pattern.compile("\\[([^\\[\\]])\\]");
            List<String> list = new ArrayList<>();
            Matcher match = pattern.matcher(s);
            while(match.find()) {
                list.add(match.group(1));
            }
            System.out.println(list);
//            if (match.find()){
//                delimiter = match.group(1);
//            }
        }
        return Arrays.asList(numbers.split(delimiter))
                .stream()
                .map(e -> Integer.parseInt(e))
                .reduce(0, (subtotal, n) -> n > 1000 ? subtotal : subtotal + n);
    }
}
