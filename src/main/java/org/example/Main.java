package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int arr[];
    static int m;
    static ArrayList<int[]> house;
    static ArrayList<int[]> pizza;
    static int len;
    static PriorityQueue<Integer> pq;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];

        house = new ArrayList<>();
        pizza = new ArrayList<>();
        pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {//행
            st = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < n; j++) {//열
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 1) {
                    house.add(new int[]{i, j});
                } else if (tmp == 2) {
                    pizza.add(new int[]{i, j});
                }
            }
        }
        len = pizza.size();
        dfs(0, 0);
        System.out.println(pq.poll());
    }

    public static void dfs(int depth, int at) {
        if (depth == m) {
            pq.offer(sum());
        } else {
            for (int i = at; i < len; i++) {
                arr[depth] = i;
                dfs(depth + 1, i + 1);
            }
        }
    }

    public static int sum() {
        int sum = 0;
        int size = house.size();
        for (int i = 0; i < size; i++) {
            int getHouse[] = house.get(i);
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                int tmp[] = pizza.get(arr[j]);
                int y = getHouse[0] - tmp[0];
                int x = getHouse[1] - tmp[1];
                min = Math.min(min, Math.abs(y) + Math.abs(x));
            }
            sum += min;
        }
        return sum;
    }
}