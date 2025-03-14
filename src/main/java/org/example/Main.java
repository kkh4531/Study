package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static String solution(char c1[], char c2[]) {
        Arrays.sort(c1);
        Arrays.sort(c2);
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i]) {
                return "NO";
            }
        }
        return "YES";
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String str1 = bufferedReader.readLine();
        char c1[] = str1.toCharArray();
        String str2 = bufferedReader.readLine();
        char c2[] = str2.toCharArray();
        System.out.println(solution(c1, c2));
    }

}
