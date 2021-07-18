package com.github.dkicinski;

import java.util.*;
import java.util.stream.Collectors;

class TwoStrings {
    public static Set<Character> buildSet(String word) {
         return word.chars().mapToObj((int val) -> (char) val).collect(Collectors.toCollection(HashSet::new));
    }

    public static String twoStrings(String s1, String s2) {
        Set<Character> set1 = buildSet(s1);
        Set<Character> set2 = buildSet(s2);
        set1.retainAll(set2);

        if (set1.isEmpty()) {
            return "NO";
        } else {
            return "YES";
        }
    }

    public static void main(String[] args) {
        String result = twoStrings("Hello", "World");
        System.err.println("result = " + result);
    }
}
