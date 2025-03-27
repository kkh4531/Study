package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int solution(int n, int m, LinkedList<int[]> list) {
        int result = 0;
        int cnt = 1;
        while (true) {
            int max = list.peek()[0];
            int maxPos = 0;
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i)[0] > max) {
                    max = list.get(i)[0];
                    maxPos = i;
                }
            }
            for (int i = 0; i < maxPos; i++) {
                list.add(list.poll());
            }
            int first[] = list.poll();
            if (first[1] == 1) {
                result = cnt;
                break;
            }
            cnt++;
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bufferedReader.readLine());
        LinkedList<int[]> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (i == m) {
                int temp[] = {Integer.parseInt(st.nextToken()), 1};
                list.add(temp);
            } else {
                int temp[] = {Integer.parseInt(st.nextToken()), 0};
                list.add(temp);
            }
        }
        System.out.println(solution(n, m, list));
    }

}
