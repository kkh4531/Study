package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
2. 공통원소 구하기
설명

A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 작성하세요.


입력

첫 번째 줄에 집합 A의 크기 N(1<=N<=30,000)이 주어집니다.

두 번째 줄에 N개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.

세 번째 줄에 집합 B의 크기 M(1<=M<=30,000)이 주어집니다.

네 번째 줄에 M개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.

각 집합의 원소는 1,000,000,000이하의 자연수입니다.


출력

두 집합의 공통원소를 오름차순 정렬하여 출력합니다.


예시 입력 1

5
1 3 9 5 2
5
3 2 5 7 8
예시 출력 1

2 3 5
 */
public class Main {

    public static StringBuilder solution(int n, int m, int a[], int b[]) {
        StringBuilder sb = new StringBuilder();
        Arrays.sort(a); // 투 포인터를 쓰려면 정렬이 돼있어야 한다.
        Arrays.sort(b);
        int pa = 0, pb = 0;
        while (pa < n && pb < m) {
            if (a[pa] == b[pb]) { // 같을 경우 둘 다 ++ 시켜준다. 안해줘도 출력은 똑같지만 연산 시간이 더 걸린다.
                sb.append(a[pa++]).append(" ");
                pb++;
            } else if (a[pa] < b[pb]) { // 숫자가 더 작은 애를 ++ 시킨다.
                pa++;
            } else {
                pb++;
            }
        }
        return sb;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int a[] = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer st2 = new StringTokenizer(bufferedReader.readLine());
        int b[] = new int[M];
        for (int i = 0; i < M; i++) {
            b[i] = Integer.parseInt(st2.nextToken());
        }
        System.out.println(solution(N, M, a, b));
    }

}
