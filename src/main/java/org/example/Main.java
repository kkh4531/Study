package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int m;
    static int n;
    static int board[][];
    static boolean flag = false;
    static int dis[][];
    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {-1, 0, 1, 0};
    static int max = Integer.MIN_VALUE;

    public static void bfs(Queue<int[]> initQueue) {
        Queue<int[]> queue = new LinkedList<>();
        int size = initQueue.size();
        for (int i = 0; i < size; i++) {
            queue.offer(initQueue.poll());
        }
        while (!queue.isEmpty()) {
            int tmp[] = queue.poll();
            int cy = tmp[0]; // 행 -> y
            int cx = tmp[1]; // 열 -> x
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i]; // 열
                int ny = cy + dy[i]; // 행
                if (nx >= 1 && nx <= m && ny >= 1 && ny <= n && board[ny][nx] == 0) {
                    flag = true;
                    board[ny][nx] = 1;
                    queue.offer(new int[]{ny, nx});
                    dis[ny][nx] = dis[cy][cx] + 1;
                    max = Math.max(dis[cy][cx] + 1, max);
                }
            }
        }
    }

    public static boolean fail() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (board[i][j] == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        board = new int[n + 1][m + 1];
        dis = new int[n + 1][m + 1];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            for (int j = 1; j <= m; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == -1) {
                    board[i][j] = -1;
                } else if (tmp == 1) {
                    board[i][j] = 1;
                    queue.offer(new int[]{i, j});
                }
            }
        }
        bfs(queue);
        StringBuilder sb = new StringBuilder();
        if (!flag) { // 처음부터 다 익은 토마토이면
            sb.append(0);
        } else {
            if (fail()) { // 토마토가 모두 익지 못하는 상황
                sb.append(-1);
            } else { // 정상적인 상황
                sb.append(max);
            }
        }
        System.out.println(sb);
    }
}