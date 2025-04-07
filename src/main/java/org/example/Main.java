package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static int solution(int n, int t, int arr[]) {
        Arrays.sort(arr);
        int res = 0;
        int lt = 0;
        int rt = n - 1;
        while (lt <= rt) {
            int mid = (rt + lt) / 2;
            if (arr[mid] == t) {
                res = mid + 1;
                break;
            } else if (arr[mid] > t) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bufferedReader.readLine());
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(n, t, arr));
    }
}
