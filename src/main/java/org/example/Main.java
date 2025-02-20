package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static String solution(String str[]) {
        String temp[] = new String[str.length];
        String res = "";
        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < 7; j++) {
                if (str[i].charAt(j) == '#') {
                    temp[i] += "1";
                } else {
                    temp[i] += "0";
                }
            }
            temp[i] = temp[i].substring(4);
            int decimal = Integer.parseInt(temp[i], 2);
            res += (char) decimal;
        }

        return res;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        String str = bufferedReader.readLine();
        String res[] = new String[N];
        for (int i = 0; i < N; i++) {
            res[i] = str.substring(0, 7);
            str = str.substring(7);
        }
        System.out.println(solution(res));
    }

}
