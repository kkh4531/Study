package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static int solution(int n, int k, int arr[]) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int s = j + 1; s < n; s++) {
                    list.add(arr[i] + arr[j] + arr[s]);
                }
            }
        }
        if (k > list.size()) {
            return -1;
        }
        int result = 0;
        Collections.sort(list, Collections.reverseOrder());
        if (k == 1) {
            result = list.get(0);
        } else {
            int rank = 1;
            int previouse = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                if (previouse > list.get(i)) {
                    previouse = list.get(i);
                    rank++;
                }
                if (rank == k) {
                    result = list.get(i);
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int arr[] = new int[n];
        st = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(n, k, arr));
    }

}
