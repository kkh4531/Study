package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int input[];
    static int grade = 0;
    static int m;
    static int max = Integer.MIN_VALUE;
    static int time = 0;
    static HashMap<Integer, Integer> map;

    public static void dfs(int depth) {
        if (depth == n) {
            if (time <= m) { // time이 m이하이면
                max = Math.max(grade, max);
            }
            return;
        }
        grade += input[depth];
        time += map.get(input[depth]);
        dfs(depth + 1);
        grade -= input[depth];
        time -= map.get(input[depth]);
        dfs(depth + 1);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        input = new int[n];
        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int score = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            input[i] = score;
            map.put(score, time);
        }
        dfs(0);
        System.out.println(max);
    }
}