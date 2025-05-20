package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int solution(int n, BufferedReader bufferedReader) throws Exception {
        ArrayList<int[]> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
            int height = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            people.add(new int[]{height, weight});
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int cp[] = people.get(i);
            int height = cp[0];
            int weight = cp[1];
            boolean flag = false;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    int otherP[] = people.get(j);
                    int otherHeight = otherP[0];
                    int otherWeight = otherP[1];
                    if (otherHeight > height && otherWeight > weight) { // 자기보다 크고 무거운 사람이 있으면 선발 x
                        flag = true;
                        break;
                    }
                }
            }
            if (!flag) {
                cnt++;
            }
        }
        return cnt;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        System.out.println(solution(n, bufferedReader));
    }
}