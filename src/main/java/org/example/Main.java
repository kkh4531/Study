package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
9. 격자판 최대합
설명

5*5 격자판에 아래롸 같이 숫자가 적혀있습니다.

Image1.jpg

N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가 장 큰 합을 출력합니다.


입력

첫 줄에 자연수 N이 주어진다.(2<=N<=50)

두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.


출력

최대합을 출력합니다.


예시 입력 1

5
10 13 10 12 15
12 39 30 23 11
11 25 50 53 15
19 27 29 37 27
19 13 30 13 19
예시 출력 1

155
 */
public class Main {

    public static int solution(int N, BufferedReader bufferedReader) throws Exception {
        int arr[][] = new int[N][N];
        for (int i = 0; i < N; i++) {
            String inputs[] = bufferedReader.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(inputs[j]);
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) { // 행의 합
            int sum = 0;
            for (int j = 0; j < N; j++) {
                sum += arr[i][j];
            }
            if (sum > max) {
                max = sum;
            }
        }
        for (int i = 0; i < N; i++) { // 열의 합
            int sum = 0;
            for (int j = 0; j < N; j++) {
                sum += arr[j][i];
            }
            if (sum > max) {
                max = sum;
            }
        }
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i][i];
        }
        if (sum > max) {
            max = sum;
        }
        sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i][N - i - 1];
        }
        if (sum > max) {
            max = sum;
        }

        return max;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        System.out.print(solution(N, bufferedReader));
    }

}
