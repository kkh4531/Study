package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static StringBuilder solution(int n, int arr[]) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n; i++) {
            int tempIdx = i;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[tempIdx] < arr[j]) {
                    int temp = arr[tempIdx];
                    arr[tempIdx] = arr[j];
                    arr[j] = temp;
                    tempIdx--;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append(" ");
        }
        return sb;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());

        int arr[] = new int[n];
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(n, arr));
    }

}
