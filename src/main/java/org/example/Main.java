package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
6. 뒤집은 소수
설명

N개의 자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 그 소수를 출력하는 프로그램을 작성하세요.

예를 들어 32를 뒤집으면 23이고, 23은 소수이다. 그러면 23을 출력한다. 단 910를 뒤집으면 19로 숫자화 해야 한다.

첫 자리부터의 연속된 0은 무시한다.


입력

첫 줄에 자연수의 개수 N(3<=N<=100)이 주어지고, 그 다음 줄에 N개의 자연수가 주어진다.

각 자연수의 크기는 100,000를 넘지 않는다.


출력

첫 줄에 뒤집은 소수를 출력합니다. 출력순서는 입력된 순서대로 출력합니다.


예시 입력 1

9
32 55 62 20 250 370 200 30 100
예시 출력 1

23 2 73 2 3
 */
public class Main {

    public static StringBuilder solution(int N, String str[]) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            char c[] = str[i].toCharArray();
            int lt = 0, rt = c.length - 1;
            while (lt < rt) {
                char temp = c[lt];
                c[lt] = c[rt];
                c[rt] = temp;
                lt++;
                rt--;
            }
            String tmp = new String(c);
            if (isPrime(Integer.parseInt(tmp))) {
                sb.append(Integer.parseInt(tmp)).append(" ");
            }
        }
        return sb;
    }

    public static boolean isPrime(int n) {
        if (n == 0 || n == 1) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        String str[] = bufferedReader.readLine().split(" ");
        System.out.print(solution(N, str));
    }

}
