package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int arr[];
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bufferedReader.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution());
    }
    public static int solution() {
        int result = 0;
        int lt = arr[n - 1];
        int rt = 0;
        for (int i = 0; i < n; i++) {
            rt += arr[i];
        }
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (func(mid)) { // m 이하이면
                result = mid;
                rt = mid - 1;
            } else { // m 초과이면
                lt = mid + 1;
            }
        }
        return result;
    }
    public static boolean func(int t) {
        int sum = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum > t) {
                sum = arr[i];
                cnt++;
            }
        }
        cnt++;
        return cnt <= m;
    }
}
