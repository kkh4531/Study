package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static StringBuilder solution(int n, int arr[]) {
        int tmp[] = arr.clone();
        Arrays.sort(tmp);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (arr[i] != tmp[i]) {
                sb.append(i + 1).append(" ");
            }
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
