package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
7. 회문 문자열
설명

앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 회문 문자열이라고 합니다.

문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 “NO"를 출력하는 프로그램을 작성하세요.

단 회문을 검사할 때 대소문자를 구분하지 않습니다.


입력

첫 줄에 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다.


출력

첫 번째 줄에 회문 문자열인지의 결과를 YES 또는 NO로 출력합니다.


예시 입력 1

gooG
예시 출력 1

YES
 */
public class Main {

    public static String solution(String str) {
        String reverseStr = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reverseStr += str.charAt(i);
        }
        boolean check = true;
        for (int i = 0; i < str.length(); i++) {
            if (!(str.charAt(i) == reverseStr.charAt(i))) {
                check = false;
            }
        }
        if (check) {
            return "YES";
        }
        return "NO";
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {
            String temp = bufferedReader.readLine();
            int size = (int) Math.sqrt(temp.length());
            char c[][] = new char[size][size];
            //RST EEO TCP
            //temp를 c[][]에 할당하면 됨.
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    //c[j][k] = temp.
                }
            }
        }
    }

}
