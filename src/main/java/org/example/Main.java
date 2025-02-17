package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
9. 숫자만 추출
설명

문자와 숫자가 섞여있는 문자열이 주어지면 그 중 숫자만 추출하여 그 순서대로 자연수를 만듭니다.

만약 “tge0a1h205er”에서 숫자만 추출하면 0, 1, 2, 0, 5이고 이것을 자연수를 만들면 1205이 됩니다.

추출하여 만들어지는 자연수는 100,000,000을 넘지 않습니다.


입력

첫 줄에 숫자가 섞인 문자열이 주어집니다. 문자열의 길이는 100을 넘지 않습니다.


출력

첫 줄에 자연수를 출력합니다.


예시 입력 1

g0en2T0s8eSoft
예시 출력 1

208
 */
public class Main {

    public static String solution(String str) {
        String answer = "";
        int max = Integer.MIN_VALUE;
        int pos;
        while((pos = str.indexOf(' ')) != -1) { // 공백을 발견하는 인덱스 위치(pos) 즉 공백을 발견한 인덱스 위치가 -1이 아니면 true
            String temp = str.substring(0, pos);
            int size = temp.length();
            if (size > max) {
                max = size;
                answer = temp;
            }
            str = str.substring(pos + 1); // 원본 str에서 pos는 공백이니까 pos +1부터해서 문자열을 자른다.
        } // 여기까지 한다면 마지막 단어는 검사를 못한다 왜냐면 study 뒤에는 공백이 없기 때문에
        // 그러면 마지막 단어도 검사해야한다면
        if (str.length() > max) { // 현재 str은 맨 마지막 단어를 가지고 있다.
            answer = str;
        }
        return answer;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String str = bufferedReader.readLine();

        System.out.println(solution(str));
    }

}
