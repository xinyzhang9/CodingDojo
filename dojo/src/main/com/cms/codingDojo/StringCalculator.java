package com.cms.codingDojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private List<Integer> negatives = new ArrayList<>();
    public int add(String s) {
        if (s.equals("")) {
            return 0;
        }
        String delimiter = "[,\\n]";
        String numbers = s;
        if (s.startsWith("//")) {
            String[] prefix = s.split("\n");
            numbers = prefix[1];
            delimiter = s.substring(2,3);
            Pattern pattern = Pattern.compile("\\[(.*?)\\]");
            Matcher match = pattern.matcher(s);
            delimiter = getDelimiter(delimiter, prefix[0], match);
        }

        int res = Arrays.asList(numbers.split(delimiter))
                .stream()
                .filter(e -> !e.isEmpty())
                .map(e -> Integer.parseInt(e))
                .map(e -> checkNegatives(e))
                .reduce(0, (subtotal, n) -> n > 1000 ? subtotal : subtotal + n);

        if(negatives.size() > 0) {
            throw new RuntimeException("negatives are not allowed" + negatives.stream()
                    .map(e -> e.toString())
                    .reduce("", (msg, n) -> msg + ' ' + n));
        }
        return res;
    }

    private int checkNegatives(Integer e) {
        if(e < 0) {
            negatives.add(e);
        };
        return e;
    }

    private String getDelimiter(String delimiter, String prefix, Matcher match) {
        if(prefix.contains("][")) {
            delimiter = "[";
            while(match.find()) {
                delimiter += '|'+match.group(1);
            }
            delimiter += "]";
        } else {
            if (match.find()){
                delimiter = match.group(1);
            }
        }
        return delimiter;
    }
}
