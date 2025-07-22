package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int cnt = 0;

    public static void dfs(int sum, int n) {
        int[] arr = {1, 2};
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == n) {
                cnt++;
                sum -= arr[i];
            } else {
                if (sum < n) dfs(sum, n);
                sum -= arr[i];
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        dfs(0, n);
        System.out.println(cnt);
    }
}