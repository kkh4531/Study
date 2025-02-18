package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
11. 문자열 압축
설명

알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는

문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.

단 반복횟수가 1인 경우 생략합니다.


입력

첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.


출력

첫 줄에 압축된 문자열을 출력한다.


예시 입력 1

KKHSSSSSSSE
예시 출력 1

K2HS7E
예시 입력 2

KSTTTSEEKFKKKDJJGG
예시 출력 2

KST3SE2KFK3DJ2G2
 */
public class Main {
    public static StringBuilder solution(String str) {
        StringBuilder res = new StringBuilder();
        char old = str.charAt(0);
        int cnt = 1;
        for (int i = 1; i < str.length(); i++) {
            char c = str.charAt(i); // 현재 문자
            if (old == c) { // 전 문자와 현재 문자가 같은 경우
                cnt++;
            } else { // 전 문자와 현재 문자가 다를 경우
                if (cnt == 1) {
                    res.append(old);
                } else {
                    res.append(old).append(cnt);
                }
                cnt = 1;
            }
            old = c;
            if (i == str.length() - 1) { // 마지막 인덱스
                // 마지막 인덱스가 하나인 경우
                if (cnt == 1) {
                    res.append(old);
                } else { // 마지막 인덱스가 계속 이어지는 경우
                    res.append(old).append(cnt);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();
        System.out.println(solution(str));
    }

}
