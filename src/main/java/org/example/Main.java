package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static boolean visit[]; // 이미 지나온 정점으로 다시 돌아가면 안되니 체크 배열
    static int cnt;
    static ArrayList<ArrayList<Integer>> graph;

    public static void dfs(int v) {
        if (v == n) {
            cnt++;
            return;
        }
        for (int nv : graph.get(v)) {
            if (!visit[nv]) { // 아직 방문하지 않은 정점이면
                visit[nv] = true;
                dfs(nv);
                visit[nv] = false;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int from = Integer.parseInt(st.nextToken()); // 정점
            int to = Integer.parseInt(st.nextToken()); // 정점
            graph.get(from).add(to);
        }
        visit = new boolean[n + 1];
        visit[1] = true;
        dfs(1);
        System.out.println(cnt);
    }
}