package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static boolean visit[];
    static ArrayList<ArrayList<Integer>> graph;
    static int n;

    public static StringBuilder bfs(int v) {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visit[v] = true;
        int L = 0;
        while (!queue.isEmpty()) {
            sb.append(L).append(" : ");
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int cv = queue.poll();
                sb.append(cv).append(" ");
                for (int nv : graph.get(cv)) {
                    if (!visit[nv]) {
                        visit[nv] = true;
                        queue.offer(nv);
                    }
                }
            }
            L++;
            sb.append('\n');
        }
        return sb;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visit = new boolean[n + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
        }
        System.out.println(bfs(1));
    }
}