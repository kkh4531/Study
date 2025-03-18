package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static StringBuilder solution(int n, int k, int arr[]) {
        StringBuilder sb = new StringBuilder();
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < k; i++) {
            set.add(arr[i]);
        }
        sb.append(set.size()).append(" ");

        int lt = 0;
        for (int i = k; i < n; i++) {
            boolean flag = true;
            for (int j = lt + 1; j < i; j++) { // lt+1부터 i 전까지 즉 지금 삭제하려는 arr[lt] 이후의 윈도우 안에 같은 값이 있는지 확인하는 반복문
                if (arr[lt] == arr[j]) {
                    flag = false; // flag가 false이면 지금 삭제하려는 arr[lt] 값이 또 있는 것
                }
            }
            if (flag) { // arr[lt]를 제외한 윈도우 안에 arr[lt]와 같은 값이 없음.
                set.remove(arr[lt]);
            }
            set.add(arr[i]);
            sb.append(set.size()).append(" ");
            lt++;
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
