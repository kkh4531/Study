package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static String solution(String str[]) {
        String res = "";
        for (int i = 0; i < str.length; i++) {
            String temp = str[i].replace('#', '1').replace('*', '0');
            res += (char) Integer.parseInt(temp, 2);
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
