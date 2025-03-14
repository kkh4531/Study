package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static char solution(int n, String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        char value = '\u0000';
        for (int i = 0; i < n; i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }
        int max = Integer.MIN_VALUE;
        for (char c : map.keySet()) {
            if (map.get(c) > max) {
                max = map.get(c);
                value = c;
            }
        }
        return value;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        String str = bufferedReader.readLine();
        System.out.println(solution(n, str));
    }

}
