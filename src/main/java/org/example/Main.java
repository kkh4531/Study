package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
5. 소수(에라토스테네스 체)
설명

자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.

만약 20이 입력되면 1부터 20까지의 소수는 2, 3, 5, 7, 11, 13, 17, 19로 총 8개입니다.


입력

첫 줄에 자연수의 개수 N(2<=N<=200,000)이 주어집니다.


출력

첫 줄에 소수의 개수를 출력합니다.


예시 입력 1

20
예시 출력 1

8
 */
public class Main {
//에라토스테네스의 체
    //소수가 되는 수를 찾고 그 수의 배수들을 싹 다 없앤다.

    //true이면 소수x false이면 소수
    public static int solution(int N) {
        int res = 0;
        for (int i = 2; i <= N; i++) {
            if (!arr[i]) { // false이면 즉 아직 소수인지 검증이 안된 얘면 or 소수이면
                for (int j = i + i; j <= N; j += i) {
                    arr[j] = true;
                }
                res++;
            }
        }
        return res;
    }

    public static boolean arr[];

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());

        System.out.println(solution(N));

    }

}
