package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
유클리드 호제법 (Euclidean Algorithm)
유클리드 호제법이라고도 불리는 유클리드 알고리즘은 둘 이상의 정수의 최대공약수(GCD)를 구하는 알고리즘이다.


유클리드 호제법은

큰 수(num1)와 작은 수(num2) 사이의 최대 공약수는 큰 수를 작은 수로 나눈 나머지(R)와 작은 수(num2) 사이의 최대 공약수와 같다는 점을 반복하여 문제를 해결한다.



기본적인 방법은 다음과 같다.


큰 수(num1)에서 작은 수(num2)를 나눈다.
나머지가 0이 아니라면, 나머지와 작은 수(num2)로 1번부터 다시 시작한다.
 1~ 2 과정을 반복해 나머지가 0이라면, 그 수가 최대 공약수이다.


예를 들어, 21과 49 가 있다. mod 연산을 진행하면,

49 mod 21 = 7

나머지가 0이 아니므로,  나머지인 7과 작은 수인 21로 mod 연산을 진행한다.

21 mod 7 = 0



나머지가 0이므로 21과 49의 최대 공약수는 7이다.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] str = bufferedReader.readLine().split(":");

        int n = Integer.parseInt(str[0]), m = Integer.parseInt(str[1]);
        int max = n;
        int min = m;
        if (m > n) {

        }
        int gcd = gcd(n, m);

        System.out.println(n / gcd + ":" + m / gcd);
    }

    public static int gcd(int n, int m) {
        int max = n;
        int min = m;
        if (m > n) {
            max = m;
            min = n;
        }
        if (max % min == 0) {
            return min;
        } else {
            return gcd(min, max % min);
        }
    }

}
