package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static String solution(String target, String lectures) {
        Queue<Character> queue = new ArrayDeque<>();
        for (int i = 0; i < target.length(); i++) {
            queue.add(target.charAt(i));
        }
        for (int i = 0; i < lectures.length(); i++) {
            if (lectures.charAt(i) == queue.peek()) {
                queue.poll();
            }
            if (queue.isEmpty()) {
                return "YES";
            }
        }
        return "NO";
    }
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String target = bufferedReader.readLine();
        String lectures = bufferedReader.readLine();

        System.out.println(solution(target, lectures));
    }

}
