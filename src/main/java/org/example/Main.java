package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int input[];
    static int sum = 0;
    static int c;
    static int max = Integer.MIN_VALUE;

    public static void dfs(int depth) {
        if (depth == n) {
            if (sum <= c) {
                max = Math.max(sum, max);
            }
            return;
        }
        sum += input[depth];
        dfs(depth + 1);
        sum -= input[depth];
        dfs(depth + 1);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        input = new int[n];
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(bufferedReader.readLine());
            input[i] = tmp;
        }
        dfs(0);
        System.out.println(max);
    }
}