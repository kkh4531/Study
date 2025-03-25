package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int solution(int n, int arr[][], int k, int moves[]) {
        int result = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            int crane = moves[i]; // 열
            for (int j = 0; j < n; j++) { // 행
                if (arr[j][crane - 1] != 0) {
                    if (!dq.isEmpty()) { // stack이 비어있지 않다면
                        if (dq.getLast() == arr[j][crane - 1]) { // stack의 마지막 숫자가 넣으려는 숫자와 같다면
                            dq.removeLast();
                            result += 2;
                        } else {
                            dq.addLast(arr[j][crane - 1]);
                        }
                    } else {
                        dq.addLast(arr[j][crane - 1]);
                    }
                    arr[j][crane - 1] = 0;
                    break;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        int arr[][] = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int k = Integer.parseInt(bufferedReader.readLine());
        int moves[] = new int[k];
        st = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < k; i++) {
            moves[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(n, arr, k, moves));
    }

}
