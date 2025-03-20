package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static int solution(String s, String t) {
        String str = "";
        int cnt = 0;
        for (int i = 0; i < t.length(); i++) {
            str += s.charAt(i);
        }
        if (isAnagram(t, str)) {
            cnt++;
        }
        int lt = 1;
        for (int i = t.length(); i < s.length(); i++) {
            str = s.substring(lt++, i + 1);
            if (isAnagram(t, str)) {
                cnt++;
            }
        }
        return cnt;
    }

    public static boolean isAnagram(String target, String str) {
        char targetChar[] = target.toCharArray();
        Arrays.sort(targetChar);
        char strToChar[] = str.toCharArray();
        Arrays.sort(strToChar);
        for (int i = 0; i < target.length(); i++) {
            if (targetChar[i] != strToChar[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s = bufferedReader.readLine();
        String t = bufferedReader.readLine();

        System.out.println(solution(s, t));
    }

}
