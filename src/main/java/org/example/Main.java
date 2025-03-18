package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static StringBuilder solution(int n, int k, int arr[]) {
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        sb.append(map.size()).append(" ");

        int lt = 0;
        for (int i = k; i < n; i++) {
            map.put(arr[lt], map.get(arr[lt]) - 1);
            if (map.get(arr[lt]) == 0) {
                map.remove(arr[lt]);
            }
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            lt++;
            sb.append(map.size()).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bufferedReader.readLine());
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(n, k, arr));
    }

}
