package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int solution(int n, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            dq.addLast(i);
        }
        while (dq.size() != 1) {
            for (int i = 0; i < k - 1; i++) {
                dq.addLast(dq.pollFirst());
            }
            dq.removeFirst();
        }
        return dq.poll();
    }
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(solution(n, k));
    }

}
