package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static boolean visit[][];
    static int board[][];
    static int n;
    static int dy[] = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int dx[] = {0, 1, 1, 1, 0, -1, -1, -1};
    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bufferedReader.readLine());
        board = new int[n + 1][n + 1];
        visit = new boolean[n + 1][n + 1];

        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            for (int j = 1; j <= n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (board[i][j] == 1 && !visit[i][j]) {
                    visit[i][j] = true;
                    dfs(i, j);
                    cnt++;
                    i = 1;
                    j = 1;
                }
            }
        }

        System.out.println(cnt);
    }

    public static void dfs(int cy, int cx) {
        for (int i = 0; i < 8; i++) {
            int ny = cy + dy[i];
            int nx = cx + dx[i];
            if (nx >= 1 && nx <= n && ny >= 1 && ny <= n && board[ny][nx] == 1 && !visit[ny][nx]) {
                visit[ny][nx] = true;
                dfs(ny, nx);
            }
        }
    }
}