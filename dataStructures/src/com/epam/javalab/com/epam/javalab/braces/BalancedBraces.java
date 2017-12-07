package com.epam.javalab.com.epam.javalab.braces;

import java.util.*;

public class BalancedBraces {

    private Stack<Character> foundOpenBraces;
    private char[] chars;

    private static final Map<Character, Character> appropriateBraces;
    private static final List<Character> openBraces;
    private static final List<Character> closeBraces;

    static {
        appropriateBraces = new HashMap<>();
        appropriateBraces.put('}', '{');
        appropriateBraces.put(']', '[');
        appropriateBraces.put(')', '(');

        openBraces = Arrays.asList('{', '[', '(');
        closeBraces = Arrays.asList('}', ']', ')');
    }

    public BalancedBraces(String string) {
        this.chars = string.toCharArray();
        foundOpenBraces = new Stack<>();
    }

    public boolean validateString() {

        for (char letter: chars){
            if (openBraces.contains(letter)) {
                foundOpenBraces.push(letter);
            }
            if (closeBraces.contains(letter) &&
                    (foundOpenBraces.empty() || !appropriateBraces.get(letter).equals(foundOpenBraces.pop()))) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(new BalancedBraces("{[((({})))]}").validateString());
        System.out.println(new BalancedBraces("{[((({)))]}").validateString());
        System.out.println(new BalancedBraces("})((({))]}").validateString());
        System.out.println(new BalancedBraces("{[(()({}))]}").validateString());
        System.out.println(new BalancedBraces("{[(()({})())]}").validateString());
    }
}
