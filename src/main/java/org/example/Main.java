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

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (!visit[i][j] && board[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    visit[i][j] = true;
                    while (!queue.isEmpty()) {
                        int tmp[] = queue.poll();
                        int cy = tmp[0];
                        int cx = tmp[1];
                        for (int k = 0; k < 8; k++) {
                            int ny = cy + dy[k];
                            int nx = cx + dx[k];
                            if (ny >= 1 && ny <= n && nx >= 1 && nx <= n && board[ny][nx] == 1 && !visit[ny][nx]) {
                                visit[ny][nx] = true;
                                queue.offer(new int[]{ny, nx});
                            }
                        }
                    }
                    cnt++;
                    i = 1;
                    j = 1;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bufferedReader.readLine());
        visit = new boolean[n + 1][n + 1];
        board = new int[n + 1][n + 1];

        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            for (int j = 1; j <= n; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 1) {
                    board[i][j] = 1;
                }
            }
        }
        bfs();
        System.out.println(cnt);
    }
}