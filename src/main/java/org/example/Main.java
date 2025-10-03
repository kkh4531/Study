package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Lecture implements Comparable<Lecture> {
        private int price;
        private int days;

        public Lecture(int price, int days) {
            this.price = price;
            this.days = days;
        }

        @Override
        public int compareTo(Lecture o) {
            return o.days - this.days;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());

        Lecture lecs[] = new Lecture[n];

        StringTokenizer st;
        int maxDay = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int price = Integer.parseInt(st.nextToken());
            int days = Integer.parseInt(st.nextToken());
            lecs[i] = new Lecture(price, days);
            maxDay = Math.max(maxDay, days);
        }

        Arrays.sort(lecs);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int res = 0;
        int idx = 0;
        for (int i = maxDay; i > 0; i--) {
            for (int j = idx; j < n; j++) {
                if (lecs[j].days == i) {
                    pq.offer(lecs[j].price);
                } else {
                    idx = j;
                    break;
                }
            }
            if (!pq.isEmpty()) res += pq.poll();
        }
        System.out.print(res);

    }
}