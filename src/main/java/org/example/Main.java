package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
8. 등수구하기
설명

N명의 학생의 국어점수가 입력되면 각 학생의 등수를 입력된 순서대로 출력하는 프로그램을 작성하세요.

같은 점수가 입력될 경우 높은 등수로 동일 처리한다.

즉 가장 높은 점수가 92점인데 92점이 3명 존재하면 1등이 3명이고 그 다음 학생은 4등이 된다.


입력

첫 줄에 N(3<=N<=100)이 입력되고, 두 번째 줄에 국어점수를 의미하는 N개의 정수가 입력된다.


출력

입력된 순서대로 등수를 출력한다.


예시 입력 1

5
87 89 92 100 76
예시 출력 1

4 3 2 1 5
 */
public class Main {

    public static StringBuilder solution(int N, String str[]) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(str[i]);
            int grade = 1;
            for (int j = 0; j < N; j++) {
                if (j != i) { // 자기 자신이랑 비교하는 게 아니라면
                    if (temp < Integer.parseInt(str[j])) { // 자기 자신보다 점수가 높다면
                        grade++;
                    }
                }
            }
            sb.append(grade).append(" ");
        }
        return sb;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        String str[] = bufferedReader.readLine().split(" ");
        System.out.print(solution(N, str));
    }

}
