package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int n;
    static int c;
    static int arr[];

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bufferedReader.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        System.out.println(solution());
    }

    public static int solution() {
        int result = 0;
        int lt = 1;
        int rt = arr[n - 1] - 1;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (func(mid)) { // true = cnt >= c;
                result = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }
        return result;
    }

    public static boolean func(int d) {
        int cnt = 1;
        int ep = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] - ep >= d) {
                cnt++;
                ep = arr[i];
            }
        }
        return cnt >= c;
    }
}
