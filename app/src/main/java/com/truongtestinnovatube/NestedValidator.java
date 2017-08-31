package com.truongtestinnovatube;

import java.util.Stack;

/**
 * Created by truongtechno on 8/31/17.
 */

public class NestedValidator {

    public static boolean isNested(String input) {
        if (solution(input) == 1) {
            return true;
        }
        return false;
    }

    public static int solution(String input) {
        if (input.length() == 0) return 1;

        if (input.length() % 2 == 1) return 0;

        if (input.charAt(0) != '(' && input.charAt(input.length() - 1) != ')') return 0;

        Stack<Character> chars = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            if (chars.size() == 0) {
                chars.push(input.charAt(i));
            } else {
                if (isMatch(chars.peek(), input.charAt(i))) {
                    chars.pop();
                } else {
                    chars.push(input.charAt(i));
                }
            }
        }
        return chars.size() == 0 ? 1 : 0;
    }

    private static boolean isMatch(char a, char b) {
        switch (a) {
            case '{':
                return b == '}';
            case '(':
                return b == ')';
            case '[':
                return b == ']';
            case '<':
                return b == '>';
            default:
                return false;
        }
    }
}
