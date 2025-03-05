package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
1. 두 배열 합치기
설명

오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.


입력

첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다.

두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.

세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다.

네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.

각 리스트의 원소는 int형 변수의 크기를 넘지 않습니다.


출력

오름차순으로 정렬된 배열을 출력합니다.


예시 입력 1

3
1 3 5
5
2 3 6 7 9
예시 출력 1

1 2 3 3 5 6 7 9
 */
public class Main {

    public static StringBuilder solution(int n, int m, int a[], int b[]) {
        StringBuilder sb = new StringBuilder();
        int pa = 0, pb = 0;
        while (pa < n && pb < m) {
            if (a[pa] > b[pb]) { // a[pa]가 클 경우에만 출력
                sb.append(b[pb++]).append(" ");
            } else { // b[pb]가 클 때 출력 + a[pa]랑 b[pb]가 같은 경우도 b[pb]를 출력하고 ++
                sb.append(a[pa++]).append(" ");
            }
        }
        //이제 어느 한 쪽은 배열의 끝까지 도달했다. 그러면 나머지 남은 배열을 쭈루룩 그대로 갖다 붙인다.
        while (pa < n) { // 배열 b가 먼저 다 끝났다면 a 배열 나머지들을 출력할 것이다.
            sb.append(a[pa++]).append(" ");
        }
        while (pb < m) { // 배열 a가 먼저 다 끝났다면 b 배열 나머지들을 출력할 것이다.
            sb.append(b[pb++]).append(" ");
        }
        // a,b 중 누가 먼저 끝났는 지 알 수 없으니 둘 다 반복문 실행한 것. 끝난 쪽은 반복문이 실행되지 않겠지?
        return sb;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        int a[] = new int[N];
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(bufferedReader.readLine());
        int b[] = new int[M];
        st = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0 ; i < M; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(N, M, a, b));
    }

}
