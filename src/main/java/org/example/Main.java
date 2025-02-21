package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
2. 보이는 학생
설명

선생님이 N명의 학생을 일렬로 세웠습니다. 일렬로 서 있는 학생의 키가 앞에서부터 순서대로 주어질 때, 맨 앞에 서 있는

선생님이 볼 수 있는 학생의 수를 구하는 프로그램을 작성하세요. (앞에 서 있는 사람들보다 크면 보이고, 작거나 같으면 보이지 않습니다.)


입력

첫 줄에 정수 N(5<=N<=100,000)이 입력된다. 그 다음줄에 N명의 학생의 키가 앞에서부터 순서대로 주어진다.


출력

선생님이 볼 수 있는 최대학생수를 출력한다.


예시 입력 1

8
130 135 148 140 145 150 150 153
예시 출력 1

5
 */
public class Main {
    // 1 가위 2 바위 3 보
    // 1이 이기는 경우 3 질 경우 2
    // 2가 이기는 경우 1 질 경우 3
    // 3이 이기는 경우 2 질 경우 1
    public static StringBuilder solution(int N, int A[], int B[]) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int a = A[i];
            int b = B[i];
            if (a == 1) {
                if (b == 1) {
                    sb.append("D");
                } else if (b == 2) {
                    sb.append("B");
                } else {
                    sb.append("A");
                }
            } else if (a == 2) {
                if (b == 1) {
                    sb.append("A");
                } else if (b == 2) {
                    sb.append("D");
                } else {
                    sb.append("B");
                }
            } else { // a가 3일 때
                if (b == 1) {
                    sb.append("B");
                } else if (b == 2) {
                    sb.append("A");
                } else {
                    sb.append("D");
                }
            }
            sb.append('\n');
        }
        return sb;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        int A[] = new int[N];
        int B[] = new int[N];
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        StringTokenizer st2 = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st2.nextToken());
        }

        System.out.println(solution(N, A, B));
    }


}
