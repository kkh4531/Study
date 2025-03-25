package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int solution(String str) {
        int result = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) { // 숫자이면
                dq.addLast(Character.getNumericValue(c));
            } else { // 연산자이면
                int second = dq.pollLast();
                int first = dq.pollLast();
                int tempResult = 0;
                switch (c) {
                    case '*' :
                        tempResult = first * second; break;
                    case '+' :
                        tempResult = first + second; break;
                    case '-' :
                        tempResult = first - second; break;
                    case '/' :
                        tempResult = first / second; break;
                }
                dq.addLast(tempResult);
            }
        }
        result = dq.poll();
        return result;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String str = bufferedReader.readLine();

        System.out.println(solution(str));
    }

}
