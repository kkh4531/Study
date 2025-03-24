package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static StringBuilder solution(String input) {
        StringBuilder result = new StringBuilder();
        Deque<String> dq = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                dq.add("(");
            } else if (input.charAt(i) == ')') {
                dq.removeLast();
            } else if (dq.isEmpty()) {
                result.append(input.charAt(i));
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String input = bufferedReader.readLine();
        System.out.println(solution(input));
    }

}
