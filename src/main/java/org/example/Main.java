package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int dx[] = {-1, 0, 1, 0}; // 12, 3, 6, 9
    static int dy[] = {0, 1, 0, -1}; // 12 3 6 9
    static int board[][];
    static int dis[][];

    public static void bfs(int initX, int initY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{initX, initY});
        dis[1][1] = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int tmp[] = queue.poll();
                int x = tmp[0];
                int y = tmp[1];
                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0) {
                        board[nx][ny] = 1;
                        dis[nx][ny] = dis[x][y] + 1;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        board = new int[8][8];
        StringTokenizer st;
        for (int i = 1; i <= 7; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            for (int j = 1; j < 8; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        board[1][1] = 1;
        dis = new int[8][8];
        bfs(1 ,1);
        if (dis[7][7] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(dis[7][7]);
        }
    }
}