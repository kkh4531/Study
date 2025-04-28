package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

//    static int arr[];
//    static boolean visit[] = new boolean[501];
//    public static int bfs(int n, int t) {
//        Queue<Integer> q = new LinkedList<>();
//        for (int i = 0; i < n; i++) {
//            q.offer(arr[i]);
//            visit[arr[i]] = true;
//        }
//        int L = 1;
//        while (!q.isEmpty()) {
//            int len = q.size();
//            for (int i = 0; i < len; i++) {
//                int cv = q.poll();
//                if (cv == t) {
//                    return L;
//                } else {
//                    for (int j = 0; j < arr.length; j++) {
//                        if (!visit[cv + arr[j]]) {
//                            q.offer(cv + arr[j]);
//                            visit[cv + arr[j]] = true;
//                        }
//                    }
//                }
//            }
//            L++;
//        }
//        return 0;
//    }
    static int arr[][];
    public static int dfs(int n, int r) {
        if (r == 0 || n == r) {
            return 1;
        } else {
            if (arr[n][r] != 0) {
                return arr[n][r];
            } else {
                return arr[n][r] = dfs(n - 1, r - 1) + dfs(n - 1, r);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][r + 1];
        System.out.println(dfs(n, r));
    }
}