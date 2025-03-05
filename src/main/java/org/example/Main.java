package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
 */
public class Main {
// 2중 반복문을 쓰면 시간 초과가 뜨게 된다.
    // sum에서 i-k 번째 인덱스를 빼고 현재 i를 더해주면서 나아가면 1중 반복문으로도 풀 수 있다.
    public static int solution(int n, int k, int arr[]) {
        int max = 0;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        max = sum;
        for (int i = k; i < n; i++) {
            sum = sum - arr[i - k] + arr[i];
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int arr[] = new int[N];
        st = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, K, arr));
    }

}
