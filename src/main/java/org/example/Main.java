package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
12. 멘토링
설명

현수네 반 선생님은 반 학생들의 수학점수를 향상시키기 위해 멘토링 시스템을 만들려고 합니다.

멘토링은 멘토(도와주는 학생)와 멘티(도움을 받는 학생)가 한 짝이 되어 멘토가 멘티의 수학공부를 도와주는 것입니다.

선생님은 M번의 수학테스트 등수를 가지고 멘토와 멘티를 정합니다.

만약 A학생이 멘토이고, B학생이 멘티가 되는 짝이 되었다면, A학생은 M번의 수학테스트에서 모두 B학생보다 등수가 앞서야 합니다.

M번의 수학성적이 주어지면 멘토와 멘티가 되는 짝을 만들 수 있는 경우가 총 몇 가지 인지 출력하는 프로그램을 작성하세요.


입력

첫 번째 줄에 반 학생 수 N(1<=N<=20)과 M(1<=M<=10)이 주어진다.

두 번째 줄부터 M개의 줄에 걸쳐 수학테스트 결과가 학생번호로 주어진다. 학생번호가 제일 앞에서부터 1등, 2등, ...N등 순으로 표현된다.

만약 한 줄에 N=4이고, 테스트 결과가 3 4 1 2로 입력되었다면 3번 학생이 1등, 4번 학생이 2등, 1번 학생이 3등, 2번 학생이 4등을 의미합니다.


출력

첫 번째 줄에 짝을 만들 수 있는 총 경우를 출력합니다.


예시 입력 1

4 3
3 4 1 2
4 3 2 1
3 1 4 2
예시 출력 1

3
힌트

출력설명


 */
public class Main {

    public static int solution(int n, int m, int arr[][]) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            int mentor = arr[0][i];
            int temps[] = new int[n - i - 1];
            boolean bools[] = new boolean[n - i - 1]; // 처음엔 다 false로 돼 있다.
            for (int j = 0; j < temps.length; j++) {
                temps[j] = arr[0][i + j + 1];
            }
            for (int j = 0; j < temps.length; j++) {
                int mentee = temps[j];
                for (int k = 1; k < m; k++) {
                    int a = 0, b = 0;
                    for (int l = 0; l < n; l++) {
                        if (mentor == arr[k][l]) {
                            a = l;
                        } else if (mentee == arr[k][l]) {
                            b = l;
                        }
                    }
                    if (b < a) {
                        bools[j] = true;
                        break;
                    }
                }
            }
            for (int j = 0; j < temps.length; j++) {
                if (!bools[j]) {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(st.nextToken()); // 학생 수
        int M = Integer.parseInt(st.nextToken()); // 수학테스트 수
        int arr[][] = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(solution(N, M, arr));
    }

}
