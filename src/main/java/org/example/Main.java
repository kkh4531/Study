package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static boolean visit[]; // 이미 지나온 정점으로 다시 돌아가면 안되니 체크 배열
    static boolean graph[][]; // 정점에서 정점으로 방향이 있는 그래프
    static int cnt;

    public static void dfs(int v) {
        if (v == n) {
            cnt++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!visit[i] && graph[v][i]) {
                visit[i] = true;
                dfs(i);
                visit[i] = false;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visit = new boolean[n + 1];
        graph = new boolean[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from][to] = true;
        }
        visit[1] = true; // 정점 1부터 시작하니 1은 이미 방문한 상태
        dfs(1);
        System.out.println(cnt);
    }
}