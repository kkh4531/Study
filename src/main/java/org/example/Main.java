package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int unf[];

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        unf = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            unf[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Union(a, b);
        }

        st = new StringTokenizer(bufferedReader.readLine());
        int tX = Integer.parseInt(st.nextToken());
        int tY = Integer.parseInt(st.nextToken());

        System.out.print(find(tX) != find(tY) ? "NO" : "YES");
    }

    private static void Union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) unf[fa] = fb;
    }

    private static int find(int v) {
        if (v == unf[v]) return unf[v];
        else return unf[v] = find(unf[v]);
    }
}