package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int input[];
    static String res = "NO";
    static int sum = 0;
    static int total;
    static boolean flag = false;
    public static void dfs(int depth) {
        if (flag) return;
        if (depth == n) {
            int tmp = total - sum;
            if (tmp == sum) {
                res = "YES";
                flag = true;
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
        n = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        input = new int[n];
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            input[i] = tmp;
            total += tmp;
        }
        dfs(0);
        System.out.println(res);
    }
}