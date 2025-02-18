package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
10. 가장 짧은 문자거리
설명

한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.


입력

첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.

문자열의 길이는 100을 넘지 않는다.


출력

첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.


예시 입력 1

teachermode e
예시 출력 1

1 0 1 2 1 0 1 2 2 1 0
 */
public class Main {
    public static StringBuilder solution(String str1, String str2) {
        ArrayList<Integer> indexes = new ArrayList<>();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == str2.charAt(0)) {
                indexes.add(i); // 문자 t의 인덱스 위치를 가지고 있는 리스트 정의 완료
            }
        }

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == str2.charAt(0)) { // 문자열 s의 인덱스 i가 문자 t와 같다면 그 자체니깐 0
                res.append(0).append(" ");
                continue;
            }
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < indexes.size(); j++) { // 현재 문자열 s의 i번째인 문자와 문자 t의 인덱스들과 비교 후 최솟값 찾는다.
                int temp = Math.abs(i - indexes.get(j));
                if (temp < min) {
                    min = temp;
                }
            }
            res.append(min).append(" ");
        }
        res.deleteCharAt(res.length() - 1);
        return res;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str[] = bufferedReader.readLine().split(" ");
        System.out.println(solution(str[0], str[1]));
    }

}
