package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int data;
    Node rt, lt;

    public Node(int data) {
        this.data = data;
    }
}

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static boolean[] visit;
    public static int n;
    public static void dfs(int L) {
        if (L >= n + 1) {
            for (int i = 1; i < visit.length; i++) {
                if (visit[i]) {
                    sb.append(i).append(" ");
                }
            }
            sb.append('\n');
            return;
        } else {
            visit[L] = true;
            dfs(L + 1);
            visit[L] = false;
            dfs(L + 1);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());
        visit = new boolean[n + 1];
        dfs(1);
        System.out.println(sb);
    }
}
