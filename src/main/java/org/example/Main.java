package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
4. 피보나치 수열
설명

1) 피보나키 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.

2) 입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.


입력

첫 줄에 총 항수 N(3<=N<=45)이 입력된다.


출력

첫 줄에 피보나치 수열을 출력합니다.


예시 입력 1

10
예시 출력 1

1 1 2 3 5 8 13 21 34 55
 */
public class Main {

    public static int arr[];

    public static int solution(int N) {
        if (N == 0) {
            return 0;
        } else if (N == 1) {
            return 1;
        } else if (arr[N] != 0) { // 첫 번째 0은 이미 맨 처음 if에서 걸러짐
            return arr[N];
        }
        arr[N] = solution(N - 2) + solution(N - 1);
        return arr[N];
    }
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());

        arr = new int[N+1];
        arr[0] = 0;
        arr[1] = 1;
        solution(N);
        for (int i = 1; i < N + 1; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
