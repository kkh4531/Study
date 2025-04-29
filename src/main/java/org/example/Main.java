package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int dx[] = {-1, 0, 1, 0}; // 12, 3, 6, 9
    static int dy[] = {0, 1, 0, -1}; // 12 3 6 9
    static int cnt = 0;
    static int board[][];

    public static void dfs(int x, int y) {
        if (x == 7 && y == 7) {
            cnt++;
        } else {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i]; // 12 -> 3 -> 6 -> 9 순으로 순회
                int ny = y + dy[i];
                if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0) { // nx, ny가 보드 좌표를 넘어가지 않고 다음 좌표가 벽이 아니면 이동
                    board[nx][ny] = 1;
                    dfs(nx, ny);
                    board[nx][ny] = 0; // 갔다왔으면 다시 체크 해제
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
        dfs(1, 1);
        System.out.println(cnt);
    }
}