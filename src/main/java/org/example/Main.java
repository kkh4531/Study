package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
9. 숫자만 추출
설명

문자와 숫자가 섞여있는 문자열이 주어지면 그 중 숫자만 추출하여 그 순서대로 자연수를 만듭니다.

만약 “tge0a1h205er”에서 숫자만 추출하면 0, 1, 2, 0, 5이고 이것을 자연수를 만들면 1205이 됩니다.

추출하여 만들어지는 자연수는 100,000,000을 넘지 않습니다.


입력

첫 줄에 숫자가 섞인 문자열이 주어집니다. 문자열의 길이는 100을 넘지 않습니다.


출력

첫 줄에 자연수를 출력합니다.


예시 입력 1

g0en2T0s8eSoft
예시 출력 1

208
 */
public class Main {

    public static StringBuilder solution(int N, BufferedReader bufferedReader) throws Exception {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < N; i++) {
            char c[] = bufferedReader.readLine().toCharArray();
            int lt = 0, rt = c.length - 1;
            while (lt < rt) { // lt가 rt보다 적다면 연산 수행 즉 lt==rt, lt > rt가 되면 반복문 수행 x
                char temp = c[rt];
                c[rt] = c[lt];
                c[lt] = temp;
                lt++;
                rt--;
            }
            res.append(String.valueOf(c)).append('\n');
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        System.out.println(solution(N, bufferedReader));
    }

}
