package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Wedding implements Comparable<Wedding> {
        int start;
        int type;

        public Wedding(int start, int type) {
            this.start = start;
            this.type = type;
        }

        @Override
        public int compareTo(Wedding o) {
            if (start == o.start) return type - o.type;
            return start - o.start;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());

        ArrayList<Wedding> list = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Wedding(start, 1));
            list.add(new Wedding(end, -1));
        }

        Collections.sort(list);
        int max = Integer.MIN_VALUE;
        int current = 0;
        for (Wedding w : list) {
            current += w.type;
            max = Math.max(max, current);
        }

        System.out.print(max);
    }

}